import { Component, OnInit } from '@angular/core';
import { AlarmInterface } from '../models/alarm';
import { AlarmsService } from '../alarms/alarms.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-new-alarm',
  templateUrl: './new-alarm.component.html',
  styleUrls: ['./new-alarm.component.css']
})
export class NewAlarmComponent implements OnInit {

  newAlarm: AlarmInterface;
  constructor(private alarmService: AlarmsService, private router: Router) { 
    this.newAlarm={
      appname:'',
      description:'',
      hostname:'',
      id:0,
      logs:[],
      msg:'',
      msgid:'',
      name:'',
      prival: 0, 
      procid:'',
      sd:'',
      timestamp:'', 
      version:0,
      number:0,
      seconds:0,
      canDelete:true
    }
  }

  ngOnInit() {
  }

  newAlarmClick(){
    if (this.newAlarm.name==''){
      console.log("name");
    } else if(this.newAlarm.description==''){
      console.log("desc");
    } else if(this.newAlarm.number<1){
      console.log("num");
    } else if(this.newAlarm.seconds<1){
      console.log("sec");
    }else{

      console.log("newAlarmClick");
      console.log(this.newAlarm);
      this.alarmService.createAlarm(this.newAlarm).then(
          res=>this.router.navigate(['/alarms','control'])
      ).catch(err=>this.router.navigate(['/alarms','control']))
    }
  }
}
