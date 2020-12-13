import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AdminservService } from '../service/adminserv.service';


@Component({
  selector: 'app-admin-product-order-list',
  templateUrl: './admin-product-order-list.component.html',
  styleUrls: ['./admin-product-order-list.component.css']
})
export class AdminProductOrderListComponent implements OnInit {

  order: Observable<any[]>;
  temp: any;
  constructor(private adminserv: AdminservService, private router: Router) { }

  ngOnInit(): void {
    this.adminserv.getAllOrdeList().subscribe(
      data => {
        console.log(data);
        this.order = data;

      },
      error => { console.log(error) })
  }

  onApprove(pid: string) {
    this.adminserv.getPerticularOrder(pid).subscribe(
      data => {
        this.temp = data;
        this.adminserv.updatestatustoapprove(pid, this.temp).subscribe(data => { console.log("DONEEEEE") });
        console.log("Approve..");
        //this.router.navigate(['../admin-product-order-list']);
        window.location.reload();
      },
      error => { console.log("++++++++++") });

  }
  onReject(pid: string) {
    this.adminserv.getPerticularOrder(pid).subscribe(
      data => {
        this.temp = data;
        this.adminserv.updatestatusreject(pid, this.temp).subscribe(data => { console.log("DONEEEEE") });
        console.log("REJECT..");
        window.location.reload();
      },
      error => { console.log("+++++ reject error +++++") });

  }
}
