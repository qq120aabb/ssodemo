package com.example.common;

import com.example.mode.TokenInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
@Component
public class TokenManager {

    @Autowired
    private RedisTemplate<String,TokenInfo> template;

    // 存储临时令牌到redis中，存活期60秒
    public  void setToken(String tokenId, TokenInfo tokenInfo) {
        template.opsForValue().set(tokenId,tokenInfo);
    }

    //根据token键取TokenInfo
    public  TokenInfo getToken(String tokenId) {
        return template.opsForValue().get(tokenId);
    }

    //删除某个token键值
    public   void delToken(String tokenId){
        template.delete(tokenId);
    }

}
