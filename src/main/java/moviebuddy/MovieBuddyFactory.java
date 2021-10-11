package moviebuddy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import moviebuddy.data.CsvMovieReader;
import moviebuddy.data.XmlbMovieReader;
import moviebuddy.domain.MovieFinder;
import moviebuddy.domain.MovieReader;

@Configuration
@ComponentScan(basePackages = "moviebuddy")
@Import({MovieBuddyFactory.DomainModuleConfig.class, MovieBuddyFactory.DataSourceModuleConfig.class})
public class MovieBuddyFactory {

	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("moviebuddy");
		
		return marshaller;
	}
	
	@Configuration
	static class DomainModuleConfig {	
		
//		@Bean
////		@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
////		@Scope("prototype")
//		public MovieFinder movieFinder(MovieReader movieReader) {
//			return new MovieFinder(movieReader);
//		}		
	}
	
	@Configuration
	static class DataSourceModuleConfig {

//		@Bean
//		public MovieReader movieReader() {
//			return new CsvMovieReader();
//		}		
	}

}
