/**
 * linuxsogood.org
 * Copyright (c) 2014-2024 GaoXin,Inc.All Rights Reserved.
 */
package org.linuxsogood.weixin.service;

import javax.servlet.http.HttpServletRequest;

import org.linuxsogood.weixin.entity.WxMessageText;

/**
 * 
 * @author gm100861, </br> gm100861@gmail.com
 * @see org.linuxsogood.weixin.service.BaseService
 * @version	V0.0.1-SNAPSHOT, 2015��6��10�� ����12:53:45
 * @description ����������
 * 
 */
public interface BaseService {
	/**
	 * @description ��΢�����͹�����xmlת��ΪMessageTextʵ��
	 * @param request
	 * @return
	 */
	WxMessageText xmlToEntity(HttpServletRequest request);
}
