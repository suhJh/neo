package sjh.spring.web.socket

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import sjh.spring.domain.Message
import sjh.spring.repository.MessageRepository

import javax.inject.Inject


/**
 * Created by Suh on 2016-11-02.
 */
@Controller
class SocketController {

    @Inject
    MessageRepository messageRepository


    @MessageMapping("/insertMessage")   //소켓으로 insert하는 경우..
    @SendTo("/subscribe/messages")  //-->front에서 맵핑을 해야됨
    def hihi(@RequestBody Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return message
    }

    @MessageMapping("/welcome")
    @SendTo("/subscribe/messages")
    def getInitialList(@RequestBody Message message){
        if(!message || !message.timestamp){
            message = new Message()
        }

        return messageRepository.findTop10ByTimestampBefore(message)
    }

}
