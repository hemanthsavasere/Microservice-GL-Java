package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.model.CartLine;

@Configuration
public class RedisConfiguration {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
//	    jedisConFactory.setHostName("localhost");
//	    jedisConFactory.setPort(6379);
		return jedisConFactory;
	}

	@Bean
	public RedisTemplate<String, CartLine> redisTemplate() {
		RedisTemplate<String, CartLine> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}
}
