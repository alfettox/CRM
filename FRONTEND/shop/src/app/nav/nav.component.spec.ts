import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarComponent } from './nav.component';

describe('NavComponent', () => {
  let component: NavbarComponent;
  let fixture: ComponentFixture<NavbarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [component]
    });
    fixture = TestBed.createComponent(component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
