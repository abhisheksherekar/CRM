import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpLoginPageComponent } from './sp-login-page.component';

describe('SpLoginPageComponent', () => {
  let component: SpLoginPageComponent;
  let fixture: ComponentFixture<SpLoginPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpLoginPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpLoginPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
