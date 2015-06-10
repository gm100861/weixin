/**
 * linuxsogood.org
 * Copyright (c) 2014-2024 GaoXin,Inc.All Rights Reserved.
 */
package org.linuxsogood.weixin.entity;


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
	
	/**
	 * ��ע/ȡ����ע�¼�
	 */
	private String Event;
	
	/**
	 * �¼�KEYֵ
	 */
	private String EventKey;
	
	/**
	 * ��ά���ticket����������ȡ��ά��ͼƬ
	 */
	private String Ticket;
	
	/**
	 * ����λ��γ��
	 */
	private String Latitude;
	
	/**
	 * ����λ�þ���
	 */
	private String Longitude;
	
	/**
	 * ����λ�þ���
	 */
	private String Precision;
	
	/**
	 * ͨ���ϴ���ý���ļ����õ���id
	 */
	private String MediaId;
	
	/**
	 * ��Ϣ�ı���
	 */
	private String Title;
	
	/**
	 * ��Ϣ������
	 */
	private String Description;
	
	/**
	 * ��������
	 */
	private String MusicURL;

	/**
	 * �������������ӣ�WIFI��������ʹ�ø����Ӳ�������
	 */
	private String HQMusicUrl;
	
	/**
	 * ����ͼ��ý��id��ͨ���ϴ���ý���ļ����õ���id
	 */
	private String ThumbMediaId;
	
	/**
	 * ͼ����Ϣ����������Ϊ10������
	 */
	private String ArticleCount;
	
	/**
	 * ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ,ע�⣬���ͼ��������10���򽫻�����Ӧ
	 */
	private String Articles;
	
	/**
	 * ͼƬ���ӣ�֧��JPG��PNG��ʽ���Ϻõ�Ч��Ϊ��ͼ360*200��Сͼ200*200
	 */
	private String PicUrl;
	
	/**
	 * ���ͼ����Ϣ��ת����
	 */
	private String Url;
	
	/**
	 * ������ʽ��amr
	 */
	private String Format;
	
	/**
	 * ����ʶ������UTF8����
	 */
	private String Recognition;
	
	/**
	 * ��Ϣid��64λ����
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
