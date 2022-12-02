import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApptPatientComponent } from './appt-patient.component';

describe('ApptPatientComponent', () => {
  let component: ApptPatientComponent;
  let fixture: ComponentFixture<ApptPatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApptPatientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApptPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
