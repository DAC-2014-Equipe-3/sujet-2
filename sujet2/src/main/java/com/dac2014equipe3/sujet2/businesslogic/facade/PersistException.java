package com.dac2014equipe3.sujet2.businesslogic.facade;

import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author Edward
 */
public class PersistException extends DatabaseException {

    PersistException(String message) {
        super(message);
    }
    
}
