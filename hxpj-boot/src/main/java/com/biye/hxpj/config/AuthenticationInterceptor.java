package com.biye.hxpj.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.biye.hxpj.annotation.LoginRequired;
import com.biye.hxpj.exception.BusinessException;
import com.biye.hxpj.model.User;
import com.biye.hxpj.service.SysUserService;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

/**
 * @program: hxpj
 * @description: 拦截器
 * @author: LiLei
 **/

public class AuthenticationInterceptor implements HandlerInterceptor{
    @Resource
    private SysUserService sysUserService;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception{
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
        // 有 @LoginRequired 注解，需要认证
        if (methodAnnotation != null) {
            // 执行认证,从 http 请求头中取出 token
            String token = request.getHeader("X-Token");
            if (token == null) {
                throw new RuntimeException("无token，请重新登录");
            }
            Long loginId;
            try {
                // 获取 token 中的 user id
                loginId = Long.parseLong(JWT.decode(token).getAudience().get(0));
            } catch (JWTDecodeException e) {
                throw new BusinessException("token无效，请重新登录");
            }
            User user = sysUserService.findById(loginId);
            if (user == null) {
                throw new RuntimeException("用户不存在，请重新登录");
            }
            // 验证 token
            try {
                JWTVerifier verifier =  JWT.require(Algorithm.HMAC256(user.getPassWord())).build();
                try {
                    verifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("token无效，请重新登录");
                }
            } catch (UnsupportedEncodingException ignore) {}
            request.setAttribute("currentUser", user);
            return true;
        }
        return true;
    }
}
