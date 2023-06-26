import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlockAccountsComponent } from './block-accounts.component';

describe('BlockAccountsComponent', () => {
  let component: BlockAccountsComponent;
  let fixture: ComponentFixture<BlockAccountsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BlockAccountsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BlockAccountsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
