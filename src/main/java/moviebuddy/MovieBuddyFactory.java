package moviebuddy;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import moviebuddy.data.AbstractFileSystemMovieReader;
import moviebuddy.data.CsvMovieReader;
import moviebuddy.data.XmlMovieReader;
import moviebuddy.domain.MovieFinder;
import moviebuddy.domain.MovieReader;

@Configuration
@PropertySource("/application.properties")
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
		
//		private final Environment environment;
//		
//		@Autowired
//		public DataSourceModuleConfig(Environment environment) {
//			this.environment = environment;
//		}
//
//		@Profile(MovieBuddyProfile.CSV_MODE)
//		@Bean
//		public CsvMovieReader csvMovieReader() {
//			CsvMovieReader movieReader = new CsvMovieReader();
//			
//			//어플리케이션 외부에서 작성된 설정정보를 읽어, 메타데이터 위치 설정하기
////			movieReader.setMetadata(environment.getProperty("movie.metadata"));
//			
//			return movieReader;
//		}		
//		
//		@Profile(MovieBuddyProfile.XML_MODE)
//		@Bean
//		public XmlMovieReader xmlMovieReader(Unmarshaller unmarshaller) {
//			XmlMovieReader movieReader = new XmlMovieReader(unmarshaller);
//
//			//어플리케이션 외부에서 작성된 설정정보를 읽어, 메타데이터 위치 설정하기
////			movieReader.setMetadata(environment.getProperty("movie.metadata"));
//						
//			return movieReader;
//			
//		}
	}

}
