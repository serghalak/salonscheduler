package com.salon;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@SpringBootApplication
public class SalonSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalonSchedulerApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
//		mapper.getConfiguration()
//				.setMatchingStrategy(MatchingStrategies.STRICT)
//				.setFieldMatchingEnabled(true)
//				.setSkipNullEnabled(true)
//				.setFieldAccessLevel(PRIVATE);
		return mapper;
	}
}
