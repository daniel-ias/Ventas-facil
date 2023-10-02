import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArticulosComponent } from './components/articulos/articulos.component';
import { ServiciosComponent } from './components/servicios/servicios.component';
import { FormComponent } from './components/articulos/form/form.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule } from '@angular/forms';
import { FormServiciosComponent } from './components/servicios/form-servicios/form-servicios.component';

@NgModule({
  declarations: [
    AppComponent,
    ArticulosComponent,
    ServiciosComponent,
    FormComponent,
    HomeComponent,
    FormServiciosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
