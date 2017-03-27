package com.budget.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chao.zhao on 2017/3/14.
 */
@Component
public class OAuthUrlFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //是否通过Auth2.0链接跳转
        String state = request.getParameter("state");
        String code = request.getParameter("code");
        if (verificationString(code, state)) {
            chain.doFilter(request, response);
            return;
        }

        String openId;
        //获取并效验openId
        if (request.getSession().getAttribute("openId") == null) {
//            openId = wechatAuthorize.getOpenIdByCode(code);
//            request.getSession().setAttribute("openId", openId);
        } else {
            openId = (String) request.getSession().getAttribute("openId");
        }
    }

    /**
     * 验证字符串不能为空和双引
     *
     * @param params 参数集合
     * @return true/false
     */
    private Boolean verificationString(String... params) {
        for (String param : params) {
            if (param == null || "".equals(param)) {
                return true;
            }
        }
        return false;
    }

}
