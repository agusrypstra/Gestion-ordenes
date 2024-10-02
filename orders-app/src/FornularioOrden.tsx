import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

type OrdenTipo = 'Reclamo' | 'Instalación nueva' | 'Retiro';

const FormularioOrden: React.FC = () => {
  const [nombreCliente, setNombreCliente] = useState<string>('');
  const [descripcion, setDescripcion] = useState<string>('');
  const [tipoOrden, setTipoOrden] = useState<OrdenTipo>('Reclamo');

  const handleSubmit = (event: React.FormEvent) => {
    event.preventDefault();
    const orden = {
      nombreCliente,
      descripcion,
      tipoOrden,
    };
    
    console.log('Orden enviada:', orden);
  };

  return (
    <form onSubmit={handleSubmit} className="container mt-4">
      {/* Campo para el nombre del cliente */}
      <div className="mb-3">
        <label htmlFor="nombreCliente" className="form-label">Nombre del Cliente:</label>
        <input
          type="text"
          id="nombreCliente"
          className="form-control"
          value={nombreCliente}
          onChange={(e) => setNombreCliente(e.target.value)}
          required
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
        <label htmlFor="tipoOrden" className="form-label">Tipo de Orden:</label>
        <select
          id="tipoOrden"
          className="form-select"
          value={tipoOrden}
          onChange={(e) => setTipoOrden(e.target.value as OrdenTipo)}
        >
          <option value="Reclamo">Reclamo</option>
          <option value="Instalación nueva">Instalación nueva</option>
          <option value="Retiro">Retiro</option>
        </select>
      </div>

      {/* Botón de envío */}
      <button type="submit" className="btn btn-primary">Enviar Orden</button>
    </form>
  );
};

export default FormularioOrden;