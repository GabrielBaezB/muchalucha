import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './componentes/home/home.component';
import { EventosComponent } from './componentes/eventos/eventos.component';
import { EventoDetalleComponent } from './componentes/evento-detalle/evento-detalle.component';
import { LuchadoresComponent } from './componentes/luchadores/luchadores.component';
import { ContactoComponent } from './componentes/contacto/contacto.component';
import { LuchadorDetalleComponent } from './componentes/luchador-detalle/luchador-detalle.component';
import { NoticiaDetalleComponent } from './componentes/noticia-detalle/noticia-detalle.component';
import { NoticiasComponent } from './componentes/noticias/noticias.component';
import { NgModule } from '@angular/core';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'eventos', component: EventosComponent },
    { path: 'eventos/:id', component: EventoDetalleComponent },
    { path: 'luchadores', component: LuchadoresComponent },
    { path: 'luchadores/:id', component: LuchadorDetalleComponent },
    { path: 'noticias', component: NoticiasComponent },
    { path: 'noticias/:id', component: NoticiaDetalleComponent },
    { path: 'contacto', component: ContactoComponent },
    { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
