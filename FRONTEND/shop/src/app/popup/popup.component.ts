import { Component, OnInit, Inject, ViewChild, ElementRef } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { HttpClient } from '@angular/common/http';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { API_KEY } from './../api-keys';

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.css'],
})
export class PopupComponent implements OnInit {
  @ViewChild('mapContainer', { static: false }) mapContainer!: ElementRef;
  initialCoordinates = {
    lat: 45.5019,
    lng: 73.5674,
  };
  mapConfigurations = {
    zoom: 15,
    center: this.initialCoordinates,
    mapTypeId: 'hybrid',
    disableDefaultUI: true,
    mapStyles: [
      {
        featureType: 'poi',
        stylers: [{ visibility: 'off' }],
      },
    ],
  };
  map!: google.maps.Map;
  marker!: google.maps.Marker;
  googleAddressPlaceHolder: string;

  constructor(
    private dialogRef: MatDialogRef<PopupComponent>,
    private http: HttpClient,
    @Inject(MAT_DIALOG_DATA) public data: { addresses: string[] }
  ) {
    this.googleAddressPlaceHolder = data.addresses[0];
  }

  ngOnInit(): void {
    const addresses = this.data.addresses;
    if (addresses && addresses.length > 0) {
      const addressParts = addresses[0].split(', ');
      const city = addressParts[1];
      const state = addressParts[2];
      const country = addressParts[3];
      const limit = 10;
      const apiKey = API_KEY;
      this.makeWeatherApiCall(city, state, country, limit, apiKey);
    }
  }

  close(): void {
    this.dialogRef.close();
  }

  makeWeatherApiCall(
    city: string,
    state: string,
    country: string,
    limit: number,
    apiKey: string
  ): void {
    const weatherApiUrl = `http://api.openweathermap.org/geo/1.0/direct?q=${city},${state},${country}&limit=${limit}&appid=${apiKey}`;

    console.log('Weather API Request:', weatherApiUrl);

    this.http.get(weatherApiUrl).subscribe(
      (response: any) => {
        if (response && response.length > 0) {
          const location = response[0];
          const lat = location.lat;
          const lon = location.lon;
          console.log('City:', location.name);
          console.log('Latitude:', lat);
          console.log('Longitude:', lon);
          this.initialCoordinates = {
            lat: lat,
            lng: lon,
          };

          this.initializeMap();
        }
      },
      (error: any) => {
        console.error(error);
      }
    );
  }

  initializeMap() {
    this.map = new google.maps.Map(this.mapContainer.nativeElement, {
      zoom: this.mapConfigurations.zoom,
      center: this.initialCoordinates,
      mapTypeId: this.mapConfigurations.mapTypeId,
      disableDefaultUI: this.mapConfigurations.disableDefaultUI,
      styles: this.mapConfigurations.mapStyles,
    });

    this.marker = new google.maps.Marker({
      position: this.initialCoordinates,
      map: this.map,
      title: 'Placeholder',
      draggable: true,
    });

    const infoWindow = new google.maps.InfoWindow({
      content: '<p>SHIP HERE</p>',
    });

    this.marker.addListener('click', () => {
      infoWindow.open(this.map, this.marker);
    });
  }
}
