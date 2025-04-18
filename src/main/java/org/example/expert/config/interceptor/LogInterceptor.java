package org.example.expert.config.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j // 로그 찍기 위해서
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // URL 로그 찍기 위해
        String requestURI = request.getRequestURI();
        // URL 로그 남기기
        log.info(requestURI);
        // 요청 시간 로그 찍기 위해
        String formattedTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd E HH:mm:ss"));
        // 요청 시간 로그 찍기
        log.info(formattedTime);
        return true;
    }
}
