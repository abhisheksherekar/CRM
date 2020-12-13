import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ServiceProvider } from "../Model/service-provider";

@Injectable({
  providedIn: 'root'
})
export class ServiceproviderService {

  //provider: ServiceProvider = new ServiceProvider();

  constructor(private http: HttpClient) { }


  public getAllProvider(): Observable<any> {
    return this.http.get('http://localhost:8080/getAllprovider');
  }

  public addServiceProvider(provider: ServiceProvider): Observable<any> {
    return this.http.post('http://localhost:8080/registerSP', provider);
  }

  public LoginServiceProvider(provider: ServiceProvider): Observable<any> {
    return this.http.post('http://localhost:8080/loginSP', provider);
  }

  public showAllorderById1(id: number): Observable<any> {
    return this.http.get('http://localhost:8080/showAllorderById/' + id);
  }

}
