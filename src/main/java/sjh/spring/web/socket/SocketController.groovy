package sjh.spring.web.socket

import org.springframework.context.annotation.Bean
import org.springframework.messaging.converter.ByteArrayMessageConverter
import org.springframework.messaging.converter.CompositeMessageConverter
import org.springframework.messaging.converter.DefaultContentTypeResolver
import org.springframework.messaging.converter.MappingJackson2MessageConverter
import org.springframework.messaging.converter.MessageConverter
import org.springframework.messaging.converter.StringMessageConverter
import org.springframework.messaging.simp.config.AbstractMessageBrokerConfiguration
import org.springframework.util.MimeTypeUtils

import javax.inject.Inject
import org.springframework.util.ClassUtils
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController

import com.google.common.collect.Lists

import sjh.spring.domain.Message
import sjh.spring.repository.MessageRepository

/**
 * Created by Suh on 2016-11-02.
 */
@RestController
class SocketController {

    @Inject
    MessageRepository messageRepository


    @MessageMapping("/insertMessage")   //소켓으로 insert하는 경우..
    @SendTo("/subscribe/messages")  //-->front에서 맵핑을 해야됨
    Message hihi(@RequestBody Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        println message
        return message
    }


	
}
