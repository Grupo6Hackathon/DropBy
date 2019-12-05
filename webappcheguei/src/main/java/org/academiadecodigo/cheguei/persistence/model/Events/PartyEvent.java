package org.academiadecodigo.cheguei.persistence.model.Events;

import javax.persistence.Entity;

@Entity
public class PartyEvent extends Events {

    @Override
    public EventType getEventType() {
        return EventType.PARTY_EVENT;
    }
}
