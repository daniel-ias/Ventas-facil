import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Servicio } from 'src/app/models/servicio.model';
import { ServiciosService } from 'src/app/service/servicios/servicios.service';

@Component({
  selector: 'app-form-servicios',
  templateUrl: './form-servicios.component.html',
  styleUrls: ['./form-servicios.component.css'],
})
export class FormServiciosComponent implements OnInit {
  servicio: Servicio = new Servicio(0, '', '', '', 0, '', 0, '');
  modoEdicion: boolean = false;

  constructor(private servicioService: ServiciosService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.loadInfo();
  }

  loadInfo(): void {
    this.activatedRoute.params.subscribe((params) => {
      const id = +params['id']; // Convierte el parámetro a un número
      if (!isNaN(id)) {
        this.modoEdicion = true;
        this.servicioService.get(id).subscribe((servicio) => {
          (this.servicio.id = servicio.id),
            (this.servicio.codigo = servicio.codigo),
            (this.servicio.nombre = servicio.nombre),
            (this.servicio.descripcion = servicio.descripcion),
            (this.servicio.precio = servicio.precio),
            (this.servicio.unidadMedida = servicio.unidadMedida),
            (this.servicio.frecuencia = servicio.frecuencia),
            (this.servicio.fechaRegistro = servicio.fechaRegistro);
        });
      } else {
        console.log('ID del servicio no válido:', params['id']);
      }
    });
  }

  create(): void {
    if (
      !this.servicio.codigo ||
      !this.servicio.nombre ||
      !this.servicio.descripcion ||
      !this.servicio.precio ||
      !this.servicio.unidadMedida ||
      !this.servicio.frecuencia ||
      !this.servicio.fechaRegistro
    ) {
      window.alert('Por favor, complete todos los campos del servicio.');
      return;
    }
    console.log(this.servicio);
    this.servicioService.create(this.servicio).subscribe();
    window.alert('Servicio agregado');
  }

  update(id: number, servicio: Servicio): void {
    if (
      !servicio.id ||
      !servicio.codigo ||
      !servicio.nombre ||
      !servicio.descripcion ||
      !servicio.precio ||
      !servicio.unidadMedida ||
      !servicio.frecuencia ||
      !servicio.fechaRegistro
    ) {
      window.alert('Por favor, complete todos los campos del servicio.');
      return;
    }
    this.servicioService.update(id, servicio).subscribe(
      () => {
        window.alert('Servicio actualizado');
        this.router.navigate(['/servicios']);
      },
      (error) => {
        console.error('Error al actualizar el servicio:', error);
      }
    );
  }

  redirect() {
    this.router.navigate(['/servicios']);
  }
}
