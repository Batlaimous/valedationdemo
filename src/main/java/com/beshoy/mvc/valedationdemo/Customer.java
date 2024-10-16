package com.beshoy.mvc.valedationdemo;

import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;

    @NotNull(message="is required")
    @Size(min=6, max=20,message="enter name from 6 char to 20 char")
    private String lastName;

    @Min(value = 0,message = "must be greater than or equal to zero")
    @Max(value = 10,message = "must be less than or equal to 10")
    private int freePasses;

    @Pattern(regexp ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "please enter a valid email address")
    private String email;

    @Pattern(regexp ="^[a-zA-Z0-9]{5}",message="only 5 chars/digits")
    private String PostalCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }
}
