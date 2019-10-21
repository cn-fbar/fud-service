package cs.io.fudservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private String userid;
    private String emailId;

    @OneToOne
    private AppRole appRole;

    public AppUser(String firstName, String lastName, String address1, String address2, String city, String state, String country, String userid, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.userid = userid;
        this.emailId = emailId;
    }
}
