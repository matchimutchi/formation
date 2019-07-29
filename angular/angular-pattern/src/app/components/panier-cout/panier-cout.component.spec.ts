import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PanierCoutComponent } from './panier-cout.component';

describe('PanierCoutComponent', () => {
  let component: PanierCoutComponent;
  let fixture: ComponentFixture<PanierCoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PanierCoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PanierCoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
