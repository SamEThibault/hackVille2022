package ca.sheridancollege.consmatt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
	
		http
		.authorizeRequests()
		.antMatchers("/displayTasks").hasAnyRole("ADMIN", "USER")
		.antMatchers("/addTasks").hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.POST, "/addTask").permitAll()
		.antMatchers("/signUp").permitAll() 
		.antMatchers("/registerUser").permitAll() //Get Request
		.antMatchers(HttpMethod.POST, "/registerUser").permitAll() //Post Request
		.antMatchers("/").hasAnyRole("ADMIN", "USER")
		.antMatchers("/h2-console/**").permitAll()
		.anyRequest().authenticated()
	.and()
		//Define Custom login
		.formLogin()
			.loginPage("/login")//URL defined in the SecurityController
			.permitAll()
	.and()
			.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login")
			.permitAll()
	.and()
			.exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler);
			
	}
	@Bean
    public static BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

}
