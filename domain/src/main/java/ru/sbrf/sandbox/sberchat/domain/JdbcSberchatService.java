package ru.sbrf.sandbox.sberchat.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * Stores mesages via JDBC.
 */
public class JdbcSberchatService implements SberchatService {

    @Autowired
    MessageDao dao;

    public Collection<Message> getMessages() {
        return dao.getMessages();
    }

    public void addMessage(Message message) {
        dao.saveMessage(message);
    }


}
