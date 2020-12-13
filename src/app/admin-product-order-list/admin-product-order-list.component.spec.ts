import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminProductOrderListComponent } from './admin-product-order-list.component';

describe('AdminProductOrderListComponent', () => {
  let component: AdminProductOrderListComponent;
  let fixture: ComponentFixture<AdminProductOrderListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminProductOrderListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminProductOrderListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
