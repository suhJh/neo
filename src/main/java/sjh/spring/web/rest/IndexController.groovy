package sjh.spring.web.rest

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

import javax.servlet.http.HttpServletRequest


/**
 * server-side entry point
 * http://localhost:8080
 *
 */
@Controller
class IndexController {

    final Logger log = LoggerFactory.getLogger(this.class);

    @RequestMapping(value='/')
    def index(HttpServletRequest req){
        log.info("${req.remoteAddr}에서 홈페이지에 접속하였습니다.")
        'index'
    }



}
