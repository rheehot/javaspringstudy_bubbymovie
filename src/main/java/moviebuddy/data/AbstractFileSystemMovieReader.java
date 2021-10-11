package moviebuddy.data;

import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;

import moviebuddy.ApplicationException;
import moviebuddy.domain.MovieReader;

public abstract class AbstractFileSystemMovieReader {

	private final Logger log = org.slf4j.LoggerFactory.getLogger(getClass());
	private String metadata;

//	public AbstractFileSystemMovieReader() {
//		super();
//	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
			
	//		this.metadata = Objects.requireNonNull(metadata,"metadata is required value");
			this.metadata = metadata;
		}

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		URL metadataUrl = ClassLoader.getSystemResource(metadata);
		
		if (Objects.isNull(metadataUrl)) {
			throw new FileNotFoundException(metadata);
		}
		if (Files.isReadable(Path.of(metadataUrl.toURI())) == false) {
			throw new ApplicationException(String.format("can not read to metadata. [%s]",metadata));
		}
	}

	@PreDestroy
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		log.info("Destroyed bean");
		
	}

}