import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenerateTurnComponent } from './generate-turn.component';

describe('GenerateTurnComponent', () => {
  let component: GenerateTurnComponent;
  let fixture: ComponentFixture<GenerateTurnComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GenerateTurnComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GenerateTurnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
