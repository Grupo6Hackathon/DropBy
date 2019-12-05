package org.academiadecodigo.cheguei.factories;

import org.academiadecodigo.cheguei.persistence.model.Events.EventType;
import org.academiadecodigo.cheguei.persistence.model.Events.Events;
import org.academiadecodigo.cheguei.persistence.model.Events.PartyEvent;
import org.springframework.stereotype.Component;

@Component
public class EventsFactory {

    public Events createEvent(EventType eventType){

        Events newEvent;

        // For future different types
        switch (eventType){
            case PARTY_EVENT:
                newEvent = new PartyEvent();
                break;
            default:
                return null;
        }

        return newEvent;
    }
}
