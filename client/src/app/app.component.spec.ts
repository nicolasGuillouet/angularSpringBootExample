import { TestBed, async, ComponentFixture, tick, fakeAsync } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';
import { AppComponent } from './app.component';
import { DebugElement } from '@angular/core';

import { DepartementService } from './departement/departement.service';
import { Departement } from './departement/departement';
declare var ol: any;

describe('AppComponent', () => {
  const allDepartements: Departement[] = require('../assets/mocks/departements-1.json');
  const oneDepartement: Departement = require('../assets/mocks/departement-1.json');

  let departementService: DepartementService;


  let debugElement: DebugElement;
  let fixture: ComponentFixture<AppComponent>;
  let getAllDepartementsSpy: any;
  let getOneDepartementsSpy: any;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
      imports: [
        HttpClientTestingModule
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(AppComponent);
    debugElement = fixture.debugElement;
    departementService = debugElement.injector.get(DepartementService);

    getAllDepartementsSpy = spyOn(departementService, 'getAll').and.callFake(() => of(allDepartements));
    getOneDepartementsSpy = spyOn(departementService, 'get').and.callFake(() => of(oneDepartement));
  }));

  it('should create the app', () => {
    const app: AppComponent = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'Départements'`, () => {
    const app: AppComponent = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('Départements');
  });

  it('should render title in a h1 tag', () => {
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Afficher un département sur la carte');
  });

  it('Should load departements', async(() => {
    const app: AppComponent = fixture.debugElement.componentInstance;
    fixture.detectChanges();
    expect(getAllDepartementsSpy).toHaveBeenCalled();
    expect(app.departements).toBe(allDepartements);
  }));

  it('Should select one departement', async(() => {
    const app: AppComponent = fixture.debugElement.componentInstance;
    app.selectDepartement('14');
    expect(getOneDepartementsSpy).toHaveBeenCalled();
    expect(app.selectedDepartement.nom).toBe('Calvados');
  }));
});
