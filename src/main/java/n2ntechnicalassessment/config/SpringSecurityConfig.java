package n2ntechnicalassessment.config;

import org.springframework.context.annotation.Configuration;

//@EnableWebSecurity
@Configuration
public class SpringSecurityConfig {


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/authenticate").permitAll() // Allow everyone to access the authentication endpoint
//                .anyRequest().authenticated() // All other requests need to be authenticated
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Use stateless session; session won't be used to store user's state.
//
//        // Add a filter to validate the tokens with every request
//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//    }

}
