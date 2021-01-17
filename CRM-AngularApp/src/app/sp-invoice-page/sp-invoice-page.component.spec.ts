import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpInvoicePageComponent } from './sp-invoice-page.component';

describe('SpInvoicePageComponent', () => {
  let component: SpInvoicePageComponent;
  let fixture: ComponentFixture<SpInvoicePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpInvoicePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpInvoicePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
