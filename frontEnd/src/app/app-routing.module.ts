import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookingPageComponent } from './components/booking-page/booking-page.component';
import { HomeComponent } from './components/home/home.component';
import { SearchFlightComponent } from './components/search-flight/search-flight.component';
import { SearchResultComponent } from './components/search-result/search-result.component';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './components/signup/signup.component';
import { AdminhomeComponent } from './components/adminhome/adminhome.component';
import { BookedTicketsComponent } from './components/booked-tickets/booked-tickets.component';
import { FlightListComponent } from './components/flight-list/flight-list.component';
import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { ScheduleComponent } from './components/schedule/schedule.component';
import { NewFlightComponent } from './components/new-flight/new-flight.component';
import { AdminComplaintsComponent } from './components/admin-complaints/admin-complaints.component';
import { EditProfileComponent } from './components/edit-profile/edit-profile.component';
import { BookingListForComplaintComponent } from './components/booking-list-for-complaint/booking-list-for-complaint.component';
import { FeedbackComponent } from './components/feedback/feedback.component';
import { OtpComponent } from './components/otp/otp.component';
import { BlockAccountsComponent } from './components/block-accounts/block-accounts.component';
import { CheckMailComponent } from './components/check-mail/check-mail.component';
import { VerifyComponent } from './components/verify/verify.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'signin', component: SigninComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'booking', component: BookingPageComponent },
  { path: 'searchResult', component: SearchFlightComponent },
  { path: 'adminhome', component: AdminhomeComponent },
  {path:'feedback', component:FeedbackComponent},
  { path: 'bookedTickets', component: BookedTicketsComponent },
  { path: "flights", component: FlightListComponent },
  { path: "adminHome", component: AdminHomeComponent },
  { path: "schedule", component: ScheduleComponent },
  { path: "newFlight", component: NewFlightComponent },
  { path: '', redirectTo: "/home", pathMatch: 'full' },
  {path:'adminComplaints',component:AdminComplaintsComponent},
  {path:'editProfile',component:EditProfileComponent},
  {path:'bookingList',component:BookingListForComplaintComponent},
  {path:'otp',component:OtpComponent},
  {path:'blockedUsers',component:BlockAccountsComponent},
  {path:'checkMail',component:CheckMailComponent},
  {path:'verify',component:VerifyComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
