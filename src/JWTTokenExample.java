
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTTokenExample {
    public static void main(String[] args) {
        Algorithm algorithm = Algorithm.HMAC256("secret");

        String token = JWT.create()
                .withIssuer("my-app")
                .withClaim("user_id", 123)
                .sign(algorithm);

        System.out.println(token);

        Algorithm verifierAlgorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(verifierAlgorithm)
                .withIssuer("my-app")
                .build();

        DecodedJWT jwt = verifier.verify(token);

        System.out.println(jwt.getClaim("user_id").asInt()); // 123
    }
}
