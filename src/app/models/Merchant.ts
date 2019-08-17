
export class Merchant {

  merchantId: number;
  firstName: string;
  lastName: string;
  company: string;
  emailid: string;
  mobileno: number;
  password: string;
  photo: string;
  rating: number;


  constructor(merchantId, firstName, lastName, company, emailid, mobileno, password, photo, rating ) {
    this.merchantId = merchantId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.company = company;
    this.emailid = emailid;
    this.mobileno = mobileno;
    this.password = password;
    this.photo = photo;
    this.rating = rating;
  }

}
