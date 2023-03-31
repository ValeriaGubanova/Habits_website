package com.javapoint.habits.config;

import com.javapoint.habits.model.Client;
import com.javapoint.habits.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Client client = clientRepository.getUserByUsername(username);

        if (client == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(client);
    }

}
