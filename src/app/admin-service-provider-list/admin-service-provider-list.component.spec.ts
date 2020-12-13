import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminServiceProviderListComponent } from './admin-service-provider-list.component';

describe('AdminServiceProviderListComponent', () => {
  let component: AdminServiceProviderListComponent;
  let fixture: ComponentFixture<AdminServiceProviderListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminServiceProviderListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminServiceProviderListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
