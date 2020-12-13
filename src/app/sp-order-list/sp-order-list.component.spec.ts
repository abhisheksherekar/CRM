import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpOrderListComponent } from './sp-order-list.component';

describe('SpOrderListComponent', () => {
  let component: SpOrderListComponent;
  let fixture: ComponentFixture<SpOrderListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpOrderListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpOrderListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
