package wang.liangchen.matrix.iam.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wang.liangchen.matrix.framework.data.annotation.EnableJdbc;
import wang.liangchen.matrix.framework.web.annotation.EnableWeb;

/**
 * @author Liangchen.Wang 2022-07-07 11:10
 */

@SpringBootApplication
@EnableJdbc
@EnableWeb
public class AuthorizationApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.run(args);
    }
}
