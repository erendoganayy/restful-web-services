package com.restful.rest.webservices.restfulwebservices.user;

import org.springframework.dao.DataAccessException;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;



public class User {
    private Integer id;
@NotBlank(message = "Name field may not be blank!")
    @Size(min =2,message = "Name should have atleast 2 characters")
    private String name;

    @Past(message = "Time must be past from now!")
    private Date birthDate;

    protected User(){

    }

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
