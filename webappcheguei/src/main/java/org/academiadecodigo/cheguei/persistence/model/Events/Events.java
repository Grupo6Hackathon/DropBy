package org.academiadecodigo.cheguei.persistence.model.Events;

import org.academiadecodigo.cheguei.persistence.model.AbstractModel;
import org.academiadecodigo.cheguei.persistence.model.User;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Events extends AbstractModel {

    private String address;
    private String eventTitle;
    private String date;
    private String description;
    private String maximumCapacity;


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

    public String getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(String maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    @Override
    public String toString() {
        return "Events{" +
                "address='" + address + '\'' +
                ", eventTitle='" + eventTitle + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", maximumCapacity='" + maximumCapacity + '\'' +
                '}';
    }
}
