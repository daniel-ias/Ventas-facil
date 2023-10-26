import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Articulo } from 'src/app/models/articulo.model';

@Injectable({
  providedIn: 'root'
})
export class ArticulosService {

  private baseUrl = 'http://localhost:8080/catalogo/articulos';

  constructor(private http: HttpClient) { }

  getAll() : Observable<Articulo[]> {
    return this.http.get<Articulo[]>(`${this.baseUrl}/listar`);
  }

  get(id: number): Observable<Articulo> {
    return this.http.get<Articulo>(`${this.baseUrl}/listarId/${id}`);
  }

  update(id: number, articulo: Articulo) : Observable<Articulo> {
    return this.http.put<Articulo>(`${this.baseUrl}/actualizar/${id}`, articulo);
  }

  create(articulo: Articulo) : Observable<Articulo> {
    return this.http.post<Articulo>(`${this.baseUrl}/guardar`, articulo);
  }

  delete(id: number) : Observable<Articulo> {
    return this.http.delete<Articulo>(`${this.baseUrl}/eliminar/${id}`);
  }

}
