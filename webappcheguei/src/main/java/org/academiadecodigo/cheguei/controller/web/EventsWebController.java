package org.academiadecodigo.cheguei.controller.web;

import org.academiadecodigo.cheguei.command.EventsDto;
import org.academiadecodigo.cheguei.converters.EventsDtoToEvents;
import org.academiadecodigo.cheguei.converters.EventsToEventsDto;
import org.academiadecodigo.cheguei.persistence.model.Events.Events;
import org.academiadecodigo.cheguei.services.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/events")
public class EventsWebController {

    private EventsService eventsService;
    private EventsDtoToEvents eventsDtoToEvents;
    private EventsToEventsDto eventsToEventsDto;

    @Autowired
    public void setEventsToEventsDto(EventsToEventsDto eventsToEventsDto) {
        this.eventsToEventsDto = eventsToEventsDto;
    }

    @Autowired
    public void setEventsDtoToEvents(EventsDtoToEvents eventsDtoToEvents) {
        this.eventsDtoToEvents = eventsDtoToEvents;
    }

    @Autowired
    public void setEventsService(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String events() {
        return "events/events";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String event(@PathVariable Integer id, Model model) {
        model.addAttribute("events", eventsToEventsDto.convert(eventsService.getEvent(id)));
        return "events/event1";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/register")
    public String event(Model model) {
        model.addAttribute("event", new EventsDto());

        return "events/createevent";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public String registerEvent(@Valid @ModelAttribute("event") EventsDto eventsDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "events/createevent";
        }

        Events events = eventsService.addEvent(eventsDtoToEvents.convert(eventsDto));

        redirectAttributes.addFlashAttribute("lastAction", "Event was created with success.");
        return "redirect:/index";
    }


}
