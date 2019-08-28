import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavBarLivreComponent } from './nav-bar-livre.component';

describe('NavBarLivreComponent', () => {
  let component: NavBarLivreComponent;
  let fixture: ComponentFixture<NavBarLivreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavBarLivreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavBarLivreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
