package org.academiadecodigo.cheguei.persistence.model.Events;

import org.academiadecodigo.cheguei.persistence.model.AbstractModel;
import org.academiadecodigo.cheguei.persistence.model.User;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "event_type")
public abstract class Events extends AbstractModel {

    @ManyToOne
    private User user;

    private String address;
    private String eventTitle;
    private String date;
    private String description;
    private Integer maximumCapacity;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(Integer maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public abstract EventType getEventType();

    @Override
    public String toString() {
        return "Events{" +
                "user=" + user +
                ", address='" + address + '\'' +
                ", eventTitle='" + eventTitle + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", maximumCapacity=" + maximumCapacity +
                '}';
    }
}
