/**
 * linuxsogood.org
 * Copyright (c) 2014-2024 GaoXin,Inc.All Rights Reserved.
 */
package org.linuxsogood.weixin.entity;


/**
 * 
 * @author gm100861, </br> gm100861@gmail.com
 * @see org.linuxsogood.weixin.entity.WxMessageText
 * @version	V0.0.1-SNAPSHOT, 2015年6月9日 上午11:57:07
 * @description	微信发过来的消息实体
 * 
 */
public class WxMessageText {

	/**
	 * 开发者微信号
	 */
	private String ToUserName;
	
	/**
	 * 发送方帐号（一个OpenID）
	 */
	private String FromUserName;
	
	/**
	 * 消息创建时间 （整型）
	 */
	private String CreateTime;
	
	/**
	 * 消息类型
	 */
	private String MsgType;
	
	/**
	 * 文本消息内容
	 */
	private String Content;
	
	/**
	 * 消息id，64位整型
	 */
	private String MsgId;
	
	/**
	 * 关注/取消关注事件
	 */
	private String Event;
	
	/**
	 * 事件KEY值
	 */
	private String EventKey;
	
	/**
	 * 二维码的ticket，可用来换取二维码图片
	 */
	private String Ticket;
	
	/**
	 * 地理位置纬度
	 */
	private String Latitude;
	
	/**
	 * 地理位置经度
	 */
	private String Longitude;
	
	/**
	 * 地理位置精度
	 */
	private String Precision;
	
	/**
	 * 通过上传多媒体文件，得到的id
	 */
	private String MediaId;
	
	/**
	 * 消息的标题
	 */
	private String Title;
	
	/**
	 * 消息的描述
	 */
	private String Description;
	
	/**
	 * 音乐链接
	 */
	private String MusicURL;

	/**
	 * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 */
	private String HQMusicUrl;
	
	/**
	 * 缩略图的媒体id，通过上传多媒体文件，得到的id
	 */
	private String ThumbMediaId;
	
	/**
	 * 图文消息个数，限制为10条以内
	 */
	private String ArticleCount;
	
	/**
	 * 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
	 */
	private String Articles;
	
	/**
	 * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	 */
	private String PicUrl;
	
	/**
	 * 点击图文消息跳转链接
	 */
	private String Url;
	
	/**
	 * 语音格式：amr
	 */
	private String Format;
	
	/**
	 * 语音识别结果，UTF8编码
	 */
	private String Recognition;
	
	/**
	 * 消息id，64位整型
	 */
	private String MsgID;
	
	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMusicURL() {
		return MusicURL;
	}

	public void setMusicURL(String musicURL) {
		MusicURL = musicURL;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	public String getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}

	public String getArticles() {
		return Articles;
	}

	public void setArticles(String articles) {
		Articles = articles;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	public String getMsgID() {
		return MsgID;
	}

	public void setMsgID(String msgID) {
		MsgID = msgID;
	}

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
