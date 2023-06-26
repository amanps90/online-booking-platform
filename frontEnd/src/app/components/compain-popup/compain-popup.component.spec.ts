import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompainPopupComponent } from './compain-popup.component';

describe('CompainPopupComponent', () => {
  let component: CompainPopupComponent;
  let fixture: ComponentFixture<CompainPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompainPopupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompainPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
