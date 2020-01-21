import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders, HttpParameterCodec } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Departement } from './departement';

@Injectable({
  providedIn: 'root'
})

export class DepartementService {
  readonly API_URL = 'http://localhost:8080/';

  constructor(private http: HttpClient) {

  }


  public getAll(): Observable<Departement[]> {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');
    headers = headers.set('Accept', 'application/json');
    return this.http.get<any>(`${this.API_URL}/departements`, { headers });
  }

  public get(code: string): Observable<Departement> {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');
    headers = headers.set('Accept', 'application/json');
    return this.http.get<any>(`${this.API_URL}/departements/${code}`, { headers });
  }

}
