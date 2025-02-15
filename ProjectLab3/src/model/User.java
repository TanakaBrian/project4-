/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author wolves
 */
public class User {
    
   //data members
 private String name;
           private String surname;
           private String email;
           private String phoneNumber;
           private String gender;
           private Integer age ;
           private String hobby;
           
     //methods
           public String getName() {
           return name;
           }
           
           public void setName (String name) {
            this.name = name;
           }
           
           public String getSurname() {
    return surname;
}

public void setSurname(String surname) {
    this.surname = surname;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getPhoneNumber() {
    return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
}

public String getGender() {
    return gender;
}

public void setGender(String gender) {
    this.gender = gender;
}

public Integer getAge() {
    return age;
}

public void setAge(Integer age) {
    this.age = age;
}

public String getHoby() {
    return hobby;
}

public void setHoby(String hoby) {
    this.hobby = hoby;
}
           
  
   @Override
public String toString() {
    return "User{" 
        + " name=" + name + "\n" 
        + ", surname=" + surname + "\n" 
        + ", email=" + email 
        + ", phoneNumber=" + phoneNumber + "\n" 
        + ", gender=" + gender + "\n" 
        + ", age=" + age + "\n" 
        + ", hoby=" + hobby + "\n" 
        + "}";
}
           
           
     
    
}
