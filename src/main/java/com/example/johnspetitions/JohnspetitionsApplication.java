package com.example.johnspetitions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JohnspetitionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JohnspetitionsApplication.class, args);
	}

	@Bean
	public CommandLineRunner preloadPetitions(PetitionService petitionService){
		return args ->{
			petitionService.addPetition(new Petition(
					"Skatepark for Lahinch",
						"Build a skatepark in Lahinch, much needed service for children and young adults",
					"We are aiming to get enough signatures to encourage the council to invest in a much needed " +
							"public amenity for the young people of north Clare. Given it is one of Ireland's go to surf destinations " +
							"we believe the appetite is there and that it would provide a much needed resource for young people who may not find " +
							"their place in team sports. It provides a public service for children, young adults and adults with arrested development :) to get exercise and socialise actively. " +
							"With skateboarding now an Olympic sport we think it's high time for the government to step up and build a public skatepark like other towns across Ireland and around the world have done.",
					"Tom Penny",
					true
			));
			petitionService.addPetition(new Petition(
					"Public changing facilities for Rosnowlagh Beach",
					"Build a public changing room for Rosnowlagh Beach",
					"We would like to gauge interest for the building of public changing facilities and bathrooms at Rosnowlagh beach." +
							"Ireland really lags behind our European and international neighbours in terms of facilties on our coast especially given" +
							"we have some of the best beaches in the world. Given our climate and the recent interest in cold water swimming we think" +
							" it's time we have basic facilities such as public toilets and changing facilities available at this very popular beach." +
							"We'd like to get enough signatures to show the council that there is a public interest for the project so we can proceed to the " +
							"next stage of planning. " ,
					"John Stack",
					true
			));
		};
	}
	
}
