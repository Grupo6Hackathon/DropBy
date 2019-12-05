package org.academiadecodigo.cheguei.persistence.model;

import org.academiadecodigo.cheguei.persistence.model.Events.Events;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends AbstractModel {

    private String firstName;
    private String lastName;
    private String city;
    private String username;
    private String email;
    private String password;

    @OneToMany(cascade = {CascadeType.ALL},
                orphanRemoval = true,
                mappedBy = "user",
                fetch = FetchType.EAGER
    )
    private List<Events> events = new ArrayList<>();

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Events> getEvents() {
        return events;
    }

    public void addEvents(Events event) {
        events.add(event);
        event.setUser(this);
    }

    public void removeEvents(Events event) {
        events.remove(event);
        event.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", events=" + events +
                '}';
    }
}
