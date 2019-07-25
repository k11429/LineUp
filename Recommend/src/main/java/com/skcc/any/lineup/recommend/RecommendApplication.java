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
//			insertRecommend(recommendRepository, recommendService);
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

		Recommend recommend2 = new Recommend(2l,"kimcs","Manri","만리장성",ScoreType.VERYGOOD,"정말 맛있어요");
		if ( recommendService.checkAccount(recommend2.getAccountId()) == null ) {
			System.err.println("There is No user:" + recommend2.getAccountId());
		}
		else {
		recommendRepository.save(recommend2);
		}

		Recommend recommend3 = new Recommend(3l,"IU","Nolbu","놀부부대찌개",ScoreType.NORMAL,"그저그래요");
		if ( recommendService.checkAccount(recommend3.getAccountId()) == null ) {
			System.err.println("There is No user:" + recommend3.getAccountId());
		}
		else if (recommendService.checkStore(recommend3.getStoreOwnerAccountId(), recommend3.getStoreName()) == null) {
			System.err.println("There is No Owner+Store:" + recommend3.getStoreOwnerAccountId() +"+"+ recommend3.getStoreName());
		}else {
			recommendRepository.save(recommend3);
		}

		Recommend recommend4 = new Recommend(4l,"IU","Nolbo","놀부부대찌개",ScoreType.NORMAL,"그저그래요");
		if ( recommendService.checkAccount(recommend4.getAccountId()) == null ) {
			System.err.println("There is No user:" + recommend4.getAccountId());
		}
		else if (recommendService.checkStore(recommend4.getStoreOwnerAccountId(), recommend4.getStoreName()) == null) {
			System.err.println("There is No Owner+Store:" + recommend4.getStoreOwnerAccountId() +"+"+ recommend4.getStoreName());
		}else {
			recommendRepository.save(recommend4);
		}

		Recommend recommend5 = new Recommend(5l,"IU","Nolbu","놀부부대찌개",ScoreType.BAD,"맛 별로...");
		if ( recommendService.checkAccount(recommend5.getAccountId()) == null ) {
			System.err.println("There is No user:" + recommend5.getAccountId());
		}
		else if (recommendService.checkStore(recommend5.getStoreOwnerAccountId(), recommend5.getStoreName()) == null) {
			System.err.println("There is No Owner+Store:" + recommend5.getStoreOwnerAccountId() +"+"+ recommend5.getStoreName());
		}else {
			recommendRepository.save(recommend5);
		}
		
		
		Iterable<Recommend> recommendList = recommendRepository.findAll();
		System.out.println("***************************************************************");	
		for(Recommend recommend : recommendList) {
			System.out.println(recommend.toString());
		}
		System.out.println("***************************************************************");
	
	}
*/
	
}
