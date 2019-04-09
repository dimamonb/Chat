package ru.sbrf.sandbox.sberchat.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Хранит сообщения в памяти.
 */
public class InMemorySberchatService implements SberchatService {

    private List<Message> messages = new CopyOnWriteArrayList<Message>();

    public Collection<Message> getMessages() {
        return new ArrayList<Message>(messages);
    }

    public void addMessage(Message message) {
        messages.add(message);
    }
}
