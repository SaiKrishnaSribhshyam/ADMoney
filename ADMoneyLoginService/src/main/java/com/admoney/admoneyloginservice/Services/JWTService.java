package com.admoney.admoneyloginservice.Services;

import com.admoney.admoneyloginservice.Models.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JWTService {
    @Value( "${jwt.algo.secret.key}:NOSECRETKEY")
    private final String secretKey="NOSECRETKEY";
    private final Algorithm algorithm=Algorithm.HMAC256(secretKey);

    public String createJWTToken(User user){
        return JWT.create()
                .withClaim("user",user.getMobileNum())
                .withIssuer("auth0")
                .sign(algorithm);

    }

    public String verifyJWTToken(String token){
        JWTVerifier verifier=JWT.require(algorithm)
                .withIssuer("auth0")
                .build();
        return verifier.verify(token).getPayload();
    }
}
