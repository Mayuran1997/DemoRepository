package com.demo.SpringSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AppSeccurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authenticate() {
		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests().antMatchers("/login").permitAll() //whenever login is called allow all
			.anyRequest().authenticated()//any req has to be authenticated
			.and()
			.formLogin() //for our own form we need formlogin
			.loginPage("/login").permitAll()//which is the page u want to display as login page and allows all  to see this page
			.and()
			.logout().invalidateHttpSession(true) //logout functionality and make the session invalid after logout
			.clearAuthentication(true)  //clear all the authentication
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //for which url u want to logout
			.logoutSuccessUrl("/logout-success").permitAll(); //after logged out successfully which url or page to show 
	}

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	
	}*/
	
	
	
	/*@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		List<UserDetails> users= new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("Mayur").password("Mayuran12").roles("USER").build());
		return new InMemoryUserDetailsManager(users);
	}*/

	
	
}
