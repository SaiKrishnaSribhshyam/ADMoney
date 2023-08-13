package com.admoney.admoneyadmanagementservice.Services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JWTService {
    @Value( "${jwt.algo.secret.key:NOSECRETKEY}")
    private final String secretKey="NOSECRETKEY";
    private final Algorithm algorithm=Algorithm.HMAC256(secretKey);


    public DecodedJWT verifyJWTToken(String token){
        JWTVerifier verifier=JWT.require(algorithm)
                .withIssuer("auth0")
                .build();
        return verifier.verify(token);
    }
}
