package com.example;

import com.example.mode.TokenInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServerApplicationTests {

	@Autowired
	private RedisTemplate<String,TokenInfo> stringRedisTemplate;

//    @Autowired
//    private StringRedisTemplate template;

	@Test
	public void contextLoads() {
       String tokenId= UUID.randomUUID().toString();

        TokenInfo tokenInfo=new TokenInfo();
        tokenInfo.setUsername("zhangsan");
        tokenInfo.setUserId(11);
        stringRedisTemplate.opsForValue().set(String.valueOf(tokenInfo.getUserId()),tokenInfo);

        TokenInfo tokenInfo1 = stringRedisTemplate.opsForValue().get(String.valueOf(tokenInfo.getUserId()));
        System.out.println(tokenInfo1);

//        template.opsForValue().set(tokenId,"ceshi");
    }

}
