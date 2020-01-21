import { Component, OnInit } from '@angular/core';
import { Departement } from './departement/departement';
import { DepartementService } from './departement/departement.service';
import * as ol from '../../node_modules/ol';
import Map from 'ol/Map';
import View from 'ol/View';
import TileLayer from 'ol/layer/Tile';
import XYZ from 'ol/source/XYZ';
import { fromLonLat } from 'ol/proj';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public title = 'Départements';
  public departements: Departement[];
  public selectedDepartement: Departement;
  public map: Map;

  private longLat: any = {
    '14': [-0.3712, 49.1811],
    '61': [0.091266, 48.432856],
    '27': [1.1508, 49.0241],
    '76': [1.0993, 49.4431],
    '50': [-1.083333, 49.116667]
  };

  constructor(
    private departementService: DepartementService
  ) {
  }

  ngOnInit() {
    this.selectedDepartement = null;
    this.departementService.getAll().subscribe((allDepartements: Departement[]) => {
      this.departements = allDepartements;
    });
  }

  private setMap(): void {
    const view: View = this.getMapView();
    if (this.map) {
      this.map.setView(view);
    } else {
      this.map = new Map({
        target: 'map',
        layers: [
          new TileLayer({
            source: new XYZ({
              url: 'https://{a-c}.tile.openstreetmap.org/{z}/{x}/{y}.png'
            })
          })
        ],
        view: view
      });
    }
  }

  private getMapView(): View {
    return new View({
      center: fromLonLat(this.longLat[this.selectedDepartement.code]),
      zoom: 10
    });
  }

  public selectDepartement(code: string): void {
    this.departementService.get(code).subscribe((departement: Departement) => {
      this.selectedDepartement = departement;
      this.setMap();
    });
  }
}
