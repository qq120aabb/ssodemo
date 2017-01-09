package com.example.common;

import com.example.mode.TokenInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by Administrator on 2016/12/26 0026.
 */
@Configuration
@EnableRedisRepositories
@EnableRedisHttpSession
public class RedisConfig {

    /**
     * jedis
     */
    @Bean
    public JedisConnectionFactory  jedisConnectionFactory() {
//        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration().master("dev_1_gic").sentinel("172.30.2.28",26379).sentinel("172.30.2.29",26379);
//        return new JedisConnectionFactory(sentinelConfig);
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, TokenInfo> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, TokenInfo> template = new RedisTemplate<String, TokenInfo>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }
}
