/**
 * linuxsogood.org
 * Copyright (c) 2014-2024 GaoXin,Inc.All Rights Reserved.
 */
package org.linuxsogood.weixin.entity;

import java.util.Date;

/**
 * 
 * @author gm100861, </br> gm100861@gmail.com
 * @see org.linuxsogood.weixin.entity.WxMessageText
 * @version	V0.0.1-SNAPSHOT, 2015��6��9�� ����11:57:07
 * @description	΢�ŷ���������Ϣʵ��
 * 
 */
public class WxMessageText {

	/**
	 * ������΢�ź�
	 */
	private String ToUserName;
	
	/**
	 * ���ͷ��ʺţ�һ��OpenID��
	 */
	private String FromUserName;
	
	/**
	 * ��Ϣ����ʱ�� �����ͣ�
	 */
	private String CreateTime;
	
	/**
	 * ��Ϣ����
	 */
	private String MsgType;
	
	/**
	 * �ı���Ϣ����
	 */
	private String Content;
	
	/**
	 * ��Ϣid��64λ����
	 */
	private String MsgId;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}
	

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	@Override
	public String toString() {
		return "WxMessageText [ToUserName=" + ToUserName + ", FromUserName="
				+ FromUserName + ", CreateTime=" + CreateTime + ", MsgType="
				+ MsgType + ", Content=" + Content + ", MsgId=" + MsgId + "]";
	}
	
}
