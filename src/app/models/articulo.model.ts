export class Articulo {
    id: number;
    codigo: string;
    nombre: string;
    descripcion: string;
    precio: number;
    marca: string;
    modelo: string;
    fechaRegistro: string;

  constructor(id: number, codigo: string, nombre: string, descripcion: string, precio: number,
    marca: string, modelo: string, fechaRegistro: string) {
    this.id = id;
    this.codigo = codigo;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.marca = marca;
    this.modelo = modelo;
    this.fechaRegistro = fechaRegistro;
  }

}