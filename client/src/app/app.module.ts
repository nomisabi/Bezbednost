import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { platformBrowserDynamic } from "@angular/platform-browser-dynamic";
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LogsComponent } from './logs/logs.component';
import { LogsService } from './logs/logs.service';
import { RouterModule } from '@angular/router';
import { AlarmsComponent } from './alarms/alarms.component';
import { AlarmsControlComponent } from './alarms-control/alarms-control.component';
import { NewAlarmComponent } from './new-alarm/new-alarm.component';
import { AlarmDetailsComponent } from './alarm-details/alarm-details.component';
import { AlarmsService } from './alarms/alarms.service';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LogsComponent,
    AlarmsComponent,
    AlarmsControlComponent,
    NewAlarmComponent,
    AlarmDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    InfiniteScrollModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    LogsService,
    AlarmsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

platformBrowserDynamic().bootstrapModule(AppModule);