/**
 * 
 */
package org.linuxsogood.weixin.controller;

import org.linuxsogood.weixin.entity.User;
import org.linuxsogood.weixin.utils.CheckUtils;
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
	
	/**
	 * ΢�Ž���ķ�����΢�Ż�������������������Ҫԭ������echostr��ֵ
	 * @param signature ΢�ż���ǩ����signature����˿�������д��token�����������е�timestamp������nonce������
	 * @param timestamp ʱ���
	 * @param nonce �����
	 * @param echostr ����ַ���
	 * @return
	 */
	@RequestMapping(value="/callback")
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
}
