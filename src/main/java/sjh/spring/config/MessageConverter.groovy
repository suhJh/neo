package sjh.spring.config

import org.springframework.boot.autoconfigure.web.HttpMessageConverters
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.GsonHttpMessageConverter

import com.google.gson.Gson
import com.google.gson.GsonBuilder

@Configuration
class MessageConverter {

	
	@Bean
    public HttpMessageConverters customConverters() {
        
		println '★☆★☆★☆★☆GSON MESSAGE CONVERTER INITIALIZED★☆★☆★☆★☆★☆'
		
        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>()
        
		Gson gson = new GsonBuilder()
						.excludeFieldsWithoutExposeAnnotation()
						.setDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
						.create();
		GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter()
		
		gsonHttpMessageConverter.setGson(gson)
		
		
        messageConverters.add(gsonHttpMessageConverter)
        
        return new HttpMessageConverters(true, messageConverters)
    }

	
	
}
