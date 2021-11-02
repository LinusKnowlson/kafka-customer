package spring.cloud.kafka.customer.models;

import javax.persistence.*;

import java.util.Objects;
//entity class of customer
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String companyName;
    private String address;
    private String country;
    private Long contact;

    public Customer() {}

    public Customer(String companyName, String address, String country, Long contact) {
        this.companyName = companyName;
        this.address = address;
        this.country = country;
        this.contact = contact;
    }
    //accessors and mutators
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}
	//retrieve all the information of customer
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Customer))
            return false;
        Customer Customer = (Customer) o;
        return Objects.equals(this.id, Customer.id)
                && Objects.equals(this.companyName, Customer.companyName)
                && Objects.equals(this.address, Customer.address)
                && Objects.equals(this.country, Customer.country)
                && Objects.equals(this.contact, Customer.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.companyName, this.address, this.country, this.contact);
    }
}
