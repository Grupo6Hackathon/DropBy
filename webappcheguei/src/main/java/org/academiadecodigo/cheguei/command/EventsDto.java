package org.academiadecodigo.cheguei.command;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EventsDto {

    private Integer id;

    @NotNull(message = "Address is mandatory")
    @NotBlank(message = "Address is mandatory")
    @Size(min = 3)
    private String address;

    @NotNull(message = "Event title is mandatory")
    @NotBlank(message = "Event title is mandatory")
    @Size(min = 3)
    private String eventTitle;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Date is mandatory")
    @NotBlank(message = "Date is mandatory")
    @Size(min = 10)
    private String date;

    @NotNull(message = "Description is mandatory")
    @NotBlank(message = "Description is mandatory")
    @Size( min = 9, max = 350)
    private String description;

    @NotNull(message = "Maximum capacity is mandatory")
    @NotBlank(message = "Maximum capacity is mandatory")
    private String maximumCapacity;

    public Integer getId() {
        return id;
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
