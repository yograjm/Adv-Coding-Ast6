package com.clinic.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan(basePackages = "com.clinic.app")
public class ClinicConfig {

    @Bean
    public Clinic clinic() {
        return new Clinic();
    }

    @Bean
    public Patient alice() {
        return new Patient("Alice", 30, "Female", "Fever");
    }

    @Bean
    public Patient bob() {
        return new Patient("Bob", 25, "Male", "Headache");
    }

    @Bean
    public Patient charlie() {
        return new Patient("Charlie", 40, "Male", "Cough");
    }

    @Bean
    public Patient diana() {
        return new Patient("Diana", 35, "Female", "Cold");
    }

    @Bean
    public Patient eva() {
        return new Patient("Eva", 29, "Female", "Stomach Pain");
    }
}
