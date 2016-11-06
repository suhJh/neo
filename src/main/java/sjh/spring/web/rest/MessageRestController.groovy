package sjh.spring.web.rest

import org.springframework.http.MediaType
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import sjh.spring.domain.Message
import sjh.spring.repository.MessageRepository
import sjh.spring.service.UserService

import javax.inject.Inject

/**
 * Created by Suh on 2016-11-06.
 */
@RestController
class MessageRestController {


    @Inject
    UserService userService

    @Inject
    MessageRepository messageRepository

    @Inject
    private final SimpMessagingTemplate websocket


    @RequestMapping(value="/api/message/write", method=RequestMethod.POST,  produces = [MediaType.APPLICATION_JSON_VALUE])
    def writeMessage(@RequestBody Message message){
        println message
        messageRepository.save(message)
        websocket.convertAndSend('/subscribe/messages', message)
        def result = [success: message]
        return result
    }




}
