import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Articulo } from 'src/app/models/articulo.model';
import { ArticulosService } from 'src/app/service/articulos/articulos.service';

@Component({
  selector: 'app-articulos',
  templateUrl: './articulos.component.html',
  styleUrls: ['./articulos.component.css']
})
export class ArticulosComponent implements OnInit{

  articulos: Articulo[] = [];

  constructor(private articuloService: ArticulosService, private router: Router) { }

  ngOnInit(): void {
    this.articuloService.getAll().subscribe(articulo => {
      this.articulos = articulo;
    })
  }

  delete(articulo: Articulo) {
    this.articuloService.delete(articulo.id).subscribe(result => {
      this.articuloService.getAll().subscribe(response => {
        this.articulos = response;
      })
    });
  }

  redirect() {
    this.router.navigate(['articulos/form']);
  }

  home() {
    this.router.navigate(['/home']);
  }

}
