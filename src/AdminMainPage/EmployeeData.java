package AdminMainPage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeData {
    
private StringProperty id;
private StringProperty Username;
private StringProperty Password;
private StringProperty Firstname;
private StringProperty Lastname;
private StringProperty Phonenumber;
private StringProperty Address;
private StringProperty Email;
private StringProperty Classnumber;
private StringProperty SubjectsOfStudying;
private StringProperty JobType;
private StringProperty Date;



public EmployeeData(String id,String date,String username,String password, String firstname,String lastname,String address
,String phonenumber,String email, String subjectsofstudying,String classnumber,String jobtype) {

    this.id = new SimpleStringProperty(id); //1
    this.Date = new SimpleStringProperty(date); //2
    this.Username = new SimpleStringProperty(username); //3
    this.Password = new SimpleStringProperty(password); //4
    this.Firstname = new SimpleStringProperty(firstname); //5
    this.Lastname = new SimpleStringProperty(lastname); //6
    this.Address = new SimpleStringProperty(address); //7
    this.Phonenumber = new SimpleStringProperty(phonenumber); //8
    this.Email = new SimpleStringProperty(email); //9
    this.SubjectsOfStudying = new SimpleStringProperty(subjectsofstudying); //10
    this.Classnumber = new SimpleStringProperty(classnumber); //11
    this.JobType = new SimpleStringProperty(jobtype); //12

}


public StringProperty firstnamePropery() {
    return Firstname;
}


public void setFirstname(StringProperty firstname) {
    this.Firstname = firstname;
}


public StringProperty lastnameProperty() {
    return Lastname;
}


public void setLastname(StringProperty lastname) {
    this.Lastname = lastname;
}


public StringProperty dateProperty() {
    return Date;
}


public void setDate(StringProperty date) {
    this.Date = date;
}


public StringProperty jobtypeProperty() {
    return JobType;
}


public void setPayment(StringProperty jobtype) {
    this.JobType = jobtype;
}


public StringProperty usernameProperty() {
    return Username;
}


public void setUsername(StringProperty username) {
    this.Username = username;
}


public StringProperty passwordProperty() {
    return Password;
}


public void setPassword(StringProperty password) {
    this.Password = password;
}


public StringProperty idProperty() {
    return id;
}


public void setId(StringProperty id) {
    this.id = id;
}


public StringProperty phonenumberProperty() {
    return Phonenumber;
}


public void setPhonenumber(StringProperty phonenumber) {
    this.Phonenumber = phonenumber;
}


public StringProperty addressProperty() {
    return Address;
}


public void setAddress(StringProperty address) {
    this.Address = address;
}


public StringProperty emailProperty() {
    return Email;
}


public void setEmail(StringProperty email) {
    this.Email = email;
}


public StringProperty classnumberProperty() {
    return Classnumber;
}


public void setClassnumber(StringProperty classnumber) {
    this.Classnumber = classnumber;
}


public StringProperty subjectsofstudyingProperty() {
    return SubjectsOfStudying;
}


public void setSubjectsOfStudying(StringProperty subjectsofstudying) {
    this.SubjectsOfStudying = subjectsofstudying;
}

}
