import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductComponent } from './product.component/product.component';
import { BaseUrlService } from './service/BaseUrl.service';
import { ProductService } from './service/product.service';
import { HttpClientModule } from '@angular/common/http';
import { ButtonModule } from 'primeng/button';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { MessageService, ConfirmationService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; 

@NgModule({
  declarations: [AppComponent, ProductComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ButtonModule,
    ConfirmDialogModule,
    ToastModule,
    BrowserAnimationsModule,
  ],
  providers: [
    BaseUrlService,
    ProductService,
    MessageService,
    ConfirmationService,
  ],
  bootstrap: [ProductComponent],
})
export class AppModule {}
