package sjh.spring.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
import org.springframework.boot.context.embedded.MimeMappings
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

import javax.inject.Inject
import javax.servlet.DispatcherType
import javax.servlet.ServletContext
import javax.servlet.ServletException
import javax.servlet.ServletRegistration
import java.nio.file.Paths

/**
 * 정적 자원 할당 및 기타 설정
 */
@Configuration
class WebConfigurer implements ServletContextInitializer, EmbeddedServletContainerCustomizer {


    private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

    @Inject
    private Environment env;

    /**
     * Mime 타입을 설정하고 정적자원 경로 설정
     */
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT)

        mappings.with {
            add("html", "text/html;charset=utf-8")
            add("json", "text/html;charset=utf-8")
        }
        container.setMimeMappings(mappings)

        //  디폴트가 아닌 설정한 정적자원 주소로 맵핑함.
        setLocationForStaticAssets(container);
		println '★☆★☆★☆★☆STATIC ASSETS SETUP★☆★☆★☆★☆★☆'
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        if (env.getActiveProfiles().length != 0) {
            log.info("${Arrays.toString(env.getActiveProfiles())} 프로퍼티 파일에 따라 웹환경을 설정합니다.")
        }
        EnumSet<DispatcherType> disps = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC)
        //  initMetrics(servletContext, disps)
        if (env.acceptsProfiles(DefaultProfileUtil.SPRING_PROFILE_PRODUCTION)) {
            initCachingHttpHeadersFilter(servletContext, disps)
        }
        if (env.acceptsProfiles(DefaultProfileUtil.SPRING_PROFILE_DEVELOPMENT)) {
            initH2Console(servletContext)
        }
		println '★☆★☆★☆★☆WEB ENV SETUP COMPLETED★☆★☆★☆★☆★☆'
    }


    /**
     *  상대경로의 정적 자원들 연결 주소 설정
     *  dev와 prod 경로 다름
     * */
    private void setLocationForStaticAssets(ConfigurableEmbeddedServletContainer container) {
        File root;
        String prefixPath = resolvePathPrefix();
        if (env.acceptsProfiles(DefaultProfileUtil.SPRING_PROFILE_PRODUCTION)) {
            root = new File("${prefixPath}target/www/")
        } else {
            root = new File("${prefixPath}src/main/webapp/")
        }
        if (root.exists() && root.isDirectory()) {
            container.setDocumentRoot(root)
        } else {
            log.error("정적자원의 주소가 설정되지 않았습니다. : ${root}")
        }
    }


    /**
     *  상대 경로 계산
     * */
    private String resolvePathPrefix() {
        String fullExecutablePath = this.getClass().getResource("").getPath()
        String rootPath = Paths.get(".").toUri().normalize().getPath()
        String extractedPath = fullExecutablePath.replace(rootPath, "")

        int extractionEndIndex = extractedPath.indexOf("target/")
        if(extractionEndIndex <= 0) {
            return ""
        }
        return extractedPath.substring(0, extractionEndIndex)
    }




    /**
     * TODO: 헤더설정을 위한 필터 나중에 공부해서 넣을 것
     */
    private void initCachingHttpHeadersFilter(ServletContext servletContext,
                                              EnumSet<DispatcherType> disps) {
    }

    /**
     * in-memory h2 database 서블릿에 추가
     */
    private void initH2Console(ServletContext servletContext) {
        log.debug("H2 콘솔 초기화 시작");
        ServletRegistration.Dynamic h2ConsoleServlet = servletContext.addServlet("H2Console", new org.h2.server.web.WebServlet());
        h2ConsoleServlet.addMapping("/h2-console/*");
        //h2ConsoleServlet.setInitParameter("-properties", "src/main/resources/");
        h2ConsoleServlet.setLoadOnStartup(1);
        log.info("H2 콘솔 이 /h2-console/ 에 맵핑되었습니다.")
    }

}
