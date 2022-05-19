package com.project.Capstone.dao;

import java.util.ArrayList;

import com.project.Capstone.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JWTUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonDao personDao;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        Person user = personDao.findPersonById(Integer.valueOf(id));
        if (user == null) {
            throw new UsernameNotFoundException("User not found with id: " + id);
        }
        return new org.springframework.security.core.userdetails.User(id, user.getPassword(),
                new ArrayList<>());
    }

}