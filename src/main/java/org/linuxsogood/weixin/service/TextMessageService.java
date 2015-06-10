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
 * @version	V0.0.1-SNAPSHOT, 2015年6月10日 下午1:13:28
 * @description
 * 
 */
public interface TextMessageService {
	
	/**
	 * @description 返回一条测试消息
	 * @param message 发过来的消息实体类
	 * @return xml格式
	 */
	String testMessage(WxMessageText message);
	
	/**
	 * @description 设置要返回的xml的内容
	 * @param content
	 * @return
	 */
	String setContent(WxMessageText message,String content);

	/**
	 * @description 返回选项未知
	 * @param message
	 * @return
	 */
	String unknowMessage(WxMessageText message);

	/**
	 * @description 号码被订阅的处理逻辑
	 * @return
	 */
	String subscribe(WxMessageText message);
	
	/**
	 *
	 * @description 获取天气信息
	 * @param message
	 * @return
	 */
	String getWeather(WxMessageText message);

	/**
	 * @description 随机返回一个笑话
	 * @param message
	 * @return
	 */
	String getJoke(WxMessageText message);
}
