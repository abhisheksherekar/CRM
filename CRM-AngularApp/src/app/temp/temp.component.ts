import { Component, OnInit } from '@angular/core';
import { CustomerRegistrationService } from "../service/customer-registration.service";
import { HostListener, ViewChild } from '@angular/core';


@Component({
  selector: 'app-temp',
  templateUrl: './temp.component.html',
  styleUrls: ['./temp.component.css']
})
export class TempComponent implements OnInit {


  constructor(private cu: CustomerRegistrationService) {

  }



  ngOnInit(): void {


    // $(document).ready(function () {

    //   /* 1. Visualizing things on Hover - See next part for action on click */
    //   $('#stars li').on('mouseover', function () {
    //     var onStar = parseInt($(this).data('value'), 10); // The star currently mouse on

    //     // Now highlight all the stars that's not after the current hovered star
    //     $(this).parent().children('li.star').each(function (e) {
    //       if (e < onStar) {
    //         $(this).addClass('hover');
    //       }
    //       else {
    //         $(this).removeClass('hover');
    //       }
    //     });

    //   }).on('mouseout', function () {
    //     $(this).parent().children('li.star').each(function (e) {
    //       $(this).removeClass('hover');
    //     });
    //   });


    //   /* 2. Action to perform on click */
    //   $('#stars li').on('click', function () {
    //     var onStar = parseInt($(this).data('value'), 10); // The star currently selected
    //     var stars = $(this).parent().children('li.star');

    //     for (let i = 0; i < stars.length; i++) {
    //       $(stars[i]).removeClass('selected');
    //     }

    //     for (let i = 0; i < onStar; i++) {
    //       $(stars[i]).addClass('selected');
    //     }

    //     // JUST RESPONSE (Not needed)
    //     var ratingValue = parseInt($('#stars li.selected').last().data('value'), 10);


    //     var msg = "";
    //     if (ratingValue > 1) {
    //       msg = "Thanks! You rated this " + ratingValue + " stars.";
    //     }
    //     else {
    //       msg = "We will improve ourselves. You rated this " + ratingValue + " stars.";
    //     }
    //     responseMessage(msg);

    //   });


    // });


    // function responseMessage(msg) {
    //   $('.success-box').fadeIn(200);
    //   $('.success-box div.text-message').html("<span>" + msg + "</span>");
    // }



  }
  // fun() {
  //   this.finalRating = parseInt($('#stars li.selected').last().data('value'), 10);
  //   console.log("raing : " + this.finalRating);
  // }

  // onClick(id: Number) {
  //   console.log("Number > " + id);
  //   this.cu.getProviderFeedbackbyId(id.toString()).subscribe(

  //     data => {

  //       this.feedback = data;

  //     }
  //   );
  //   console.log("4444");
  //   console.log(this.feedback);
  // }


  //ratingValue;

}
