package com.bootcap.session.security.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by jack.
 * 2018-12-06 17:42
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.bootcap.session.security"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    /**
     * 关闭密码加密校验（不推荐）
     */
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
}
