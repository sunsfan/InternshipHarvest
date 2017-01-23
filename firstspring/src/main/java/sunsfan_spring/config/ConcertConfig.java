package sunsfan_spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import sunsfan_spring.aspect.Audience;
import sunsfan_spring.aspect.EncoreableIntroducer;
import sunsfan_spring.dao.Encoreable;
import sunsfan_spring.dao.Performance;
import sunsfan_spring.daoImpl.DefaultEncoreable;
import sunsfan_spring.daoImpl.PerformanceImpl;

@Configuration
@EnableAspectJAutoProxy
// @ComponentScan
public class ConcertConfig {

	@Bean
	public Audience audience() {
		return new Audience();
	}

	@Bean
	public Performance performance() {
		return new PerformanceImpl();
	}

	@Bean
	public EncoreableIntroducer introducer() {
		return new EncoreableIntroducer();
	}

	@Bean
	public Encoreable encoreable() {
		return new DefaultEncoreable();
	}
}
