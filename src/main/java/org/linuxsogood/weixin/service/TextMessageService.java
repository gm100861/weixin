/**
 * linuxsogood.org
 * Copyright (c) 2014-2024 GaoXin,Inc.All Rights Reserved.
 */
package org.linuxsogood.weixin.service;

import org.linuxsogood.weixin.entity.WxMessageText;

/**
 * 
 * @author gm100861, </br> gm100861@gmail.com
 * @see org.linuxsogood.weixin.service.TextMessageService
 * @version	V0.0.1-SNAPSHOT, 2015��6��10�� ����1:13:28
 * @description
 * 
 */
public interface TextMessageService {
	
	/**
	 * @description ����һ��������Ϣ
	 * @param message ����������Ϣʵ����
	 * @return xml��ʽ
	 */
	String testMessage(WxMessageText message);
	
	/**
	 * @description ����Ҫ���ص�xml������
	 * @param content
	 * @return
	 */
	String setContent(WxMessageText message,String content);

	/**
	 * @description ����ѡ��δ֪
	 * @param message
	 * @return
	 */
	String unknowMessage(WxMessageText message);

	/**
	 * @description ���뱻���ĵĴ����߼�
	 * @return
	 */
	String subscribe(WxMessageText message);
	
	/**
	 *
	 * @description ��ȡ������Ϣ
	 * @param message
	 * @return
	 */
	String getWeather(WxMessageText message);

	/**
	 * @description �������һ��Ц��
	 * @param message
	 * @return
	 */
	String getJoke(WxMessageText message);
}
