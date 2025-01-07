import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LuchadorDetalleComponent } from './luchador-detalle.component';

describe('LuchadorDetalleComponent', () => {
  let component: LuchadorDetalleComponent;
  let fixture: ComponentFixture<LuchadorDetalleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LuchadorDetalleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LuchadorDetalleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
