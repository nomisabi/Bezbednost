import { Component, OnInit } from '@angular/core';
import { AlarmInterface } from '../models/alarm';
import { AlarmsService } from '../alarms/alarms.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-alarm-details',
  templateUrl: './alarm-details.component.html',
  styleUrls: ['./alarm-details.component.css']
})
export class AlarmDetailsComponent implements OnInit {

  alarm: AlarmInterface;
  constructor(private alarmService: AlarmsService, private route: ActivatedRoute, private router: Router) { 
    this.alarm={
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
    this.alarmService.getAlarm(+this.route.snapshot.params['id']).then(
      res=>this.alarm=res
    ).catch(err=>this.router.navigate['alarms/control'])
  }

}
