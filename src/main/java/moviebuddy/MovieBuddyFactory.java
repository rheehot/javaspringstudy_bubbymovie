package moviebuddy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import moviebuddy.domain.CsvMovieReader;
import moviebuddy.domain.MovieFinder;
import moviebuddy.domain.MovieReader;

@Configuration
public class MovieBuddyFactory {

	@Bean
	public MovieReader movieReader() {

		return new CsvMovieReader();
	}
	
//	@Bean
//	public MovieFinder movieFinder() {
////		return new MovieFinder(new CsvMovieReader());
//		return new MovieFinder(movieReader());
//	}

	@Bean
//	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//	@Scope("prototype")
	public MovieFinder movieFinder(MovieReader movieReader) {
//		return new MovieFinder(new CsvMovieReader());
		return new MovieFinder(movieReader());
	}

}
