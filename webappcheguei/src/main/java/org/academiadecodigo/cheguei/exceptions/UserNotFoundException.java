package org.academiadecodigo.cheguei.exceptions;

import org.academiadecodigo.cheguei.errors.ErrorMessage;

public class UserNotFoundException extends DropByException {

    public UserNotFoundException(String message) {
        super(ErrorMessage.USER_NOT_FOUND);
    }
}
