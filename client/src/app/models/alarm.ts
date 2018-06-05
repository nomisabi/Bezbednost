import { LogInterface } from "./log";

export interface AlarmInterface {
    id:number;
    name: String;
    description: String;
    prival: number;
    version: number;
    timestamp: String;
    hostname: String;
    appname: String;
    procid: String;
    msgid: String;
    sd: String;
    msg: String;
    number:number;
    seconds: number;
  
    logs: LogInterface[];
    canDelete: boolean;
  }