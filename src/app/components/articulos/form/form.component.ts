import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Articulo } from 'src/app/models/articulo.model';
import { ArticulosService } from 'src/app/service/articulos/articulos.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
})
export class FormComponent implements OnInit {
  articulo: Articulo = new Articulo(0, '', '', '', 0, '', '', '');

  constructor(private articuloService: ArticulosService, private router: Router) { }

  ngOnInit(): void {}

  create(): void {
    if (
      !this.articulo.codigo ||
      !this.articulo.nombre ||
      !this.articulo.descripcion ||
      !this.articulo.precio ||
      !this.articulo.marca ||
      !this.articulo.modelo ||
      !this.articulo.fechaRegistro
    ) {
      window.alert('Por favor, complete todos los campos del artículo.');
      return;
    }
    console.log(this.articulo);
    this.articuloService.create(this.articulo).subscribe(() => {
      window.alert('Artículo agregado');
    });
  }

  redirect() {
    this.router.navigate(['/articulos']);
  }
}
