package com.exampleredis.demoredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@SpringBootApplication
public class DemoredisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoredisApplication.class, args);
	}
        
        
        @Bean
        JedisConnectionFactory jedisConnectionFactory(){
            RedisStandaloneConfiguration alone = new RedisStandaloneConfiguration();
            alone.setHostName("172.16.134.206");
            alone.setPort(6379);
            JedisConnectionFactory fact = new JedisConnectionFactory(alone);
            return fact;
        }
        
        

}
