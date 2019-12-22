package cn.edu.nju.movietubeserver.support.jwt;

import cn.edu.nju.movietubeserver.utils.IpUtil;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author dc
 * @date 2019/12/21 21:28
 *
 * 身份认证过滤器
 * 对用户进行鉴权
 */
@Component
@Slf4j
public class JWTAuthenticationFilter extends OncePerRequestFilter
{

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(@NotNull final HttpServletRequest httpServletRequest,
        @NotNull final HttpServletResponse httpServletResponse, @NotNull final FilterChain filterChain)
        throws ServletException, IOException
    {
        // 预请求后，直接返回
        // 返回码必须为 200 否则视为请求失败
        if (StringUtils.equals("OPTIONS", httpServletRequest.getMethod()))
        {
            return;
        }

        final String token = jwtUtil.getTokenFromRequest(httpServletRequest);
        if (StringUtils.isEmpty(token))
        {
            log.info("=> Anonymous<{}> request URL<{}> Method<{}>",
                IpUtil.getIpAddress(httpServletRequest),
                httpServletRequest.getRequestURL(),
                httpServletRequest.getMethod());
        }
        else
        {
            final String username = this.jwtUtil.getUsername(token);

            if (StringUtils.isNotEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null)
            {
                final UsernamePasswordAuthenticationToken authentication = jwtUtil.getAuthentication(username, token);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
