import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpRegisterPageComponent } from './sp-register-page.component';

describe('SpRegisterPageComponent', () => {
  let component: SpRegisterPageComponent;
  let fixture: ComponentFixture<SpRegisterPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpRegisterPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpRegisterPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
