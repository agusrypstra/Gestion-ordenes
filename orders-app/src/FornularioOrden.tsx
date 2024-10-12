import React, { useState,useEffect } from 'react';
import axios from 'axios';
import Select from 'react-select';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Order } from './interfaces/Order';
import { Cliente } from './interfaces/Cliente';
import { TipoOrden } from './interfaces/TipoOrden';

interface OrderFormProps {
  orderId?: number;  // Será undefined si es una nueva orden
}

const FormularioOrden: React.FC<OrderFormProps> = ({orderId}) => {


  
  const [idUsuarioCreador, setIdUsuarioCreador] = useState<number>(1);
  const [descripcion, setDescripcion] = useState<string>("");

  const[clientes,setClientes] = useState<Cliente[]>([])
  const[ordersType,setOrdersType] = useState<TipoOrden[]>([])

  const[idTipoOrder,setSelectedOrderType] = useState<number | 0>(0)
  const[selectedClient,setSelectedClient] = useState<number | 0>(0);
  const[fechaToma,setFechaToma] = useState<string>("");
  const[fechaFinalizacion,setFechaFinalizacion] = useState<string>("");

  //Fetch clientes
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
  //Fetch tipos de ordenes
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
  useEffect(() => {
    if (orderId) {
      axios.get(`http://localhost:8080/api/orders/${orderId}`)
        .then(response => {
          const order = response.data;
          setSelectedClient(order.clienteId);
          setDescripcion(order.descripcion);
          setSelectedOrderType(order.idTipoOrden);
          setFechaToma(order.fechaToma);
          setFechaFinalizacion(order.fechaFinalizacion ? order.fechaFinalizacion : "");
        })
        .catch(error => {
          console.error('Error al cargar la orden:', error);
        });
    }
  }, []);

  // Mapeo de clientes a opciones para el select
const clienteOptions = clientes.map(cliente => ({
  value: cliente.id,
  label: `${cliente.nombre} ${cliente.apellido}`
}));
const handleClienteChange = (selectedOption: any) => {
  setSelectedClient(selectedOption ? selectedOption.value : null);
};
const ordersOptions = ordersType.map(orderType => ({
  value: orderType.id,
  label: `${orderType.nombre_tipo}`
}));
const handleTypeChange = (selectedOption:any)=>{
  setSelectedOrderType(selectedOption ? selectedOption.value : null);
}
//Funcion SUBMIT
const handleSubmit = (event: React.FormEvent) => {
  event.preventDefault();

  const orderData = {
    selectedClient,
    descripcion,
    idTipoOrder,
    fechaToma,
    fechaFinalizacion,
  };

  if (orderId) {
    // Actualizar una orden existente (PUT)
    axios.put(`http://localhost:8080/api/orders/${orderId}`, orderData)
      .then(response => {
        console.log('Orden actualizada:', response.data);
      })
      .catch(error => {
        console.error('Error al cargar la orden:', error);
      });
    }
  }
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