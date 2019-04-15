package br.feevale.bolao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Running... To update the database run http://localhost:8080/classification/update");
    }

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/_ah/health")
    public String healthy() {
        // Message body required though ignored
        return "Still surviving.";
    }

//    @Bean
//    public ConfigurableServletWebServerFactory webServerFactory() {
//        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
//        factory.setPort(8080);
//        factory.setContextPath("");
//        return factory;
//    }

}
