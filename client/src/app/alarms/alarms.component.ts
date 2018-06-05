import { Component, OnInit } from '@angular/core';
import { AlarmInterface } from '../models/alarm';
import { Router } from '@angular/router';
import { AlarmsService } from './alarms.service';

@Component({
  selector: 'app-alarms',
  templateUrl: './alarms.component.html',
  styleUrls: ['./alarms.component.css']
})
export class AlarmsComponent implements OnInit {

  alarms: AlarmInterface[];

    constructor(private router: Router,
    private alarmService: AlarmsService) { 
      this.alarms=[]
    }

  ngOnInit() {
    this.getAlarms();
  }

  getAlarms(){
    this.alarmService.getAlarms().then(
      res=>{this.alarms=res;
        console.log(res);
      }
    )
  }


  showAlarm(id:number){
    console.log(id);
    let path='/#/alarms/'+id;
    this.router.navigate(['/alarms', id]);
  }

}
