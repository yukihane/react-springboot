package com.packt.cardatabase;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
@SpringBootApplication
public class CardatabaseApplication {

    private final CarRepository repository;

    public static void main(final String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            // Save demo data to database
            repository.save(new Car("Ford", "Mustang", "Red",
                "ADF-1121", 2017, 59000));
            repository.save(new Car("Nissan", "Leaf", "White",
                "SSJ-3002", 2014, 29000));
            repository.save(new Car("Toyota", "Prius", "Silver",
                "KKO-0212", 2018, 39000));
        };
    }
}
