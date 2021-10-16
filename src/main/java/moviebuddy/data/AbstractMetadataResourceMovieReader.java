package moviebuddy.data;

import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import moviebuddy.ApplicationException;
import moviebuddy.domain.MovieReader;

public abstract class AbstractMetadataResourceMovieReader implements ResourceLoaderAware {

	private final Logger log = org.slf4j.LoggerFactory.getLogger(getClass());
	private String metadata;
	private ResourceLoader resourceLoader;
	
//	public AbstractFileSystemMovieReader() {
//		super();
//	}

	public String getMetadata() {
		return metadata;
	}
	
	@Value("${movie.metadata}")
	public void setMetadata(String metadata) {
			
	//		this.metadata = Objects.requireNonNull(metadata,"metadata is required value");
			this.metadata = metadata;
		}

	public URL getMetadataUrl() {
		String location = getMetadata();
		
		if(location.startsWith("file")) {
			// file URL 처리
		}
		else if (location.startsWith("http:")){
			// http URL 처리 
		}
		return ClassLoader.getSystemResource(location);
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		// TODO Auto-generated method stub
		this.resourceLoader = resourceLoader;
	}
	
	public Resource getMetadataResource() {
		return resourceLoader.getResource(getMetadata());
	}

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		
		
		Resource resource = getMetadataResource();
		if (resource.exists() == false) {
			throw new FileNotFoundException(metadata);
		}
		
		if (resource.isReadable() == false) {
			throw new ApplicationException(String.format("can not read to metadata. [%s]",metadata));
		}
		
		log.info(resource + "is ready.");
		
//		URL metadataUrl = getMetadataUrl();
		
//		if (Objects.isNull(metadataUrl)) {
//			throw new FileNotFoundException(metadata);
//		}
//		if (Files.isReadable(Path.of(metadataUrl.toURI())) == false) {
//			throw new ApplicationException(String.format("can not read to metadata. [%s]",metadata));
//		}
	}

	@PreDestroy
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		log.info("Destroyed bean");
		
	}

}