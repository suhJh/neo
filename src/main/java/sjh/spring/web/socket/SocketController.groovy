package sjh.spring.web.socket

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody;

import sjh.spring.web.socket.dto.Greeting
import sjh.spring.web.socket.dto.HelloMessage

/**
 * Created by Suh on 2016-11-02.
 */
@Controller
class SocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    Greeting greeting(@RequestBody HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
		println message.name
        return new Greeting("Hello, " + message.getName() + "!");
    }

}
