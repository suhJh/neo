package sjh.spring.web.rest

import javax.inject.Inject
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional

import org.springframework.http.MediaType
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import sjh.spring.domain.User
import sjh.spring.service.UserService

/**
 * Created by Suh on 2016-10-30.
 */
@RestController
class UserRestController {

    @Inject
    UserService userService

    @RequestMapping(
		value="/api/users", 
		method = RequestMethod.POST,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
    @Transactional
    def getUsers(@RequestBody User user, HttpServletRequest req) {
		
		try{
			
			def targetUser = userService.findOneBySeq(user.seq).get()
			 
			println targetUser
			if(targetUser)  return targetUser
			
		}catch(e){
			println e
		}

        return new User(name: '없습니당')
    }

}
