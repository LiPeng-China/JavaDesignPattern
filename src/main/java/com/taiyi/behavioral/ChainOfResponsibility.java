package com.taiyi.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器首相接口
 */
interface Filter {
    void doFilter(String request, String response, FilterChain filterChain);
}

/**
 * 过滤器链
 */
class FilterChain {
    private List<Filter> filters = new ArrayList<>();
    private int position = 0;

    public void doFilter(String request, String response) {
        if (position >= filters.size()) return;

        Filter filter = filters.get(this.position++);

        filter.doFilter(request, response, this);
    }

    public FilterChain addFilter(Filter filter) {
        this.filters.add(filter);
        return this;
    }
}

/**
 * 登录过滤器
 */
class LoginFilter implements Filter {

    @Override
    public void doFilter(String request, String response, FilterChain filterChain) {
        System.out.println("Login filter start ……");
        filterChain.doFilter(request, response);
        System.out.println("Login filter end ！");
    }
}

/**
 * 字符修改过滤器
 */
class CharFilter implements Filter {

    @Override
    public void doFilter(String request, String response, FilterChain filterChain) {
        System.out.println("Char filter start ……");
        filterChain.doFilter(request, response);
        System.out.println("Char filter end ！");
    }
}

/**
 * 权限校验过滤器
 */
class GrantFilter implements Filter {

    @Override
    public void doFilter(String request, String response, FilterChain filterChain) {
        System.out.println("Grant filter start ……");
        filterChain.doFilter(request, response);
        System.out.println("Grant filter end ！");
    }
}

public class ChainOfResponsibility {


    public static void main(String[] args) {
        Filter loginFilter = new LoginFilter();
        Filter charFilter = new CharFilter();
        Filter grantFilter = new GrantFilter();

        FilterChain filterChain = new FilterChain();

        filterChain.addFilter(loginFilter).addFilter(charFilter).addFilter(grantFilter);

        filterChain.doFilter("request", "response");

    }
}
