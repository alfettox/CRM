import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ItemListComponent } from './item-list/item-list.component';
import { ReactiveFormsModule } from '@angular/forms';
import { NavbarComponent } from './nav/nav.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CoreModule } from './core/core.module';
import { SharedModule } from './shared/shared.module';
import { CustomersModule } from './customers/customers.module';
import { OrdersModule } from './orders/orders.module';
import { LoginPageComponent } from './login-page/login-page.component';
import { NgModel } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DataService } from './core/data.service';


@NgModule({
  declarations: [
    AppComponent,
    ItemListComponent,
    NavbarComponent,
    LoginPageComponent,

  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    OrdersModule,
    SharedModule,
    CoreModule,
    AppRoutingModule
    
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})




export class AppModule { }
