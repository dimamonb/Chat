package ru.sbrf.sandbox.sberchat.domain;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

public class JpaSberchatService implements SberchatService {
    private EntityManagerFactory emf;

    public Collection<Message> getMessages() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT m FROM Message m");
        List result = q.getResultList();
        return result;
    }

    public void addMessage(Message message) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(message);
        em.getTransaction().commit();
    }

    @PostConstruct
    public void init() {
        emf = Persistence.createEntityManagerFactory("SberchatPU");
    }
}
