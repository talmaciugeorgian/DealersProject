package dto;

import javax.jws.soap.SOAPBinding;
import java.io.Serializable;

public class Address implements Serializable {
    private String addressId;
    private String street;
    private String postalCode;
    private String city;
    private String phone;

    public Address(String street, String postalCode, String city, String phone) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.phone = phone;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
