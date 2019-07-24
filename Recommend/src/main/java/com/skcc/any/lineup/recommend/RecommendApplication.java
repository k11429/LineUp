package com.skcc.any.lineup.recommend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.skcc.any.lineup.recommend.domain.repository.RecommendRepository;


@SpringBootApplication
@EnableFeignClients
@EnableHypermediaSupport(type=EnableHypermediaSupport.HypermediaType.HAL)
public class RecommendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecommendApplication.class, args);
	}

	@Bean
	public CommandLineRunner execSampleCode(RecommendRepository recommendRepository) {	
		return (args) -> {
			insertRecommend(recommendRepository);
			displayRecommend(recommendRepository);
		};
	}
	
	public void insertRecommend(RecommendRepository recommendRepository) {
		
	}

	public void displayRecommend(RecommendRepository recommendRepository) {
		
	}
	
}
