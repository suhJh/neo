package sjh.spring.web

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import sjh.spring.repository.UserRepository

import javax.inject.Inject
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

/**
 * server-side entry point
 * http://localhost:8080
 *
 */
@Controller
class IndexController {

    final Logger log = LoggerFactory.getLogger(this.class);

    @Inject
    UserRepository userRepository

    /**
     *  Route와 일치시켜야만 한다.
     * */
    @RequestMapping(["/", "/c8", "/nimi"])
    def index(HttpServletRequest req, HttpSession session){
        log.info("${req.remoteAddr}에서 홈페이지에 접속하였습니다.")
		session.setAttribute("login", userRepository.findOne(Long.valueOf("1")))

        return 'index'
    }



}
