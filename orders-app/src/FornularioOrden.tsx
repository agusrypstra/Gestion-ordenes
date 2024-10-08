import React, { useState,useEffect } from 'react';
import axios from 'axios';
import Select from 'react-select';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Order } from './interfaces/Order';
import { Cliente } from './interfaces/Cliente';
import { TipoOrden } from './interfaces/TipoOrden';

const FormularioOrden: React.FC = () => {
  
  const [clienteId, setClienteId] = useState<number>(0);
  const [descripcion, setDescripcion] = useState<string>("");
  const [fechaCreacion, setFechaCreacion] = useState<string>("");  

  const[clientes,setClientes] = useState<Cliente[]>([])
  const[ordersType,setOrdersType] = useState<TipoOrden[]>([])

  const[idTipoOrder,setSelectedOrderType] = useState<number | 0>(0)
  const[selectedClient,setSelectedClient] = useState<number | 0>(0);

  useEffect(() => {
    const fetchClientes = async ()=>{
      try {
        const response = await axios.get('http://localhost:8080/api/clients')
        setClientes(response.data);
        console.log(response.data)

      } catch (error) {
        console.log("Error: " + error)
      }
    };
    fetchClientes();
  },[]);

  useEffect(() => {
    // Fetch para obtener los tipos de orden
    const fetchTiposOrden = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/order-type");
        setOrdersType(response.data);
        console.log(response.data)
      } catch (error) {
        console.error('Error al obtener los tipos de orden:', error);
      }
    };
    fetchTiposOrden();
  },[]);

// Mapeo de clientes a opciones para el select
const clienteOptions = clientes.map(cliente => ({
  value: cliente.id,
  label: `${cliente.nombre} ${cliente.apellido}`
}));
const handleClienteChange = (selectedOption: any) => {
  setSelectedClient(selectedOption ? selectedOption.value : null);
  setClienteId(selectedClient)
};
const ordersOptions = ordersType.map(orderType => ({
  value: orderType.id,
  label: `${orderType.nombre_tipo}`
}));
const handleTypeChange = (selectedOption:any)=>{
  setSelectedOrderType(selectedOption ? selectedOption.value : null);
}

  const handleSubmit = async (event: React.FormEvent) => {
    event.preventDefault();
    setFechaCreacion(new Date().toISOString());
    const nuevaOrden: Order = {
      "clienteId": 1,
      "idTipoOrden":idTipoOrder,
      "descripcion": "Nueva Orden",
      "fechaCreacion": fechaCreacion,
      "idUsuarioCreador":1
    };
    console.log(nuevaOrden)
    try {
      const response = await axios.post('http://localhost:8080/api/orders', nuevaOrden);
      console.log('Orden creada:', response.data);
    } catch (error) {
      console.error('Error al crear la orden:', error);
    }
  };
  return (
    <form onSubmit={handleSubmit} className="container mt-4">
      {/* Campo para el nombre del cliente */}
      <div className="mb-3">
        <label htmlFor="cliente">Cliente</label>
        <Select 
          options={clienteOptions}
          onChange={handleClienteChange}
          placeholder="Seleccionar cliente"
        />
      </div>

      {/* Campo para la descripción de la orden */}
      <div className="mb-3">
        <label htmlFor="descripcion" className="form-label">Descripción de la Orden:</label>
        <textarea
          id="descripcion"
          className="form-control"
          rows={3}
          value={descripcion}
          onChange={(e) => setDescripcion(e.target.value)}
          required
        />
      </div>

      {/* Selección del tipo de orden */}
      <div className="mb-3">
        <label htmlFor="tipoOrden">Tipo de Orden:</label>
        <Select
          options={ordersOptions}
          onChange={handleTypeChange}
          placeholder={"Seleccionar tipo de orden"}
        />
      </div>

      {/* Botón de envío */}
      <button type="submit" className="btn btn-primary">Enviar Orden</button>
    </form>
  );
};

export default FormularioOrden;