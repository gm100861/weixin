/**
 * linuxsogood.org
 * Copyright (c) 2014-2024 GaoXin,Inc.All Rights Reserved.
 */
package org.linuxsogood.weixin.entity;

/**
 * 
 * @author gm100861, </br> gm100861@gmail.com
 * @see org.linuxsogood.weixin.entity.WxMessageType
 * @version	V0.0.1-SNAPSHOT, 2015��6��9�� ����12:00:58
 * @description
 * 
 */
public class WxMessageType {
	
	/**
	 * text �ı���Ϣ link	
	 */
	public static final String TEXT = "text";
	
	/**
	 * image ͼƬ��Ϣ
	 */
	public static final String IMAGE = "image";
	
	/**
	 * voice ������Ϣ
	 */
	public static final String VOICE = "voice";
	
	/**
	 * video ��Ƶ��Ϣ
	 */
	public static final String VIDEO = "video";
	
	/**
	 * shortvideo С��Ƶ��Ϣ
	 */
	public static final String SHORTVIDEO = "shortvideo";
	
	/**
	 * location ����λ����Ϣ
	 */
	public static final String LOCATION = "location";
	
	/**
	 *  ������Ϣ
	 */
	public static final String LINK = "link";
	
	/**
	 * ������Ϣ���ͣ�����
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * �¼����ͣ�subscribe(����)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * �¼����ͣ�unsubscribe(ȡ������)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * �¼����ͣ�CLICK(�Զ���˵�����¼�)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";

}
