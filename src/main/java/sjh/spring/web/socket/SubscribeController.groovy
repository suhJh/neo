package sjh.spring.web.socket

import org.springframework.messaging.simp.annotation.SubscribeMapping
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody;

import sjh.spring.domain.Message

@Controller
class SubscribeController {

	@SubscribeMapping("/subscribe/messages")
	Message test(Object tt) throws Exception {
		println tt
		Message message = new Message()
		println '111. 여기는 서브스크라이브 콘츄롤러'
		println message
		return message  
	} 
	
	
	@SubscribeMapping("/messages")
	Message test2(Object tt) throws Exception {
		println tt
		Message message = new Message()
		println '222. 여기는 서브스크라이브 콘츄롤러'
		println message
		return message
	}
}
