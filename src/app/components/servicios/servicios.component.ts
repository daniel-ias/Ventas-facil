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

}
