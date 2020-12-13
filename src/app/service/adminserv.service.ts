import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from '../Model/admin';

@Injectable({
  providedIn: 'root'
})
export class AdminservService {

  constructor(private http: HttpClient) { }

  public adminLogin(admin: Admin): Observable<any> {
    return this.http.post('http://localhost:8080/loginAdmin', admin);
  }

  public adminRegister(admin: Admin): Observable<any> {
    return this.http.post('http://localhost:8080/addAdmin', admin);
  }

  public getAllProvider(): Observable<any> {
    return this.http.get('http://localhost:8080/getAllProvider');
  }

  public getAllOrdeList(): Observable<any> {
    return this.http.get('http://localhost:8080/getAllOrders');
  }

  public updatestatusreject(pid: String, value: any): Observable<any> {
    console.log("approve pid => " + pid)
    return this.http.put('http://localhost:8080/updatestatusreject/' + pid, value);
  }

  public updatestatustoapprove(pid: String, value: any): Observable<any> {
    return this.http.put('http://localhost:8080/updatestatusapprove/' + pid, value);
  }

  //getPerticularOrder
  public getPerticularOrder(pid: String): Observable<any> {
    return this.http.get('http://localhost:8080/getPerticularOrder/' + pid);
  }

}
