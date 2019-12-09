package org.academiadecodigo.cheguei.controller.rest;

import org.academiadecodigo.cheguei.command.EventsDto;
import org.academiadecodigo.cheguei.converters.EventsDtoToEvents;
import org.academiadecodigo.cheguei.converters.EventsToEventsDto;
import org.academiadecodigo.cheguei.persistence.model.Events.Events;
import org.academiadecodigo.cheguei.services.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/events")
public class RestEventController {

    private EventsService eventsService;
    private EventsDtoToEvents eventsDtoToEvents;
    private EventsToEventsDto eventsToEventsDto;

    @Autowired
    public void setEventsService(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @Autowired
    public void setEventsDtoToEvents(EventsDtoToEvents eventsDtoToEvents) {
        this.eventsDtoToEvents = eventsDtoToEvents;
    }

    @Autowired
    public void setEventsToEventsDto(EventsToEventsDto eventsToEventsDto) {
        this.eventsToEventsDto = eventsToEventsDto;
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addEvent(@Valid @RequestBody EventsDto eventsDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder){


        if (bindingResult.hasErrors() || eventsDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        System.out.println(eventsDto.toString());


        Events newEvent = eventsService.addEvent(eventsDtoToEvents.convert(eventsDto));

        System.out.println(newEvent.toString());

        UriComponents uriComponents = uriComponentsBuilder.path("/user" + newEvent.getId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }
}
