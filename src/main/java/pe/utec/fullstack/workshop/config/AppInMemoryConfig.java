package pe.utec.fullstack.workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration
public class AppInMemoryConfig {

    //@Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder().
                        username("admin")
                        .password(passwordEncoder().encode("admin123")).roles("ADMIN", "PERSONS", "PRODUCTS").
                        build(),
                User.builder().
                        username("juan")
                        .password(passwordEncoder().encode("admin123")).roles("PERSONS").
                        build(),
                User.builder().
                        username("pablo")
                        .password(passwordEncoder().encode("admin123")).roles("PRODUCTS").
                        build()
        );
    }

    //@Bean
    public PasswordEncoder passwordEncoder() {
        //password -> dj2oi8y12dikahsd98ahs987dy210idjhasu98dyapohds
        return new BCryptPasswordEncoder();
    }

    //@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
