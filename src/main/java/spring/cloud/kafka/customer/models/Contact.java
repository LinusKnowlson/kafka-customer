package spring.cloud.kafka.customer.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//entity class of contact
@Entity
public class Contact {

    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String position;

    public Contact() {}

    public Contact(String firstName, String lastName, String phone, String email, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.position = position;
    }
    //accessors and mutators
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setName(String name) {
        String[] parts = name.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Contact))
            return false;
        Contact contact = (Contact) o;
        return Objects.equals(this.id, contact.id) && Objects.equals(this.firstName, contact.firstName)
                && Objects.equals(this.lastName, contact.lastName) && Objects.equals(this.email, contact.email)
                && Objects.equals(this.position, contact.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.phone ,this.lastName, this.email, this.position);
    }
    //retrieve all the information
    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}