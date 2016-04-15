/**
 * linuxsogood.org
 * Copyright (c) 2014-2024 GaoXin,Inc.All Rights Reserved.
 */
package org.linuxsogood.weixin.service;

import org.linuxsogood.weixin.entity.WxMessageText;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author gm100861, </br> gm100861@gmail.com
 * @see org.linuxsogood.weixin.service.BaseService
 * @version	V0.0.1-SNAPSHOT, 2015年6月10日 下午12:53:45
 * @description 基础服务类
 *
 */
public interface BaseService {
	/**
	 * @description 把微信推送过来的xml转换为MessageText实体
	 * @param request
	 * @return
	 */
	WxMessageText xmlToEntity(HttpServletRequest request);
}
