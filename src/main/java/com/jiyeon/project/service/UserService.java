package com.jiyeon.project.service;

import com.jiyeon.project.domain.Seat;
import com.jiyeon.project.domain.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Service
public class UserService {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");

    private EntityManager em = entityManagerFactory.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    public void hibernateSave(){

        /**
         * hibernate 로 작성했을때는
         * 반드시 entityTransaction으로 커밋해줘야 db에 정상적으로 insert 된다.
         */

        tx.begin();
        Seat seat = new Seat();
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

    public void entityManagerFlush() {

        tx.begin();
        User user = new User();

        user.setName("happy new year 2022");
        user.setAge(10L);
        user.setPhone("1234321");

        em.persist(user);

        Long findId = user.getId();

        System.out.println("flush 이전 getName>>>");
        System.out.println(em.find(User.class, findId).getName());

        em.flush();

        System.out.println("flush  ~ commit getName>>>");
        System.out.println(em.find(User.class, findId).getName());

        tx.commit();

        System.out.println("commit  ~ close getName>>>");
        System.out.println(em.find(User.class, findId).getName());

        em.close();

        System.out.println("close 이후 getName>>>");
        System.out.println(em.find(User.class, findId).getName());

    }

    public void entityManagerDetach() {

        tx.begin();
        User user = new User();

        user.setName("detach test ~~");
        user.setAge(111L);
        user.setPhone("phone number");

        em.persist(user);
        Long findId = user.getId();

        System.out.println(findId);
        System.out.println(">>>findId");

        em.detach(user);

        System.out.println(findId);
        System.out.println(">>>findId");
        System.out.println("detach 이후 getName>>>");
        System.out.println(em.find(User.class, findId).getName());


//        em.persist(user);

        System.out.println(findId);
        System.out.println(">>>findId");

//        System.out.println("다시 persist 이후 getName>>>");
//        System.out.println(em.find(User.class, findId).getName());

        tx.commit();
        em.close();
    }

    public void entityManagerMerge() {

        EntityManager em1 = entityManagerFactory.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();

        tx1.begin();
        User user = new User();

        user.setName("before merge name ~~");
        user.setAge(1L);
        user.setPhone("phone 1 number");

        em1.persist(user);

        tx1.commit();
        em1.close();

        user.setName("merge test set name");

        EntityManager em2 = entityManagerFactory.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();

        tx2.begin();
        System.out.println(">>>>load>>>>>");
        User newUser = em2.merge(user);

        System.out.println(">>>>new user persist ");
        em2.persist(newUser);
        tx2.commit();

        System.out.println(newUser.getName());
        System.out.println(">>> new User getName");

        System.out.println(newUser.getPhone());
        System.out.println(">>> new User getPhone");

    }
}
