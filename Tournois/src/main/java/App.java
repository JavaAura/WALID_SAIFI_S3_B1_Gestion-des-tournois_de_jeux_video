import java.util.logging.Logger;
import org.h2.tools.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Server h2WebServer = context.getBean("h2WebServer", Server.class);
        String h2ConsoleUrl = h2WebServer.getURL();

        System.out.println("H2 Console URL: " + h2ConsoleUrl);

        logger.info("H2 Console URL: " + h2ConsoleUrl);
    }
}
