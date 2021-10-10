package moviebuddy.domain;

import java.io.PrintWriter;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import moviebuddy.MovieBuddyFactory;

/**
 * @author springrunner.kr@gmail.com
 */
@SpringJUnitConfig(MovieBuddyFactory.class) // 아래 2줄 삭제 
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = MovieBuddyFactory.class)
public class MovieFinderTest {

//	MovieBuddyApplication application = new MovieBuddyApplication();

//	final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MovieBuddyFactory.class);
	final MovieBuddyFactory movieBuddyFactory = new MovieBuddyFactory();		
//	final MovieFinder movieFinder = movieBuddyFactory.movieFinder();
//	final MovieFinder movieFinder = applicationContext.getBean(MovieFinder.class);
//	MovieFinder movieFinder;
	//field level 
	@Autowired MovieFinder movieFinder;
	
	//생성자 생성 방법 
//	@Autowired
//	public MovieFinderTest(MovieFinder movieFinder) {
//		this.movieFinder = movieFinder;
//	}

	//set level 
//	@Autowired
//	void SetMovieFinder(MovieFinder movieFinder) {
//		this.movieFinder = movieFinder;
//	}
	
	final PrintWriter output = new PrintWriter(System.out, false);
	
	@Test
	void NotEmpty_directedBy() {
		List<Movie> result = movieFinder.directedBy("Michael Bay");
		Assertions.assertEquals(3, result.size());
	}
	
	@Test
	void NotEmpty_ReleasedYearBy() {
		List<Movie> result = movieFinder.releasedYearBy(2015);
		Assertions.assertEquals(225, result.size());
	}
	
//	public static void main(String[] args) {
//	
//		List<Movie> result = movieFinder.directedBy("Michael Bay");
//		assertEquals(3, result.size());
//
//        result = movieFinder.releasedYearBy(2015);
//        assertEquals(225, result.size());
//	}
//	
//	static void assertEquals(long expected, long actual) {
//		if (expected != actual) {
//			throw new RuntimeException(String.format("actual(%d) is different from the expected(%d)", actual, expected));			
//		}
//	}
	
}
