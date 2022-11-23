import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Prueba404Component } from './prueba404.component';

describe('Prueba404Component', () => {
  let component: Prueba404Component;
  let fixture: ComponentFixture<Prueba404Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Prueba404Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Prueba404Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
