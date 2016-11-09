package sjh.spring.web.socket

import javax.inject.Inject

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
    def hihi(@RequestBody Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return message
    }

    @MessageMapping("/welcome")
    @SendTo("/subscribe/messages")
    def getInitialList(@RequestBody Message message){
        println message
        if(!message && !message.timestamp){
            message = new Message()
        }

		println "${message.timestamp} 이전 시간의 데이터 10개를 빼오겠습니다."
		
		//PageRequet pageRequest = new PageRequest(0, 10, new Sort(Direction.DESC, " username")); //현재페이지, 조회할 페이지수, 정렬정보
		
        //return messageRepository.findTop10ByTimestampBeforeOrderByTimestampDesc(message.timestamp, new PageRequest(1, 5))
					
		return messageRepository.findAll(new PageRequest(1, 5, new Sort(new Order("message", false), new Order("seq", true))))
    }

	@RequestMapping(value="/test")
	def test(){
		
		def somthing = 'ddd'; 
		
		return somthing;
	}
	
}
