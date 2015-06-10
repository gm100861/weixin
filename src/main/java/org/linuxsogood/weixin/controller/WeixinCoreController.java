/**
 * 
 */
package org.linuxsogood.weixin.controller;

import javax.servlet.http.HttpServletRequest;

import org.linuxsogood.weixin.entity.User;
import org.linuxsogood.weixin.entity.WxMessageText;
import org.linuxsogood.weixin.entity.WxMessageType;
import org.linuxsogood.weixin.service.BaseService;
import org.linuxsogood.weixin.service.TextMessageService;
import org.linuxsogood.weixin.utils.CheckUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private BaseService baseService;
	
	@Autowired
	private TextMessageService textService;
	
	/**
	 * @description ����΢�����͹�������Ϣ����������,���ڶ�΢�����͹�������Ϣ���и��ִ���
	 * @param message  ���ڷ�װ΢�����͹�������Ϣʵ��
	 * @return
	 */
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/callback",method=RequestMethod.POST)
	public ResponseEntity<String> wxCoreController(HttpServletRequest request,WxMessageText message){
		try {
			message = baseService.xmlToEntity(request);
			if(message == null){
				log.error("�Ƿ�������");
				log.error("�����ߵ�IP:"+request.getRemoteHost());
				return null;
			}
			/**
			 * �����Ϣ���ı���Ϣ�Ĵ���
			 */
			log.info("��ʼ�ж���Ϣ������"+message.getMsgType());
			System.out.println(message.getEvent());
			if(message.getMsgType().equals(WxMessageType.TEXT)){
				log.info("���յ�����Ϣ��һ���ı���Ϣ,��ʼ��������Ϣ���д���,��Ϣ���Ϊ:"+message.getMsgId());
				//�����û������ѡ�ͬ����ͬ�Ĵ���
				if(message.getContent().equals("1")){
					String xml = textService.getWeather(message);
					return new ResponseEntity<String>(xml,HttpStatus.OK);
				}else if(message.getContent().equals("2")){
					String xml = textService.getJoke(message);
					return new ResponseEntity<String>(xml,HttpStatus.OK);
				}
				String xml = textService.unknowMessage(message);
				return new ResponseEntity<String>(xml,HttpStatus.OK);
				//���¼����͵�
			}else if(message.getMsgType().equals(WxMessageType.REQ_MESSAGE_TYPE_EVENT)){
				//����Ǳ���ע
				if(message.getEvent().equals(WxMessageType.EVENT_TYPE_SUBSCRIBE));
				//���뱻���ĵ��¼�
				String xml = textService.subscribe(message);
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
	//@RequestMapping(value="/callback")
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
