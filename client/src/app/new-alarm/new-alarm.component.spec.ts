import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewAlarmComponent } from './new-alarm.component';

describe('NewAlarmComponent', () => {
  let component: NewAlarmComponent;
  let fixture: ComponentFixture<NewAlarmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewAlarmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewAlarmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
