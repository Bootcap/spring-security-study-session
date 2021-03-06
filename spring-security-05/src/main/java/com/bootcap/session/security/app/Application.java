package com.bootcap.session.security.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * create By jack
 * 2018-12-10 11:03
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.bootcap.session.security"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

//    /**
//     * 关闭密码加密校验（不推荐）
//     * @return
//     */
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
}
