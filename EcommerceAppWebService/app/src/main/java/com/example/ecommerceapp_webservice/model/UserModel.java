// UserModel.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.ecommerceapp_webservice.model;

public class UserModel {
    private String password;
    private Address address;
    private String phone;
    private long v;
    private Name name;
    private long id;
    private String email;
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address value) {
        this.address = value;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String value) {
        this.phone = value;
    }

    public long getV() {
        return v;
    }

    public void setV(long value) {
        this.v = value;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name value) {
        this.name = value;
    }

    public long getid() {
        return id;
    }

    public void setid(long value) {
        this.id = value;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String value) {
        this.username = value;
    }
}

class Address {
    private String zipcode;
    private long number;
    private String city;
    private String street;
    private Geolocation geolocation;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String value) {
        this.zipcode = value;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long value) {
        this.number = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String value) {
        this.street = value;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation value) {
        this.geolocation = value;
    }
}

// Geolocation.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Geolocation {
    private String lat;
    private String geolocationLong;

    public String getLat() {
        return lat;
    }

    public void setLat(String value) {
        this.lat = value;
    }

    public String getGeolocationLong() {
        return geolocationLong;
    }

    public void setGeolocationLong(String value) {
        this.geolocationLong = value;
    }
}

class Name {
    private String firstname;
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String value) {
        this.firstname = value;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String value) {
        this.lastname = value;
    }
}
