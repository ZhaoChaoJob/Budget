package com.budget.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 *  浏览器过滤器
 *
 * Created by chao.zhao on 2017/3/14.
 */
@Component
public class BrowserFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //判断请求是否为ajax
        String requestType = httpServletRequest.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equalsIgnoreCase(requestType)) {
            logger.debug("请求类型为ajax请求，requestType=" + requestType);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        logger.debug("请求类型为非ajax请求，requestType=" + requestType);
        Map<String, String> jsMap = new HashMap<String, String>();
        // 判断是否是微信浏览器的信息
        logger.info("User-Agent=" + httpServletRequest.getHeader("User-Agent"));
        StringBuilder oauth2URL ;
        //通过识别 MicroMessenger 这个关键字来确定是否微信内置的浏览器了
        if (httpServletRequest.getHeader("User-Agent").contains("MicroMessenger")) {

            String uri = httpServletRequest.getRequestURI();
            String url = httpServletRequest.getRequestURL().toString();
            String reqPath = uri.substring(1, uri.length());
            reqPath = reqPath.substring(reqPath.indexOf("/"), reqPath.length());

            String param = httpServletRequest.getQueryString();
            String reqUrl = url + (param != null ? "?" + param : "");

            //oauth2.0url
            oauth2URL = new StringBuilder();
            oauth2URL.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
            oauth2URL.append("wx98770662bc75945f");
            oauth2URL.append("&redirect_uri=");
            oauth2URL.append(URLEncoder.encode(reqUrl, "UTF-8"));
            oauth2URL.append("&response_type=code&scope=snsapi_base&state=boc#wechat_redirect");
            logger.debug("拼成的oauth2.0url" + oauth2URL.toString());


            //如果不是浏览
        }else{
            //oauth2.0url
            oauth2URL = new StringBuilder();
            oauth2URL.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
            oauth2URL.append("wx98770662bc75945f");
            oauth2URL.append("&redirect_uri=");
            oauth2URL.append(URLEncoder.encode("", "UTF-8"));
            oauth2URL.append("&response_type=code&scope=snsapi_base&state=boc#wechat_redirect");
            logger.debug("拼成的oauth2.0url" + oauth2URL.toString());

        }
        httpServletResponse.setContentType("text/html; charset=UTF-8");

//        httpServletResponse.sendRedirect(oauth2URL.toString());
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
