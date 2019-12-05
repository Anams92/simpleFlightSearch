import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';

import {retry, catchError} from 'rxjs/operators';
import { _throw as throwError } from 'rxjs/observable/throw';

import {Flight} from './Flight';

@Injectable({
  providedIn: 'root'
})

export class FlightSearchService {
  private const restFlightsURL: string = 'http://localhost:9080/flight/search';

  constructor(private http: HttpClient) {
  }

  searchFlights(flightNumber: string, origin: string, destination: string, fdate: string) {

    let headers = new HttpHeaders();
    headers = headers.append('Content-Type', 'application/json');
    

    let params = new HttpParams();
    params = params.append('flightNumber', flightNumber);
    params = params.append('origin', origin);
    params = params.append('destination', destination);
    params = params.append('date', fdate);

    return this.http.get(this.restFlightsURL, {headers, params});

  }

  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }
}
