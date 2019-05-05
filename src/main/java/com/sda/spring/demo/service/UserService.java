package com.sda.spring.demo.service;

import com.sda.spring.demo.interfaces.UserInterface;
import com.sda.spring.demo.model.MyUserDetails;
import com.sda.spring.demo.model.User;
import com.sda.spring.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService implements UserInterface, UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public Optional<User> findByName(String name){
        return userRepository.findByName(name);}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = findByName(username).orElseThrow(()->new UsernameNotFoundException("Nie odnaleziono uzytkownika"+ username));
        return new MyUserDetails(user) {
        };
    }

}
