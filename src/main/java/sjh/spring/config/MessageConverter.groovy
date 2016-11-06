package sjh.spring.config

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.web.HttpMessageConverters
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.GsonHttpMessageConverter

import com.google.gson.Gson

@Configuration
class MessageConverter {

	
	@Bean
    public HttpMessageConverters customConverters() {
        
		println '★☆★☆★☆★☆GSON MESSAGE CONVERTER INITIALIZED★☆★☆★☆★☆★☆'
		
        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>()
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter()


        messageConverters.add(gsonHttpMessageConverter)
        
        return new HttpMessageConverters(true, messageConverters)
    }

	
	
}
