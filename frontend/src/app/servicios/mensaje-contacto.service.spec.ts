import { TestBed } from '@angular/core/testing';

import { MensajeContactoService } from './mensaje-contacto.service';

describe('MensajeContactoService', () => {
  let service: MensajeContactoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MensajeContactoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
