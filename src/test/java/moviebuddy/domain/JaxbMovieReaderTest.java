package moviebuddy.domain;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JaxbMovieReaderTest {
	
//	public static void main(String[] args) {
//		JaxbMovieReader movieReader = new JaxbMovieReader();
//		
//		List <Movie> movies = movieReader.loadMovies();
//		MovieFinderTest.assertEquals(1375, movies.size());
//	}

	@Test
	void NotEmpty_LoadedMovies() {
		JaxbMovieReader movieReader = new JaxbMovieReader();
		
		List<Movie> movies = movieReader.loadMovies();
		Assertions.assertEquals(1375, movies.size());
	}
}
