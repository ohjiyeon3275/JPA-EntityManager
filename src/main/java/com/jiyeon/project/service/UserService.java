package com.jiyeon.project.service;

import com.jiyeon.project.domain.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Service
public class UserService {

    public void save(){

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("jpa-practice");

        EntityManager em = entityManagerFactory.createEntityManager();

        /**
         * hibernate 로 작성했을때는
         * 반드시 entityTransaction으로 커밋해줘야 db에 정상적으로 insert 된다.
         */
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        User user = new User();

        user.setAge(99L);
        user.setName("em test");
        user.setPhone("010111122");

        em.persist(user);
        tx.commit();
    }


}
