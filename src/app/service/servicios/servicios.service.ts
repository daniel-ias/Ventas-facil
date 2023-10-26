import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Servicio } from 'src/app/models/servicio.model';

@Injectable({
  providedIn: 'root'
})
export class ServiciosService {

  private baseUrl = 'http://localhost:8080/servicios';

  constructor(private http: HttpClient) { }

  getAll() : Observable<Servicio[]> {
    return this.http.get<Servicio[]>(`${this.baseUrl}/listar`);
  }

  get(id: number): Observable<Servicio> {
    return this.http.get<Servicio>(`${this.baseUrl}/consultaId/${id}`);
  }

  update(id: number, servicio: Servicio) : Observable<Servicio> {
    return this.http.put<Servicio>(`${this.baseUrl}/actualizar/${id}`, servicio);
  }

  create(servicio: Servicio) : Observable<Servicio> {
    return this.http.post<Servicio>(`${this.baseUrl}/guardar`, servicio);
  }

  delete(id: number) : Observable<Servicio> {
    return this.http.delete<Servicio>(`${this.baseUrl}/eliminar/${id}`);
  }

}
