package AdminMainPage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeData {
    
private StringProperty id;
private StringProperty Username;
private StringProperty Password;
private StringProperty Fullname;
private StringProperty Phonenumber;
private StringProperty Address;
private StringProperty Email;
private StringProperty Classnumber;
private StringProperty SubjectsOfStudying;
private StringProperty JobType;
private StringProperty Date;



public EmployeeData(String id,String date,String username,String password, String fullname,String address
,String phonenumber,String email, String subjectsofstudying,String classnumber,String jobtype) {

    this.id = new SimpleStringProperty(id); //1
    this.Date = new SimpleStringProperty(date); //2
    this.Username = new SimpleStringProperty(username); //3
    this.Password = new SimpleStringProperty(password); //4
    this.Fullname = new SimpleStringProperty(fullname); //5
    this.Address = new SimpleStringProperty(address); //6
    this.Phonenumber = new SimpleStringProperty(phonenumber); //7
    this.Email = new SimpleStringProperty(email); //8
    this.SubjectsOfStudying = new SimpleStringProperty(subjectsofstudying); //9
    this.Classnumber = new SimpleStringProperty(classnumber); //10
    this.JobType = new SimpleStringProperty(jobtype); //11

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


public StringProperty fullnameProperty() {
    return Fullname;
}


public void setFullname(StringProperty fullname) {
    this.Fullname = fullname;
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
