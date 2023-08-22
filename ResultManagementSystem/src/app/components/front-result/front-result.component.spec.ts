import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FrontResultComponent } from './front-result.component';

describe('FrontResultComponent', () => {
  let component: FrontResultComponent;
  let fixture: ComponentFixture<FrontResultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FrontResultComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FrontResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
