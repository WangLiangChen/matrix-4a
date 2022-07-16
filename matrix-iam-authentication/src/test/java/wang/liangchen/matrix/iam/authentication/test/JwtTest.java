package wang.liangchen.matrix.iam.authentication.test;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.crypto.impl.RSAKeyUtils;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.encryption.SecretKeyUtil;
import wang.liangchen.matrix.framework.commons.encryption.enums.KeyAlgorithm;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.Base64;
import java.util.Date;

/**
 * @author Liangchen.Wang 2022-07-16 10:50
 */
public class JwtTest {

    @Test
    public void jwt() throws JOSEException, ParseException, NoSuchAlgorithmException {
        RSAKey rsaKey = new RSAKeyGenerator(2048).generate();
        String publicKeyString = Base64.getEncoder().encodeToString(rsaKey.toPublicKey().getEncoded());
        String privateKeyString = Base64.getEncoder().encodeToString(rsaKey.toPrivateKey().getEncoded());

        PrivateKey privateKey = SecretKeyUtil.INSTANCE.generatePrivateKeyPKCS8(KeyAlgorithm.RSA, privateKeyString);
        PublicKey publicKey = SecretKeyUtil.INSTANCE.generatePublicKeyX509(KeyAlgorithm.RSA, publicKeyString);
        // Create RSA-signer with the private key
        JWSSigner signer = new RSASSASigner(privateKey);

        // Prepare JWT with claims set
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject("alice")
                .issuer("https://c2id.com")
                .expirationTime(new Date(new Date().getTime() + 60 * 1000))
                .build();

        SignedJWT signedJWT = new SignedJWT(
                new JWSHeader.Builder(JWSAlgorithm.RS256).build(),
                claimsSet);

        signedJWT.sign(signer);

        String signedString = signedJWT.serialize();
        System.out.println(signedString);


        signedJWT = SignedJWT.parse(signedString);


        JWSVerifier verifier = new RSASSAVerifier((RSAPublicKey) publicKey);
        boolean verify = signedJWT.verify(verifier);
        System.out.println(verify);
    }


}
