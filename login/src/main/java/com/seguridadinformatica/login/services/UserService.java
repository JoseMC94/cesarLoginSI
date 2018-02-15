package com.seguridadinformatica.login.services;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.seguridadinformatica.login.modelo.UserRole;
import com.seguridadinformatica.login.repository.UserRepository;

@Repository("userService")
public class UserService implements UserDetailsService {
    @Autowired
    @Qualifier("userRepository")
    private UserRepository UserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.seguridadinformatica.login.modelo.User user = UserRepository.findByUsername(username);
        List<GrantedAuthority> autohorities = buildAuthorities(user.getUserRole());
        return buildUser(user,autohorities);
    }

    private User buildUser(com.seguridadinformatica.login.modelo.User user, List<GrantedAuthority> autohorities){
        return new User(user.getUsername(),user.getPass(),user.isEnabled(),
                true,true,true,autohorities);
    }

    private  List<GrantedAuthority> buildAuthorities(Set<UserRole> userRole){
        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        for (UserRole userRoles : userRole){
            auths.add(new SimpleGrantedAuthority(userRoles.getRole()));
        }
        return new ArrayList<GrantedAuthority>(auths);
    }
}