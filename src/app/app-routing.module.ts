import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArticulosComponent } from './components/articulos/articulos.component';
import { FormComponent } from './components/articulos/form/form.component';
import { ServiciosComponent } from './components/servicios/servicios.component';
import { HomeComponent } from './components/home/home.component';
import { FormServiciosComponent } from './components/servicios/form-servicios/form-servicios.component';

const routes: Routes = [
   { path: '', redirectTo: '/home', pathMatch: 'full'},
   { path: 'home', component: HomeComponent },
   { path: 'articulos', redirectTo: '/articulos', pathMatch: 'full'},
   { path: 'articulos', component: ArticulosComponent },
   { path: 'articulos/form', component: FormComponent },
   { path: 'servicios', redirectTo: '/servicios', pathMatch: 'full'},
   { path: 'servicios', component: ServiciosComponent },
   { path: 'servicios/form-servicios', component: FormServiciosComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
