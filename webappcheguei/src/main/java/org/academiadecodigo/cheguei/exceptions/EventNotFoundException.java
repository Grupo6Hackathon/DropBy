package org.academiadecodigo.cheguei.exceptions;

import org.academiadecodigo.cheguei.errors.ErrorMessage;

public class EventNotFoundException extends DropByException {

    public EventNotFoundException(){
        super(ErrorMessage.EVENT_NOT_FOUND);
    }
}
