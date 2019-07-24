package com.skcc.any.lineup.recommend;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.skcc.any.lineup.recommend.domain.model.Recommend;
import com.skcc.any.lineup.recommend.domain.model.ScoreType;
import com.skcc.any.lineup.recommend.domain.repository.RecommendRepository;
import com.skcc.any.lineup.recommend.domain.service.RecommendService;

@SpringBootApplication
@EnableFeignClients
@EnableHypermediaSupport(type=EnableHypermediaSupport.HypermediaType.HAL)
public class RecommendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecommendApplication.class, args);
	}

	@Bean
	public CommandLineRunner execSampleCode(RecommendRepository recommendRepository, @Qualifier("recommendLogic") RecommendService recommendService) {	
		return (args) -> {
		//	insertRecommend(recommendRepository, recommendService);
			displayRecommend(recommendRepository);
		};
	}
/*	
	public void insertRecommend(RecommendRepository recommendRepository, RecommendService recommendService) {
		Recommend recommend1 = new Recommend(1l,"test01","Manri","만리장성",ScoreType.VERYGOOD,"정말 맛있어요");
		if ( recommendService.checkAccount(recommend1.getAccountId()) == null ) {
			System.err.println("There is No user:" + recommend1.getAccountId());
		}
		else {
		recommendRepository.save(recommend1);
		}

		Recommend recommend2 = new Recommend(1l,"test07","Manri","만리장성",ScoreType.VERYGOOD,"정말 맛있어요");
		if ( recommendService.checkAccount(recommend2.getAccountId()) == null ) {
			System.err.println("There is No user:" + recommend2.getAccountId());
		}
		else {
		recommendRepository.save(recommend2);
		}
		
		Iterable<Recommend> recommendList = recommendRepository.findAll();
		System.out.println("***************************************************************");	
		for(Recommend recommend : recommendList) {
			System.out.println(recommend.toString());
		}
		System.out.println("***************************************************************");
	
	}*/

	public void displayRecommend(RecommendRepository recommendRepository) {
		
	}
	
}
