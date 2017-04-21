package ru.kaf82.kaf82site.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Настройки безопасности
 * @author 
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Метод конфигурации. Применена "по умолчанию", то есть доступно всё за корнем "/"
     * @param httpSecurity Конфигурация
     * @throws Exception Из методов httpSecurity
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/").permitAll();
    }
}
