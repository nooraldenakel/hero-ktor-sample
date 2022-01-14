package com.example.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.example.data.models.Person

class JwtService {
    private val issuer = "HeroServer"
    private val jwtSecret = System.getenv("JWT_SECRET")
    private val algorithm = Algorithm.HMAC512(jwtSecret)

    val verifier: JWTVerifier = JWT
        .require(algorithm)
        .withIssuer(issuer)
        .build()

    fun generateToken(user: Person): String {
        return JWT.create()
            .withSubject("NotAuthentication")
            .withIssuer(issuer)
            .withClaim("email", user.email)
            .sign(algorithm)
    }

}