import { Component, OnInit } from '@angular/core';
import { Servicio } from 'src/app/models/servicio.model';
import { ServiciosService } from '../../service/servicios/servicios.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-servicios',
  templateUrl: './servicios.component.html',
  styleUrls: ['./servicios.component.css']
})
export class ServiciosComponent implements OnInit{

  servicios: Servicio[] = [];

  constructor(private serviciosService: ServiciosService, private router: Router) { }

  ngOnInit(): void {
    this.serviciosService.getAll().subscribe(servicio => {
      this.servicios = servicio;
    })
  }

  delete(servicio: Servicio) {
    this.serviciosService.delete(servicio.id).subscribe(result => {
      this.serviciosService.getAll().subscribe(response => {
        window.alert('Servicio eliminado');
        this.servicios = response;
      })
    });
  }

  redirect() {
    this.router.navigate(['servicios/form-servicios']);
  }

  home() {
    this.router.navigate(['/home']);
  }

  redirectEdit(servicio: Servicio) {
    if (servicio && servicio.id !== undefined) {
      this.router.navigate(['servicios/form-servicios', servicio.id]);
    } else {
      console.error('ID de servicio no válido:', servicio);
    }
  }

}
