package com.admoney.admoneyadmanagementservice.Config;

import com.admoney.admoneyadmanagementservice.Services.JWTService;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    private final Logger logger= LoggerFactory.getLogger(AuthenticationInterceptor.class);
    @Autowired
    private JWTService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest httpRequest, HttpServletResponse httpReponse, Object handler) throws AuthenticationException{
        Cookie[] cookies=httpRequest.getCookies();
        boolean isValidCookieAvailable=false;
            logger.info("arrived on interceptior");
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    isValidCookieAvailable = true;
                    DecodedJWT decodedJWT = jwtService.verifyJWTToken(cookie.getValue());
                    if (decodedJWT == null) {
                        logger.info("Before raising exception for failed JWT");
                        throw new AuthenticationException("JWT verification failed");
                    }
                }
            }
            if (!isValidCookieAvailable){
                logger.info("Before raising exception for missing cookie");
                throw new AuthenticationException("JWT cookie missing in request");
            }
        HttpSession session=httpRequest.getSession();
        session.setAttribute("Authentication","Completed");
        return  true;
    }

}
