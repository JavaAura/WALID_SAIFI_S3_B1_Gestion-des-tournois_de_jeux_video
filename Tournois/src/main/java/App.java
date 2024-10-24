import org.h2.tools.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
public class App {

    @Bean
    public Server h2WebServer() throws Exception {
        Server server = Server.createWebServer();
        server.start();
        return server;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        try {
            Server h2WebServer = context.getBean("h2WebServer", Server.class);
            System.out.println("H2 Console URL: " + h2WebServer.getURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
