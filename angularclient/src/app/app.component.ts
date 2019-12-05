import { Component } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';

import { FlightSearchService } from './data.service';
import { Flight } from './flight';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  angularForm: FormGroup;
  message: string;
  instruction = 'Please enter Date and either origin&destination or Flight number';
  private flights: Flight[] = [];

  constructor(private dataService: FlightSearchService, private fb: FormBuilder) {
    this.createForm();
  }

  createForm() {
    this.angularForm = this.fb.group({
      flightNumber: [''],
      origin: [''],
      destination: [''],
      fdate: ['', Validators.required],
    }, {
      });
    this.message = this.instruction;
  }

  searchFlights() {
    if (this.angularForm.value.flightNumber || (this.angularForm.value.origin && this.angularForm.value.destination)) {
      this.search();
    } else {
      this.message = 'Invalid input. ' + this.instruction;
    }
  }


  search() {

    const flightNumber = this.angularForm.value.flightNumber;
    const origin = this.angularForm.value.origin.toUpperCase();
    const destination = this.angularForm.value.destination.toUpperCase();
    const fdate = this.angularForm.value.fdate;

    this.dataService.searchFlights(flightNumber, origin, destination, fdate).subscribe(result => {
         this.flights = result as Flight[];
         this.message = this.flights.length  + ' Flights found matching your criteria.';

      }
    );
  }
}
