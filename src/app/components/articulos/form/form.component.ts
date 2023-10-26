import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Articulo } from 'src/app/models/articulo.model';
import { ArticulosService } from 'src/app/service/articulos/articulos.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
})
export class FormComponent implements OnInit {
  articulo: Articulo = new Articulo(0, '', '', '', 0, '', '', '');
  modoEdicion: boolean = false;

  constructor(private articuloService: ArticulosService, private router: Router, private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.loadInfo();
  }

  loadInfo(): void {
    this.activatedRoute.params.subscribe((params) => {
      const id = +params['id']; // Convierte el parámetro a un número
      if (!isNaN(id)) {
        this.modoEdicion = true;
        this.articuloService.get(id).subscribe((articulo) => {
          (this.articulo.id = articulo.id),
            (this.articulo.codigo = articulo.codigo),
            (this.articulo.nombre = articulo.nombre),
            (this.articulo.descripcion = articulo.descripcion),
            (this.articulo.precio = articulo.precio),
            (this.articulo.marca = articulo.marca),
            (this.articulo.modelo = articulo.modelo),
            (this.articulo.fechaRegistro = articulo.fechaRegistro);
        });
      } else {
        console.log('ID de artículo no válido:', params['id']);
      }
    });
  }

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
    this.articuloService.create(this.articulo).subscribe(() => {
      window.alert('Artículo agregado');
    });
  }

  update(id: number, articulo: Articulo): void {
    if (
      !articulo.id ||
      !articulo.codigo ||
      !articulo.nombre ||
      !articulo.descripcion ||
      !articulo.precio ||
      !articulo.marca ||
      !articulo.modelo ||
      !articulo.fechaRegistro
    ) {
      window.alert('Por favor, complete todos los campos del artículo.');
      return;
    }
    this.articuloService.update(id, articulo).subscribe(
      () => {
        window.alert('Articulo actualizado');
        this.router.navigate(['/articulos']);
      },
      (error) => {
        console.error('Error al actualizar artículo:', error);
      }
    );
  }

  redirect() {
    this.router.navigate(['/articulos']);
  }
}
