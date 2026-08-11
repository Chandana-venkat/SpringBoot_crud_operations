package com.codegnan.app.javawebapp11082026.dao;

import com.codegnan.app.javawebapp11082026.dto.CredentialsDto;
import com.codegnan.app.javawebapp11082026.dto.UserDto;
import com.codegnan.app.javawebapp11082026.entity.Credentials;
import com.codegnan.app.javawebapp11082026.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public boolean save(UserDto userDto, CredentialsDto credentialsDto) {

        boolean isSaved = false;

        Credentials credentials = new Credentials(
                credentialsDto.getUsername(),
                credentialsDto.getLoginPassword()
        );

        User user = new User(
                userDto.getFirstName(),
                userDto.getLastName()
        );

        user.setCredentials(credentials);

        SessionFactory sessionFactory = DatabaseUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        isSaved = true;

        session.close();

        return isSaved;
    }

    @Override
    public boolean deleteByUserId(int userId) {

        boolean isDeleted = false;

        Session session = DatabaseUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, userId);

        if (user != null) {

            session.delete(user);

            transaction.commit();
            isDeleted = true;
        }

        session.close();

        return isDeleted;
    }

    @Override
    public boolean changePassword(int userId, String newLoginPassword) {

        boolean isUpdated = false;

        Session session = DatabaseUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, userId);

        if (user != null) {

            Credentials credentials = user.getCredentials();

            credentials.setLoginPassword(newLoginPassword);

            user.setCredentials(credentials);

            session.merge(user);

            transaction.commit();
            isUpdated = true;
        }

        session.close();

        return isUpdated;
    }

    @Override
    public List<User> getAllUsers() {

        List<User> usersList = new ArrayList<>();

        Session session = DatabaseUtility.getSessionFactory().openSession();

        try {

            String hql = "SELECT u FROM User u JOIN FETCH u.credentials";

            Query<User> query = session.createQuery(hql, User.class);

            usersList = query.getResultList();

        } finally {

            session.close();
        }

        return usersList;
    }

    @Override
    public UserDto findByUsernameAndLoginPassword(
            String username,
            String loginPassword) {

        UserDto userDto = null;

        Session session = DatabaseUtility.getSessionFactory().openSession();

        String hql =
                "FROM User u WHERE u.credentials.username = :usr " +
                        "AND u.credentials.loginPassword = :lpass";

        Query<User> query = session.createQuery(hql, User.class);

        query.setParameter("usr", username);
        query.setParameter("lpass", loginPassword);

        List<User> usersList = query.getResultList();

        if (usersList != null && usersList.size() > 0) {

            User user = usersList.get(0);

            userDto = new UserDto();

            userDto.setUserId(user.getUserId());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
        }

        session.close();

        return userDto;
    }
}