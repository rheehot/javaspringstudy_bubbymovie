package moviebuddy.domain.data;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import moviebuddy.MovieBuddyFactory;
import moviebuddy.MovieBuddyProfile;
import moviebuddy.data.JaxbMovieReader;
import moviebuddy.domain.Movie;
@ActiveProfiles(MovieBuddyProfile.XML_MODE)
@SpringJUnitConfig(MovieBuddyFactory.class)
public class JaxbMovieReaderTest {
	
//	public static void main(String[] args) {
//		JaxbMovieReader movieReader = new JaxbMovieReader();
//		
//		List <Movie> movies = movieReader.loadMovies();
//		MovieFinderTest.assertEquals(1375, movies.size());
//	}
	
	@Autowired JaxbMovieReader movieReader;

	@Test
	void NotEmpty_LoadedMovies() {
//		JaxbMovieReader movieReader = new JaxbMovieReader();
		
		List<Movie> movies = movieReader.loadMovies();
		Assertions.assertEquals(1375, movies.size());
	}
}
