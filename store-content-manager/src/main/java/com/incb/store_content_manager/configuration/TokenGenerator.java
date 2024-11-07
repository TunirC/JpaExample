//package com.incb.store_content_manager.configuration;
//
//
//import com.nimbusds.jose.jwk.JWKSet;
//import com.nimbusds.jose.jwk.RSAKey;
//import com.nimbusds.jose.jwk.source.JWKSource;
//import com.nimbusds.jose.proc.SecurityContext;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.oauth2.jwt.JwtClaimsSet;
//import org.springframework.security.oauth2.jwt.JwtEncoder;
//import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
//import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
//
//import java.security.KeyPair;
//import java.security.NoSuchAlgorithmException;
//import java.security.interfaces.RSAPublicKey;
//import java.time.Instant;
//import java.util.Arrays;
//
//@Slf4j
//public class TokenGenerator {
//
//    private JwtEncoder jwtEncoder;
//
//    public TokenGenerator(KeyPair keyPair) {
//        RSAKey rsaKey = new RSAKey.Builder((RSAPublicKey) keyPair.getPublic())
//                .privateKey(keyPair.getPrivate())
//                .build();
//
//        JWKSource<SecurityContext> jwkSource = (jwkSelector, context) -> jwkSelector.select(new JWKSet(rsaKey));
//        this.jwtEncoder = new NimbusJwtEncoder(jwkSource);
//    }
//
//    public static void tokenGenerator () throws NoSuchAlgorithmException {
//        JwtClaimsSet jwtClaims =  JwtClaimsSet.builder()
//                .issuer("https://example.com")
//                .audience(Arrays.asList("https://example.com/resources"))
//                .id("123")
//                .subject("user@example.com")
//                .expiresAt(Instant.now().plusSeconds(3600))
//                .issuedAt(Instant.now())
//                .build();
//
//        log.info("token value: {}", jwtClaims.getClaimAsString());
//
//        NimbusJwtDecoder.JwkSetUriJwtDecoderBuilder jwtDecoderBuilder = Jwts
//    }
//}
