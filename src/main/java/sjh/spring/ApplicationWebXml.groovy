package sjh.spring

import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer
import sjh.spring.config.DefaultProfileUtil

/**
 * 프로파일을 설정하지 않은 경우 기본값으로 설정시킨다.
 */
class ApplicationWebXml extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        DefaultProfileUtil.addDefaultProfile(application.application());
        return application.sources(NeoApplication.class);
    }
}
