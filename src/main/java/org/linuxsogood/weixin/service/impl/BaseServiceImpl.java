/**
 * linuxsogood.org
 * Copyright (c) 2014-2024 GaoXin,Inc.All Rights Reserved.
 */
package org.linuxsogood.weixin.service.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;
import org.linuxsogood.weixin.controller.WeixinCoreController;
import org.linuxsogood.weixin.entity.WxMessageText;
import org.linuxsogood.weixin.service.BaseService;
import org.linuxsogood.weixin.utils.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author gm100861, </br> gm100861@gmail.com
 * @see org.linuxsogood.weixin.service.impl.BaseServiceImpl
 * @version	V0.0.1-SNAPSHOT, 2015��6��10�� ����12:57:10
 * @description
 * 
 */
@Service
public class BaseServiceImpl implements BaseService{

	private static final Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	@Override
	public WxMessageText xmlToEntity(HttpServletRequest request) {
		try {
			WxMessageText message = new WxMessageText();
			log.info("���յ�΢�����͹�����һ������Ϣ,��ʼ����");
			Map<String, String> map = MessageUtils.xmlToMap(request);
			if(map.size() == 0){
				log.error("�Ƿ�������");
				log.error("���յ�΢�����͹�������ϢΪ��");
				return null;
			}
			message.setCreateTime(map.get("CreateTime"));
			message.setFromUserName(map.get("FromUserName"));
			message.setToUserName(map.get("ToUserName"));
			message.setContent(map.get("Content"));
			message.setMsgId(map.get("MsgId"));
			message.setMsgType(map.get("MsgType"));
			message.setEvent(map.get("Event"));
			message.setEventKey(map.get("EventKey"));
			return message;
		} catch (DocumentException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return null;
	}

}
