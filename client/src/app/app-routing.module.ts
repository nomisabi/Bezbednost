import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LogsComponent } from './logs/logs.component';
import { AlarmsComponent } from './alarms/alarms.component';
import { AlarmsControlComponent } from './alarms-control/alarms-control.component';
import { NewAlarmComponent } from './new-alarm/new-alarm.component';
import { AlarmDetailsComponent } from './alarm-details/alarm-details.component';

const routes: Routes = [
  { 
    path: '', component: HomeComponent
  },
  { 
    path: 'logs', component: LogsComponent
  },
  { 
    path: 'alarms', component: AlarmsComponent
  },
  { 
    path: 'alarms/control', component: AlarmsControlComponent
  },
  { 
    path: 'alarms/new', component: NewAlarmComponent
  },
  { 
    path: 'alarms/:id', component: AlarmDetailsComponent
  },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { 
}
