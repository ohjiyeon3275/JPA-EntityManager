package com.jiyeon.project.service;

import com.jiyeon.project.domain.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Service
public class UserService {

    private EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("jpa-practice");

    private EntityManager em = entityManagerFactory.createEntityManager();

    private EntityTransaction tx = em.getTransaction();

    public void hibernateSave(){

        /**
         * hibernate 로 작성했을때는
         * 반드시 entityTransaction으로 커밋해줘야 db에 정상적으로 insert 된다.
         */

        tx.begin();
        User user = new User();

        user.setAge(99L);
        user.setName("em test");
        user.setPhone("010111122");

        em.persist(user);
        tx.commit();

    }


    public void entityManager() {

        tx.begin();

        User user = new User();

        user.setName("jiyeon");
        user.setAge(29L);
        user.setPhone("010123321");

        em.persist(user);

        Long findId = user.getId();

        System.out.println("commit 이전 getName>>>");
        System.out.println(em.find(User.class, findId).getName());

        tx.commit();

        System.out.println("commit ~ clear getName>>>");
        System.out.println(em.find(User.class, findId).getName());

        em.clear();

        System.out.println("clear ~ close getName>>>");
        System.out.println(em.find(User.class, findId).getName());

        em.close();

        System.out.println("close 이후 getName>>>");
        System.out.println(em.find(User.class, findId).getName());

    }
}
