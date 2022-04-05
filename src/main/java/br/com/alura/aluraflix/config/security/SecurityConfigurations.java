package br.com.alura.aluraflix.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{
	
	@Override //configuracoes de autenticacao
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}
	@Override //configuracoes de autorizacao
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/videos/listar").permitAll() // vai permitir o acesso aos get nessa url
								.antMatchers(HttpMethod.GET, "/videos/*").permitAll(); // o * indica que vem alguma coisa depois da barra
		
	}
	@Override //configuracao de recursos estaticos(js, css, imagens, etc.)
	public void configure(WebSecurity web) throws Exception {
		
	}

}
