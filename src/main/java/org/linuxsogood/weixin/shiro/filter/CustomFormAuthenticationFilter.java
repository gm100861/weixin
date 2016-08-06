package org.linuxsogood.weixin.shiro.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author honway.liu
 * @date 16/8/6 下午6:04
 * @email gm100861@gmail.com
 * @blog http://linuxsogood.org
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{

    /**
     * 访问拒绝策略
     * @param request
     * @param response
     * @return 返回true表示不允许访问
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return super.onAccessDenied(request, response);
    }
}
