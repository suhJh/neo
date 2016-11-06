package sjh.spring.web.rest

import org.springframework.http.MediaType
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import sjh.spring.domain.Message
import sjh.spring.domain.User
import sjh.spring.repository.MessageRepository
import sjh.spring.service.UserService

import javax.inject.Inject
import javax.servlet.http.HttpServletRequest

/**
 * Created by Suh on 2016-10-30.
 */
@RestController
class UserRestController {

    @Inject
    UserService userService

	@Inject
	MessageRepository messageRepository

	@Inject
	private final SimpMessagingTemplate websocket;



    @RequestMapping(
		value="/api/users", 
		method = RequestMethod.POST,
		produces = [MediaType.APPLICATION_JSON_VALUE]
	)
    def getUsers(@RequestBody User user, HttpServletRequest req) {
		
		println user
		
		try{
			def targetUser = userService.findOneBySeq(user.seq).get()
			println targetUser
			if(targetUser)  return targetUser
			
		}catch(e){
			println e
		}

		return 'c8'
    }

}
