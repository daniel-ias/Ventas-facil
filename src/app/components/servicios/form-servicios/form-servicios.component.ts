import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Servicio } from 'src/app/models/servicio.model';
import { ServiciosService } from 'src/app/service/servicios/servicios.service';

@Component({
  selector: 'app-form-servicios',
  templateUrl: './form-servicios.component.html',
  styleUrls: ['./form-servicios.component.css'],
})
export class FormServiciosComponent implements OnInit {
  servicio: Servicio = new Servicio(0, '', '', '', 0, '', 0, '');

  constructor(private servicioService: ServiciosService, private router: Router) { }

  ngOnInit(): void {}

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

  redirect() {
    this.router.navigate(['/servicios']);
  }
}
