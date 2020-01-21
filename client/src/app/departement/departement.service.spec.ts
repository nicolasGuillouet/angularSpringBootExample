import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpRequest } from '@angular/common/http';
import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';

import { DepartementService } from './departement.service';
import { Departement } from './departement';
import { all } from 'q';

describe('DepartementService', () => {

  let injector: TestBed;
  let httpMock: HttpTestingController;
  let departementService: DepartementService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DepartementService],
      imports: [HttpClientTestingModule]
    });
    injector = getTestBed();
    departementService = injector.get(DepartementService);
    httpMock = injector.get(HttpTestingController);
  });

  it('should be created', () => {
    const service: DepartementService = TestBed.get(DepartementService);
    expect(service).toBeTruthy();
  });


  it('Should get all departements', (done) => {
    const dummyData: any = require('../../assets/mocks/departements-1.json');

    departementService.getAll().subscribe((allDepartements: Departement[]) => {
      expect(allDepartements.length).toBe(5);
      const firstDepartement = allDepartements[0];
      expect(firstDepartement.nom).toBe('Calvados');
      expect(firstDepartement.code).toBe('14');
      expect(firstDepartement.codeRegion).toBe('28');
      done();
    });
    const req = httpMock.expectOne((httpRequest: HttpRequest<any>) =>
      httpRequest.urlWithParams === `${departementService.API_URL}/departements`);

    expect(req.cancelled).toBeFalsy();
    expect(req.request.method).toBe('GET');
    expect(req.request.responseType).toEqual('json');
    expect(req.request.headers.get('Content-Type')).toEqual('application/json');
    expect(req.request.headers.get('Accept')).toEqual('application/json');
    expect(req.request.params.get('nom')).toBeNull();
    req.flush(dummyData);
    httpMock.verify();
  });

  it('Should get one departement', (done) => {
    const dummyData: any = require('../../assets/mocks/departement-1.json');
    const code = '14';

    departementService.get(code).subscribe((departement: Departement) => {
      expect(departement.nom).toBe('Calvados');
      expect(departement.code).toBe('14');
      expect(departement.codeRegion).toBe('28');
      done();
    });
    const req = httpMock.expectOne((httpRequest: HttpRequest<any>) =>
      httpRequest.urlWithParams === `${departementService.API_URL}/departements/14`);

    expect(req.cancelled).toBeFalsy();
    expect(req.request.method).toBe('GET');
    expect(req.request.responseType).toEqual('json');
    expect(req.request.headers.get('Content-Type')).toEqual('application/json');
    expect(req.request.headers.get('Accept')).toEqual('application/json');
    req.flush(dummyData);
    httpMock.verify();
  });

});
