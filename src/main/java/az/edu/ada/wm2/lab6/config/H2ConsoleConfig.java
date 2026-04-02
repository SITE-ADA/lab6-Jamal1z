package az.edu.ada.wm2.lab6.config;

import jakarta.servlet.Servlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ConsoleConfig {

    @Bean
    public ServletRegistrationBean<Servlet> h2ConsoleServletRegistration() {
        try {
            Class<?> servletClass = Class.forName("org.h2.server.web.JakartaWebServlet");
            Servlet servlet = (Servlet) servletClass.getDeclaredConstructor().newInstance();

            ServletRegistrationBean<Servlet> registration =
                    new ServletRegistrationBean<>(servlet, "/h2-console", "/h2-console/*");
            registration.setLoadOnStartup(1);
            return registration;
        } catch (Exception ex) {
            throw new IllegalStateException("Failed to register H2 console servlet", ex);
        }
    }
}
