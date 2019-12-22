package cn.edu.nju.movietubeserver.support.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author dc
 * @date 2019/12/21 21:28
 *
 * JSON Web Token配置
 */
@Component
@ConfigurationProperties(prefix = "jwt")
@Data
public class JWTSetting
{

    private String authoritiesKey;

    // RSA 私钥
    private String privateKey;

    // RSA 公钥
    private String publicKey;

    // token 前缀
    private String tokenPrefix;

    // 存放 token 的 Header Key
    private String header;

    // token 有效期
    private long expirationTime;
}
