package sjh.spring.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.converter.DefaultContentTypeResolver
import org.springframework.messaging.converter.MappingJackson2MessageConverter
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.util.MimeTypeUtils
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig extends WebSocketMessageBrokerConfigurationSupport {


	private static final MESSAGE_PREFIX = '/subscribe';
	
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker(MESSAGE_PREFIX);
        config.setApplicationDestinationPrefixes("/crud")
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/payroll")
				.withSockJS()
				.setAllowedOrigins("*")
    }


   /* @Override
    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {

		
		(0..10).each{
			println "${it} testtesttestteststset ${messageConverters.size()}"
		}

        DefaultContentTypeResolver resolver = new DefaultContentTypeResolver();
        resolver.setDefaultMimeType(MimeTypeUtils.APPLICATION_JSON);
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();

        ObjectMapper objectMapper = new ObjectMapper()
        converter.setObjectMapper(objectMapper);

        println objectMapper
        println converter


        converter.setContentTypeResolver(resolver);
        messageConverters.add(converter);
        return true;
    }
*/

}
