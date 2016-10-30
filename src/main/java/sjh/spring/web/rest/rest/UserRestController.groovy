package sjh.spring.web.rest.rest

import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sjh.spring.domain.User
import sjh.spring.service.UserService

import javax.inject.Inject
import javax.transaction.Transactional

/**
 * Created by Suh on 2016-10-30.
 */
@RestController
class UserRestController {

    @Inject
    UserService userService

    @RequestMapping(value="/api/users")
    @Transactional
    //def getUsers(@Param(value = "seq") Long seq) {
    def getUsers(@Param(value = 'seq') Long seq) {
        def targetUser = userService.findOneBySeq(seq).get()

        println targetUser

        if(targetUser)  return targetUser

        return new User(name: '없습니당')
    }

}
