package org.academiadecodigo.cheguei.command;

import org.academiadecodigo.cheguei.persistence.model.Events.EventType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EventsDto {

    @NotNull(message = "Address is mandatory")
    @NotBlank(message = "Address is mandatory")
    @Size(min = 9)
    private String address;

    @NotNull(message = "Event title is mandatory")
    @NotBlank(message = "Event title is mandatory")
    @Size(min = 3)
    private String eventTitle;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String date;

    @NotNull(message = "Description is mandatory")
    @NotBlank(message = "Description is mandatory")
    @Size( min = 9, max = 350)
    private String description;

    @NotNull(message = "Maximum capacity is mandatory")
    @NotBlank(message = "Maximum capacity is mandatory")
    private String maximumCapacity;

    @NotNull(message = "Event type is mandatory")
    private EventType eventType;

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
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

    public void setEventTitle(String eventType) {
        this.eventTitle = eventType;
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
}
