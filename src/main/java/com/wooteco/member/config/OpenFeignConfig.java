package com.wooteco.member.config;

import static feign.Logger.Level.BASIC;

import feign.Logger;
import feign.Retryer;
import java.util.concurrent.TimeUnit;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.wooteco.member")
public class OpenFeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return BASIC;
    }

    @Bean
    Retryer.Default retryer() {
        // 0.1초의 간격으로 시작해 최대 3초의 간격으로 점점 증가하며, 최대5번 재시도한다.
        return new Retryer.Default(100L, TimeUnit.SECONDS.toMillis(3L), 5);
    }
}
