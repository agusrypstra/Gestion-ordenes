export interface Order {
    clienteId: number; // o el tipo correcto
    descripcion: string;
    idTipoOrder: number; // o el tipo correcto
    fechaCreacion: string; // asumiendo que estás usando string para fechas
    idUsuarioCreador: number; // o el tipo correcto
}