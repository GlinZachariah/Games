package com.glinzac.games;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GamesApplication {

	@Bean
	public GameService getGameService(){
		return new GameService();
	}

	public static void main(String[] args) {
		SpringApplication.run(GamesApplication.class, args);
	}

}
