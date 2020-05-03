package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final EntityManager entityManager;

    @Transactional
    public UserEntity createUser(String firstName, String lastName){
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);

        return entityManager.merge(user);
    }

    @Transactional
    public List<UserEntity> getAllUsers(){
        return entityManager.createQuery("SELECT t from UserEntity t").getResultList();
    }

    @Transactional
    public List<UserEntity> getUsersByLastName(String lastName){
        return entityManager.createQuery("SELECT t from UserEntity t where t.lastName = :lastName")
                .setParameter("lastName",lastName)
                .getResultList();
    }

    @Transactional List<UserEntity> getUsersBySubstring(String substring){
        return entityManager.createQuery("SELECT t from UserEntity t" +
                " where t.firstName like concat('%',:substring,'%') or t.lastName like concat('%',:substring,'%') ")
                .setParameter("substring",substring)
                .getResultList();
    }
}
