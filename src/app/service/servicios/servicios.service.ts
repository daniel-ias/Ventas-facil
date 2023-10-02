import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Servicio } from 'src/app/models/servicio.model';

@Injectable({
  providedIn: 'root'
})
export class ServiciosService {

  private urlGet = 'http://localhost:8080/servicios/listar';
  private urlCreate = 'http://localhost:8080/servicios/guardar';
  private urlDelete = 'http://localhost:8080/servicios/eliminar';

  constructor(private http: HttpClient) { }

  getAll() : Observable<Servicio[]> {
    return this.http.get<Servicio[]>(this.urlGet);
  }

  create(servicio: Servicio) : Observable<Servicio> {
    return this.http.post<Servicio>(this.urlCreate, servicio);
  }

  delete(id: number) : Observable<Servicio> {
    return this.http.delete<Servicio>(this.urlDelete+'/'+id);
  }

  
}
