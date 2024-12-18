package com.example.backend.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Component
@Transactional
@RequiredArgsConstructor
public class MemberRedisService {
    private final RedisTemplate<String, Object> redisTemplate;

    public void setValue(String key, String data, Duration duration) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ops.set(key, data, duration);
    }

    @Transactional(readOnly = true)
    public String getValues(String key) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        if (ops.get(key) == null) {
            return "false";
        }
        return (String) ops.get(key);
    }

    public void deleteValue(String key) {redisTemplate.delete(key);}

    // 리프레시 토큰을 Redis에 저장하고 유효시간을 설정
    public void saveRefreshToken(String memberId, String refreshToken, long duration, TimeUnit unit) {
        redisTemplate.opsForValue().set("refreshToken:" + memberId, refreshToken, duration, unit);
    }

    // 리프레시 토큰을 Redis에서 가져옴
    public String getRefreshToken(long memberId) {
        return (String) redisTemplate.opsForValue().get("refreshToken:" + memberId);
    }

    // 리프레시 토큰을 Redis에서 삭제
    public void deleteRefreshToken(long memberId) {
        redisTemplate.delete("refreshToken:" + memberId);
    }

}
