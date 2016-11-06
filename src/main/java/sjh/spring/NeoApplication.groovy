package sjh.spring

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.thymeleaf.TemplateRepository;

import sjh.spring.config.DefaultProfileUtil
import sjh.spring.domain.Message
import sjh.spring.domain.User
import sjh.spring.repository.MessageRepository
import sjh.spring.repository.UserRepository

import javax.annotation.PostConstruct
import javax.inject.Inject
import javax.transaction.Transactional

/**
 * 최초 시작점
 */
@SpringBootApplication
class NeoApplication {

    /*
    스프링 부트의 프라퍼티 로딩 순서
    1. Command line arguments.
    2. JNDI attributes from java:comp/env.
    3. Java System properties (System.getProperties()).
    4. OS environment variables.
    5. A RandomValuePropertySource that only has properties in random.*.
    6. Profile-specific application properties outside of your packaged jar (application-{profile}.properties and YAML variants)
    7. Profile-specific application properties packaged inside your jar (application-{profile}.properties and YAML variants)
    8. Application properties outside of your packaged jar (application.properties and YAML variants).
    9. Application properties packaged inside your jar (application.properties and YAML variants).
    10. @PropertySource annotations on your @Configuration classes.
    11. Default properties (specified using SpringApplication.setDefaultProperties).
     */

    static final Logger log = LoggerFactory.getLogger(NeoApplication.class);

    @Inject
    Environment env
	

    static main(args) {

        SpringApplication app = new SpringApplication(NeoApplication.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        log.info(
        """
        ----------------------------------------------------------
            '${env.getProperty("spring.application.name")}' 가 시작되었습니다. Access URLs:
            Local: http://127.0.0.1:${env.getProperty("server.port")}
            External: http://${InetAddress.getLocalHost().getHostAddress()}:${env.getProperty("server.port")}
        ----------------------------------------------------------
        """)
    }



    @PostConstruct
    initApplication() {
		
        log.info("프로퍼티모드 : ${Arrays.toString(env.getActiveProfiles())}")
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles())
        if (activeProfiles.contains(DefaultProfileUtil.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(DefaultProfileUtil.SPRING_PROFILE_PRODUCTION)) {
            log.error("개발과 배포용 환경이 동시에 설정될 수 없습니다.")
        }
    }

	

    @Transactional
    @Bean
    CommandLineRunner init(UserRepository userRepository, MessageRepository msgRepository) {
        return {
			
            PasswordEncoder p = new BCryptPasswordEncoder();

            userRepository.save(new User(name:'서종효', password: p.encode('이건암호화되어야'), email: 'pk1@naver.com'))
            userRepository.save(new User(name:'김장군', password: p.encode('이건암호화되어야'), email: 'pk2@naver.com'))
            userRepository.save(new User(name:'하양이', password: p.encode('이건암호화되어야'), email: 'pk3@naver.com'))
            userRepository.save(new User(name:'까망이', password: p.encode('이건암호화되어야'), email: 'pk4@naver.com'))

            userRepository.findAll().each {
                println it
            }

            msgRepository.save(new Message(sender: new User(seq: 1), message: '이건 첫번째 메시지'))
            msgRepository.save(new Message(sender: new User(seq: 2), message: '이건 두번째 메시지'))
            msgRepository.save(new Message(sender: new User(seq: 3), message: '이건 세번째 메시지'))
            msgRepository.save(new Message(sender: new User(seq: 1), message: '이건 네번째 메시지'))
            msgRepository.save(new Message(sender: new User(seq: 1), message: '이건 다섯번째 메시지'))

            msgRepository.findAll().each {
                println it
            }


            msgRepository.findBySender(new User(seq: 1)).each {
                println it
            }



        }
    }



}
