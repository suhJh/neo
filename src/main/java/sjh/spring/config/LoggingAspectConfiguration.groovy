package sjh.spring.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.context.annotation.Profile
import sjh.spring.aop.LoggingAspect

/**
 * dev 모드인 경우 aop 기반 로깅을 적용한다.
 */
@Configuration
@EnableAspectJAutoProxy
class LoggingAspectConfiguration {

    @Bean
    @Profile(DefaultProfileUtil.SPRING_PROFILE_DEVELOPMENT)
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

}
