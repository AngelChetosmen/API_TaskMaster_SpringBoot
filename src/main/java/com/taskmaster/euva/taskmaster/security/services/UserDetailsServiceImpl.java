package com.taskmaster.euva.taskmaster.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService; // <-- Esta es la INTERFAZ de Spring
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taskmaster.euva.taskmaster.model.User;
import com.taskmaster.euva.taskmaster.repository.UserRepository; 
import com.taskmaster.euva.taskmaster.security.impl.UserDetailsImpl; 

/**
 * Esta clase implementa la interfaz UserDetailsService de Spring Security.
 * Su único propósito es cargar un usuario desde la base de datos
 * y convertirlo en un objeto UserDetails.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService { // <-- Implementa la interfaz de Spring

    @Autowired
    UserRepository userRepository;

    /**
     * Este método es llamado por Spring Security cuando un usuario intenta autenticarse.
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. Busca el usuario en tu base de datos usando el repositorio
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el username: " + username));

        // 2. Usa el método 'build' de TU OTRA CLASE (UserDetailsImpl) 
        //    para convertir el 'User' de la DB en un 'UserDetails' de Spring.
        return UserDetailsImpl.build(user);
    }
}