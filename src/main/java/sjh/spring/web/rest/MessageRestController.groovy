package sjh.spring.web.rest

import com.google.gson.Gson
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.MediaType
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import sjh.spring.domain.Message
import sjh.spring.domain.User
import sjh.spring.repository.MessageRepository
import sjh.spring.repository.UserRepository
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
    UserRepository userRepository

    @Inject
    private final SimpMessagingTemplate websocket


    @RequestMapping("/api/message/getPreviousChatsByTimestamp")
    def getInitialList(@RequestBody Message message){
        println message
        if(!message && !message.timestamp){
            message = new Message()
        }

        println "${message.timestamp} 이전 시간의 데이터 10개를 빼오겠습니다."

        //PageRequet pageRequest = new PageRequest(0, 10, new Sort(Direction.DESC, " username")); //현재페이지, 조회할 페이지수, 정렬정보
        //return messageRepository.findTop10ByTimestampBeforeOrderByTimestampDesc(message.timestamp, new PageRequest(1, 5))

        return messageRepository.findByTimestampBefore(new Date(), new PageRequest(0, 10, new Sort(Sort.Direction.DESC, "timestamp")))
    }



    @RequestMapping(value="/api/message/write", method=RequestMethod.POST,  produces = [MediaType.APPLICATION_JSON_VALUE])
    void writeMessage(@RequestBody Message message){
        println "MessageRestController가 받은 메시지 : ${message}"

        message = messageRepository.save(message)
        message.sender = userRepository.findOne(message.sender.seq)

        println "웹소켓으로 쏜다~: " + message

        websocket.convertAndSend('/subscribe/messages', message)
        //websocket.convertAndSend('/subscribe/messages', message)
    }





}
