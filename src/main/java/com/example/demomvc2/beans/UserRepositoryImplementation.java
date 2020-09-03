package com.example.demomvc2.beans;

import com.example.demomvc2.models.User;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository //Con esto decimos que es un componente y no hace falta el SpringConfigurator
//@Scope (ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserRepositoryImplementation implements UserRepository {
    private List<User> users;

    public UserRepositoryImplementation() {
        users = new ArrayList<>();
        users.add(new User("mike","123"));
        users.add(new User("peter","123"));
        users.add(new User("Jhon","123"));
    }

    @Override
    public List<User> getUsers() {
        System.out.println("userRepositoryImplementation " + hashCode());
        return new ArrayList<>(users);
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void removeUser(User user) {

    }
}
