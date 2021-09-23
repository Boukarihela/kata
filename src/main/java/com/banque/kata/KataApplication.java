package com.banque.kata;

import com.banque.kata.Dao.ClientDao;
import com.banque.kata.Entities.Client;
import com.banque.kata.Entities.Historique;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;

@SpringBootApplication
@EnableJpaRepositories("com.banque.kata.Dao")
public class KataApplication {

	public static void main(String[] args) {
		SpringApplication.run(KataApplication.class, args);
	}

	@Bean
	public CommandLineRunner clientDemo(ClientDao clientDao) {
		return (args) -> {
			//creation de clients
			clientDao.save(new Client(1L,"hela","boukari",  120.0));
		};
	}
}
