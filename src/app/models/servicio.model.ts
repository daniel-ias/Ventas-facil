export class Servicio {
    id: number;
    codigo: string;
    nombre: string;
    descripcion: string;
    precio: number;
    unidadMedida: string;
    frecuencia: number;
    fechaRegistro: string;

  constructor(id: number, codigo: string, nombre: string, descripcion: string, precio: number,
    unidadMedida: string, frecuencia: number, fechaRegistro: string) {
    this.id = id;
    this.codigo = codigo;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.unidadMedida = unidadMedida;
    this.frecuencia = frecuencia;
    this.fechaRegistro = fechaRegistro;
  }

}