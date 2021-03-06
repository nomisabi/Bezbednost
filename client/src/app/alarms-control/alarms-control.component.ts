import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AlarmsService } from '../alarms/alarms.service';
import { AlarmInterface } from '../models/alarm';

@Component({
  selector: 'app-alarms-control',
  templateUrl: './alarms-control.component.html',
  styleUrls: ['./alarms-control.component.css']
})
export class AlarmsControlComponent implements OnInit {

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
    
  }
  
  deleteAlarm(id:number){
    this.alarmService.deleteAlarm(id).then(
      res=>{
        console.log('good');
        this.alarms=[]
        this.getAlarms()
        
      }
    ).catch(
      res=>{
        console.log('bad')
        this.alarms=[]
        this.getAlarms()
        //window.location.reload()
      }
    )
  }


  newAlarm(){
    this.router.navigate(['/alarms/new']);
  }

}
