package sict.edu.mn.lab12.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import sict.edu.mn.lab12.service.UserService;
import sict.edu.mn.lab12.model.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private UserService userService;

	@Autowired
	private JwtAuthenticationFilter jwtRequestFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.cors(cors -> cors.configurationSource(request -> {
					CorsConfiguration config = new CorsConfiguration();
					config.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
					config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
					config.setAllowedHeaders(Arrays.asList("*"));
					return config;
				}))
				.csrf(csrf -> csrf.disable())
				.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
				.anonymous(anonymous -> anonymous.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/api/register", "/api/login").permitAll()
						.requestMatchers("/h2-console/**").permitAll()
						.anyRequest().authenticated())
				.exceptionHandling(ex -> ex
						.authenticationEntryPoint((request, response, authException) -> {
							response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
							response.setContentType("application/json");
							response.getWriter().write("{\"error\": \"Unauthorized. JWT token is required.\"}");
						}))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return username -> {
			User user = userService.findByUsername(username);
			if (user == null)
				throw new UsernameNotFoundException("User not found");
			return org.springframework.security.core.userdetails.User
					.withUsername(user.getUsername())
					.password(user.getPassword())
					.roles(user.getRole())
					.build();
		};
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
}