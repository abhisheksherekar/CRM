import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerRegisterPageComponent } from './customer-register-page.component';

describe('CustomerRegisterPageComponent', () => {
  let component: CustomerRegisterPageComponent;
  let fixture: ComponentFixture<CustomerRegisterPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerRegisterPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerRegisterPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
