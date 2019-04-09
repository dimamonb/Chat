package ru.sbrf.sandbox.sberchat.domain;

import java.util.Collection;

/**
 * Сервис чата.
 */
public interface SberchatService {

    /** Получить все сообщения чата. */
    Collection<Message> getMessages();

    /** Добавить сообщение в чат. */
    void addMessage(Message message);
}
