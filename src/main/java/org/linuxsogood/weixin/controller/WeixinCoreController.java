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
	 * @description 接收微信推送过来的消息的主控制器,用于对微信推送过来的消息进行各种处理
	 * @param message  用于封装微信推送过来的消息实体
	 * @return
	 */
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/callback",method=RequestMethod.POST)
	public ResponseEntity<String> wxCoreController(HttpServletRequest request,WxMessageText message){
		try {
			/**
			 * 判断消息的类型
			 */
			log.info("接收到微信推送过来的一条新消息,开始处理");
			Map<String, String> map = MessageUtils.xmlToMap(request);
			if(map.size() == 0){
				log.error("非法的请求");
				log.error("接收到微信推送过来的消息为空");
				return null;
			}
			message.setCreateTime(map.get("CreateTime"));
			message.setFromUserName(map.get("FromUserName"));
			message.setToUserName(map.get("ToUserName"));
			message.setContent(map.get("Content"));
			message.setMsgId(map.get("MsgId"));
			message.setMsgType(map.get("MsgType"));
			/**
			 * 如果消息是文本消息的处理
			 */
			log.info("开始判断消息的类型");
			if(message.getMsgType().equals(WxMessageType.TEXT)){
				log.info("接收到的消息是一条文本消息,开始对这条消息进行处理,消息编号为:"+message.getMsgId());
				WxMessageText text = new WxMessageText();
				text.setFromUserName(message.getToUserName());
				text.setToUserName(message.getFromUserName());
				text.setMsgType(WxMessageType.TEXT);
				text.setCreateTime(new Date().getTime()+"");
				text.setContent("接收到了你发过来的消息,消息内容为:"+message.getContent());
				text.setMsgId(message.getMsgId());
				log.info("消息处理成功:"+message.getMsgId());
				String xml = MessageUtils.textMessageToXml(text);
				return new ResponseEntity<String>(xml,HttpStatus.OK);
			}
		} catch (Exception e) {
			if(log.isErrorEnabled()){
				log.error("controller在执行时出现异常"+e.getMessage());
			}
		}
		return new ResponseEntity<String>("",HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * 微信接入的方法，微信会调用这个方法，并且需要原样返回echostr的值
	 * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
	 * @param timestamp 时间戳
	 * @param nonce 随机数
	 * @param echostr 随机字符串
	 * @return
	 */
/*	@RequestMapping(value="/callback")
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
	*/
	/**
	 * 测试能不能返回XML
	 * @description {TODO}
	 * @return
	 */
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
}
