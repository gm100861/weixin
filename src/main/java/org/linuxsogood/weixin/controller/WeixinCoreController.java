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
	 * @description 接收微信推送过来的消息的主控制器,用于对微信推送过来的消息进行各种处理
	 * @param message  用于封装微信推送过来的消息实体
	 * @return
	 */
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/callback",method=RequestMethod.POST)
	public ResponseEntity<String> wxCoreController(HttpServletRequest request,WxMessageText message){
		try {
			message = baseService.xmlToEntity(request);
			if(message == null){
				log.error("非法的请求");
				log.error("请求者的IP:"+request.getRemoteHost());
				return null;
			}
			/**
			 * 如果消息是文本消息的处理
			 */
			log.info("开始判断消息的类型"+message.getMsgType());
			System.out.println(message.getEvent());
			if(message.getMsgType().equals(WxMessageType.TEXT)){
				log.info("接收到的消息是一条文本消息,开始对这条消息进行处理,消息编号为:"+message.getMsgId());
				//根据用户输入的选项不同做不同的处理
				if(message.getContent().equals("1")){
					String xml = textService.getWeather(message);
					return new ResponseEntity<String>(xml,HttpStatus.OK);
				}else if(message.getContent().equals("2")){
					String xml = textService.getJoke(message);
					return new ResponseEntity<String>(xml,HttpStatus.OK);
				}
				String xml = textService.unknowMessage(message);
				return new ResponseEntity<String>(xml,HttpStatus.OK);
				//是事件类型的
			}else if(message.getMsgType().equals(WxMessageType.REQ_MESSAGE_TYPE_EVENT)){
				//如果是被关注
				if(message.getEvent().equals(WxMessageType.EVENT_TYPE_SUBSCRIBE));
				//号码被订阅的事件
				String xml = textService.subscribe(message);
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
	//@RequestMapping(value="/callback")
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
