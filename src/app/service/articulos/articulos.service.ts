import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Articulo } from 'src/app/models/articulo.model';

@Injectable({
  providedIn: 'root'
})
export class ArticulosService {

  private urlGet = 'http://localhost:8080/catalogo/articulos/listar';
  private urlCreate = 'http://localhost:8080/catalogo/articulos/guardar';
  private urlDelete = 'http://localhost:8080/catalogo/articulos/eliminar';

  constructor(private http: HttpClient) { }

  getAll() : Observable<Articulo[]> {
    return this.http.get<Articulo[]>(this.urlGet);
  }

  create(articulo: Articulo) : Observable<Articulo> {
    return this.http.post<Articulo>(this.urlCreate, articulo);
  }

  delete(id: number) : Observable<Articulo> {
    return this.http.delete<Articulo>(this.urlDelete+'/'+id);
  }

}
