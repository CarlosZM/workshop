package pe.utec.fullstack.workshop.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.utec.fullstack.workshop.controller.UserMapping;
import pe.utec.fullstack.workshop.controller.auth.UserInfoDetails;
import pe.utec.fullstack.workshop.domain.business.User;
import pe.utec.fullstack.workshop.repository.*;

import java.time.LocalDateTime;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserMapping mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findByEnabledTrueAndUserName(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User not found with email: " + username));

        return new UserInfoDetails(user);
    }

    public User createUser(User user) {

        UserEntity userEntity = this.mapper.convert(user);

        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        userEntity.setCreatedAt(LocalDateTime.now());
        userEntity.setEnabled(true);

        return this.mapper.convert(
                this.userRepository.saveAndFlush(
                        userEntity
                )
        );
    }
}
