import { Injectable } from '@angular/core';
import { LogInterface } from '../models/log'

import { HttpClient, HttpParams } from '@angular/common/http';
import { Subject } from 'rxjs/Rx';


@Injectable()
export class LogsService {

  private url = '/api/logs';
  
  private RegenerateData = new Subject<void>();

  RegenerateData$ = this.RegenerateData.asObservable();

  constructor(private http: HttpClient) { 
  }

  announceChange(){
    this.RegenerateData.next();
  }

  getLogs(page:number, size = 20):Promise<LogInterface[]> {
    const httpParams = new HttpParams().set('page', page.toString()).set('size', size.toString()).set('sort', 'id,desc');
    return this.http
    .get<LogInterface[]>(this.url, {params: httpParams})
    .toPromise()
    .then(res => res)
    .catch(this.handleError);
  }

  search(text:String):Promise<LogInterface[]>{
    return this.http
    .post<LogInterface[]>(this.url, text)
    .toPromise()
    .then(res => res)
    .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error("Error... ", error);
    return Promise.reject(error.message || error);
  }
}
