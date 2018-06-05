import { Component, OnInit } from '@angular/core';
import { AlarmInterface } from '../models/alarm';
import { Router } from '@angular/router';
import { AlarmsService } from './alarms.service';
import { Dict } from '../models/dict';
import { Item } from '../models/item';

@Component({
  selector: 'app-alarms',
  templateUrl: './alarms.component.html',
  styleUrls: ['./alarms.component.css']
})
export class AlarmsComponent implements OnInit {

  alarms: AlarmInterface[];
  allAlarms: AlarmInterface[];
  alarmList: Dict;
  show:boolean=false;

    constructor(private router: Router,
    private alarmService: AlarmsService) { 
      this.alarms=[]
      this.allAlarms=[]
      this.alarmList={items:[]}
    }

  ngOnInit() {
    this.getAlarms();
  }

  getAlarms(){
    this.alarmService.getAlarms().then(
      res=>{this.alarms=res;
        for (let a of res){
          this.allAlarms.push(a)
        }
        for (let alar of this.alarms) {
          let item:Item={alarm:alar, show:true};
          this.alarmList.items.push(item);
          
        }console.log(this.alarmList.items);
        
      }
    )
  }


  showAlarm(id:number){
    console.log(id);
    let path='/#/alarms/'+id;
    this.router.navigate(['/alarms', id]);
  }


  showHide(){
    if (this.show) 
      this.show=false;
    else
      this.show=true;
  }

  remove(alarm:AlarmInterface){
    console.log('remove')
    for (var a = 0; a < this.alarms.length; a++){
      if (this.alarms[a].id==alarm.id)
        this.alarms.splice(a, 1);
    }
    for (let a of this.alarmList.items){
      if (a.alarm.id==alarm.id)
        a.show=false;
    }
  }

  add(alarm:AlarmInterface){
    console.log('add')
    for (let a of this.alarmList.items){
      if (a.alarm.id==alarm.id)
        a.show=true;
    }
    console.log('alarm: ',alarm.id)
    for (let a in this.allAlarms){
      console.log(this.allAlarms[a].id)
      if (this.allAlarms[a].id==alarm.id){
        console.log('before:',this.alarms)
        this.alarms.push(this.allAlarms[a])
        console.log('after:',this.alarms)
      }
    }
  }
}
