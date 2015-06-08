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
		user.setAddress("上海市");
		user.setId("001");
		user.setJob("Information Engenner");
		user.setNickname("Tommash");
		user.setSchool("Zhikago");
		user.setUsername("lisi");
		mv.addObject(user);
		return mv;
	}
	
	/**
	 * 微信接入的方法，微信会调用这个方法，并且需要原样返回echostr的值
	 * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
	 * @param timestamp 时间戳
	 * @param nonce 随机数
	 * @param echostr 随机字符串
	 * @return
	 */
	@RequestMapping(value="/callback")
	public ResponseEntity<String> wxDeveloperCheck(String signature,String timestamp,String nonce,String echostr){
		HttpHeaders headers = new HttpHeaders();
		try {
			log.info("开始根据传递过来的参数检验签名");
			log.info("signature:"+signature+",timestamp:"+timestamp+",nonce:"+nonce+",echostr"+echostr);
			if(CheckUtils.checkSignature(signature, timestamp, nonce)){
				log.info("签名检验成功");
				return new ResponseEntity<String>(echostr,headers,HttpStatus.OK); 
			}
		} catch (Exception e) {
			if(log.isErrorEnabled()){
				log.error("controller在验证签名的时候执行异常："+e.getMessage());
			}
		}
		log.info("签名检验失败");
		return new ResponseEntity<String>("",headers,HttpStatus.OK);
	}
}
