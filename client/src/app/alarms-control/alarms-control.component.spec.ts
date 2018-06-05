import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlarmsControlComponent } from './alarms-control.component';

describe('AlarmsControlComponent', () => {
  let component: AlarmsControlComponent;
  let fixture: ComponentFixture<AlarmsControlComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlarmsControlComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlarmsControlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
