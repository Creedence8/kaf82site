package ru.kaf82.kaf82site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Класс запуска приложения (Bootstrapper)
 * @author 
 */
@SpringBootApplication
public class MainApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainApplication.class);
    }

    /**
     * Точка входа в программу
     * @param args Аргументы запуска
     */
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}

