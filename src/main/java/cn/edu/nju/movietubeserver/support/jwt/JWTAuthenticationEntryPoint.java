package cn.edu.nju.movietubeserver.support.jwt;

import cn.edu.nju.movietubeserver.constant.ErrorMessage;
import cn.edu.nju.movietubeserver.support.response.RestApiResponseUtil;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author dc
 * @date 2019/12/21 21:28
 *
 * Json Web Token 入口点
 */
@Component
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable
{

    private static final long serialVersionUID = -7081319995124953254L;

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
        AuthenticationException e)
        throws IOException
    {
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.setHeader("Content-type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        httpServletResponse.getWriter()
            .print(RestApiResponseUtil.createErrorResponse(HttpStatus.UNAUTHORIZED,
                ErrorMessage.DEFAULT_UNAUTHORIZED_MESSAGE).toString());
        httpServletResponse.getWriter().close();
    }
}
