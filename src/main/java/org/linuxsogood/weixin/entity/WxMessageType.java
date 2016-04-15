/**
 * linuxsogood.org
 * Copyright (c) 2014-2024 GaoXin,Inc.All Rights Reserved.
 */
package org.linuxsogood.weixin.entity;

/**
 *
 * @author gm100861, </br> gm100861@gmail.com
 * @see org.linuxsogood.weixin.entity.WxMessageType
 * @version	V0.0.1-SNAPSHOT, 2015年6月9日 下午12:00:58
 * @description
 *
 */
public class WxMessageType {

	/**
	 * text 文本消息 link
	 */
	public static final String TEXT = "text";

	/**
	 * image 图片消息
	 */
	public static final String IMAGE = "image";

	/**
	 * voice 语音消息
	 */
	public static final String VOICE = "voice";

	/**
	 * video 视频消息
	 */
	public static final String VIDEO = "video";

	/**
	 * shortvideo 小视频消息
	 */
	public static final String SHORTVIDEO = "shortvideo";

	/**
	 * location 地理位置消息
	 */
	public static final String LOCATION = "location";

	/**
	 *  链接消息
	 */
	public static final String LINK = "link";

	/**
	 * 请求消息类型：推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * 事件类型：subscribe(订阅)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型：unsubscribe(取消订阅)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * 事件类型：CLICK(自定义菜单点击事件)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";

}