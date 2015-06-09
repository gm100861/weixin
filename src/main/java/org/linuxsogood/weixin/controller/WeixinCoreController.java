/**
 * 
 */
package org.linuxsogood.weixin.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.linuxsogood.weixin.entity.User;
import org.linuxsogood.weixin.entity.WxMessageText;
import org.linuxsogood.weixin.entity.WxMessageType;
import org.linuxsogood.weixin.utils.CheckUtils;
import org.linuxsogood.weixin.utils.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Honway
 *
 */
@Controller
public class WeixinCoreController {

	private static final Logger log = LoggerFactory.getLogger(WeixinCoreController.class);
	
	/**
	 * @description ����΢�����͹�������Ϣ����������,���ڶ�΢�����͹�������Ϣ���и��ִ���
	 * @param message  ���ڷ�װ΢�����͹�������Ϣʵ��
	 * @return
	 */
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/callback",method=RequestMethod.POST)
	public ResponseEntity<String> wxCoreController(HttpServletRequest request,WxMessageText message){
		try {
			/**
			 * �ж���Ϣ������
			 */
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
			/**
			 * �����Ϣ���ı���Ϣ�Ĵ���
			 */
			log.info("��ʼ�ж���Ϣ������");
			if(message.getMsgType().equals(WxMessageType.TEXT)){
				log.info("���յ�����Ϣ��һ���ı���Ϣ,��ʼ��������Ϣ���д���,��Ϣ���Ϊ:"+message.getMsgId());
				WxMessageText text = new WxMessageText();
				text.setFromUserName(message.getToUserName());
				text.setToUserName(message.getFromUserName());
				text.setMsgType(WxMessageType.TEXT);
				text.setCreateTime(new Date().getTime()+"");
				text.setContent("���յ����㷢��������Ϣ,��Ϣ����Ϊ:"+message.getContent());
				text.setMsgId(message.getMsgId());
				log.info("��Ϣ����ɹ�:"+message.getMsgId());
				String xml = MessageUtils.textMessageToXml(text);
				return new ResponseEntity<String>(xml,HttpStatus.OK);
			}
		} catch (Exception e) {
			if(log.isErrorEnabled()){
				log.error("controller��ִ��ʱ�����쳣"+e.getMessage());
			}
		}
		return new ResponseEntity<String>("",HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * ΢�Ž���ķ�����΢�Ż�������������������Ҫԭ������echostr��ֵ
	 * @param signature ΢�ż���ǩ����signature����˿�������д��token�����������е�timestamp������nonce������
	 * @param timestamp ʱ���
	 * @param nonce �����
	 * @param echostr ����ַ���
	 * @return
	 */
/*	@RequestMapping(value="/callback")
	public ResponseEntity<String> wxDeveloperCheck(String signature,String timestamp,String nonce,String echostr){
		HttpHeaders headers = new HttpHeaders();
		try {
			log.info("��ʼ���ݴ��ݹ����Ĳ�������ǩ��");
			log.info("signature:"+signature+",timestamp:"+timestamp+",nonce:"+nonce+",echostr"+echostr);
			if(CheckUtils.checkSignature(signature, timestamp, nonce)){
				log.info("ǩ������ɹ�");
				return new ResponseEntity<String>(echostr,headers,HttpStatus.OK); 
			}
		} catch (Exception e) {
			if(log.isErrorEnabled()){
				log.error("controller����֤ǩ����ʱ��ִ���쳣��"+e.getMessage());
			}
		}
		log.info("ǩ������ʧ��");
		return new ResponseEntity<String>("",headers,HttpStatus.OK);
	}
	*/
	/**
	 * �����ܲ��ܷ���XML
	 * @description {TODO}
	 * @return
	 */
	@RequestMapping(value="/getXML",method=RequestMethod.GET)
	public ModelAndView coreReq(){
		ModelAndView mv = new ModelAndView("jaxb2MarshallingView");
		User user = new User();
		user.setAddress("�Ϻ���");
		user.setId("001");
		user.setJob("Information Engenner");
		user.setNickname("Tommash");
		user.setSchool("Zhikago");
		user.setUsername("lisi");
		mv.addObject(user);
		return mv;
	}
}
