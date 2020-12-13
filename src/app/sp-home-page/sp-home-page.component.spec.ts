import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpHomePageComponent } from './sp-home-page.component';

describe('SpHomePageComponent', () => {
  let component: SpHomePageComponent;
  let fixture: ComponentFixture<SpHomePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpHomePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpHomePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
