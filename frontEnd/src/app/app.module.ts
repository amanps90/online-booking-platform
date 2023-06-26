import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './components/nav/nav.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './components/signup/signup.component';
import { BookingPageComponent } from './components/booking-page/booking-page.component';
import { DialogComponent } from './components/dialog/dialog.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './uiModule/material/material.module';
import { SearchResultComponent } from './components/search-result/search-result.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { SearchFlightComponent } from './components/search-flight/search-flight.component';
import { AdminhomeComponent } from './components/adminhome/adminhome.component';
import { BookedTicketsComponent } from './components/booked-tickets/booked-tickets.component';
import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { FlightListComponent } from './components/flight-list/flight-list.component';
import { NewFlightComponent } from './components/new-flight/new-flight.component';
import { NewScheduleComponent } from './components/new-schedule/new-schedule.component';
import { ScheduleComponent } from './components/schedule/schedule.component';
import { PriceComponent } from './components/price/price.component';
import { AdminComplaintsComponent } from './components/admin-complaints/admin-complaints.component';
import { BookingListForComplaintComponent } from './components/booking-list-for-complaint/booking-list-for-complaint.component';
import { CompainPopupComponent } from './components/compain-popup/compain-popup.component';
import { EditProfileComponent } from './components/edit-profile/edit-profile.component';
import { OfferListComponent } from './components/offer-list/offer-list.component';
import { NewOfferComponent } from './components/new-offer/new-offer.component';
import { FeedbackComponent } from './components/feedback/feedback.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { OtpComponent } from './components/otp/otp.component';
import { BlockAccountsComponent } from './components/block-accounts/block-accounts.component';
import { CheckMailComponent } from './components/check-mail/check-mail.component';
import { VerifyComponent } from './components/verify/verify.component';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent,
    SigninComponent,
    SignupComponent,
    BookingPageComponent,
    DialogComponent,
    SearchResultComponent,
    SearchFlightComponent,
    AdminhomeComponent,
    BookedTicketsComponent,
    AdminHomeComponent,
    FlightListComponent,
    NewFlightComponent,
    NewScheduleComponent,
    ScheduleComponent,
    PriceComponent,
    AdminComplaintsComponent,
    BookingListForComplaintComponent,
    CompainPopupComponent,
    EditProfileComponent,
    OfferListComponent,
    NewOfferComponent,
    FeedbackComponent,
    OtpComponent,
    BlockAccountsComponent,
    CheckMailComponent,
    VerifyComponent
   
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MaterialModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    NgbModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
