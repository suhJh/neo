package sjh.spring.web.socket

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import sjh.spring.web.socket.dto.Greeting
import sjh.spring.web.socket.dto.HelloMessage

/**
 * Created by Suh on 2016-11-02.
 */
@Controller
class SocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

}
