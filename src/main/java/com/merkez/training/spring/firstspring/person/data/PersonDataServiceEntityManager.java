package com.merkez.training.spring.firstspring.person.data;

import com.merkez.training.spring.firstspring.person.data.access.IPersonDao;
import com.merkez.training.spring.firstspring.person.services.models.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public class PersonDataServiceEntityManager {

    @PersistenceContext
    private EntityManager entityManager;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public void insert(PersonDTO personDTOParam) {
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        entityManager1.getTransaction()
                     .begin();
        try {
            entityManager1.persist(personDTOParam);
            entityManager1.getTransaction()
                         .commit();
        } catch (Exception ex) {
            entityManager1.getTransaction()
                         .rollback();
        } finally {
            entityManager1.close();
        }
    }

    @Transactional
    public void insertJTA(PersonDTO personDTOParam) {
        boolean contains = entityManager.contains(personDTOParam);
        if (!contains){
            PersonDTO merge = entityManager.merge(personDTOParam);
            merge.getAddress();
        }
        entityManager.joinTransaction();
        entityManager.persist(personDTOParam);
    }

}
