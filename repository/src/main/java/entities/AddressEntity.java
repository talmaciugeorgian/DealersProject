package entities;

import dto.User;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private String addressId;

    @Column(name = "street")
    private String street;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    public AddressEntity() {
    }

    public AddressEntity(String street, String postalCode, String city, String phone) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.phone = phone;
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
