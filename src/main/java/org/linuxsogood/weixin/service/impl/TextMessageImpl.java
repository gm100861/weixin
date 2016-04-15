/**
 * linuxsogood.org
 * Copyright (c) 2014-2024 GaoXin,Inc.All Rights Reserved.
 */
package org.linuxsogood.weixin.service.impl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.RandomUtils;
import org.apache.http.client.ClientProtocolException;
import org.linuxsogood.weixin.entity.WxMessageText;
import org.linuxsogood.weixin.entity.WxMessageType;
import org.linuxsogood.weixin.service.TextMessageService;
import org.linuxsogood.weixin.utils.HTTPUtils;
import org.linuxsogood.weixin.utils.MessageUtils;
import org.linuxsogood.weixin.vo.Weather;
import org.linuxsogood.weixin.vo.WeatherObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author gm100861, </br> gm100861@gmail.com
 * @see org.linuxsogood.weixin.service.impl.TextMessageImpl
 * @version	V0.0.1-SNAPSHOT, 2015年6月10日 下午1:14:22
 * @description
 *
 */
@Service
public class TextMessageImpl implements TextMessageService {
	private static final Logger log = LoggerFactory.getLogger(TextMessageImpl.class);


	@Override
	public String setContent(WxMessageText message,String content) {
		WxMessageText text = new WxMessageText();
		text.setFromUserName(message.getToUserName());
		text.setToUserName(message.getFromUserName());
		text.setMsgType(WxMessageType.TEXT);
		text.setCreateTime(new Date().getTime()+"");
		text.setContent(content);
		text.setMsgId(message.getMsgId());
		log.info("消息处理成功:"+message.getMsgId());
		return MessageUtils.textMessageToXml(text);
	}

	@Override
	public String testMessage(WxMessageText message) {
		WxMessageText text = new WxMessageText();
		text.setFromUserName(message.getToUserName());
		text.setToUserName(message.getFromUserName());
		text.setMsgType(WxMessageType.TEXT);
		text.setCreateTime(new Date().getTime()+"");
		text.setContent("接收到了你发过来的消息,消息内容为:"+message.getContent());
		text.setMsgId(message.getMsgId());
		log.info("消息处理成功:"+message.getMsgId());
		return MessageUtils.textMessageToXml(text);
	}

	@Override
	public String unknowMessage(WxMessageText message) {
		WxMessageText text = new WxMessageText();
		text.setFromUserName(message.getToUserName());
		text.setToUserName(message.getFromUserName());
		text.setMsgType(WxMessageType.TEXT);
		text.setCreateTime(new Date().getTime()+"");
		text.setContent("未知的选项:"+message.getContent());
		text.setMsgId(message.getMsgId());
		log.info("消息处理成功:"+message.getMsgId());
		return MessageUtils.textMessageToXml(text);
	}

	@Override
	public String subscribe(WxMessageText message) {
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎关注我的订阅号,你可以输入以下指令获取你想要的信息:\r\n");
		sb.append("1:获取上海天气情况\r\n");
		sb.append("2:讲个笑话\r\n");
		sb.append("?:关于本订阅号");
		return setContent(message, sb.toString());
	}

	//@Override
	public String getWeather(WxMessageText message) {
		StringBuffer sb = null;
		try {
			String url = "http://www.weather.com.cn/adat/cityinfo/101020100.html";
			String string = HTTPUtils.get(url, null, null);
			WeatherObj object = JSON.parseObject(string, WeatherObj.class);
			Weather weather = object.getWeatherinfo();
			sb = new StringBuffer();
			sb.append(weather.getCity()+"今天天气如下:\r\n");
			sb.append("上海市今天:"+weather.getWeather());
			sb.append("\r\n最低气温"+weather.getTemp2());
			sb.append("\r\n最高气温"+weather.getTemp1());
			sb.append("天气数据来自于中国天气网,发布时间:"+weather.getPtime());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return setContent(message, sb.toString());
	}

	@Override
	public String getJoke(WxMessageText message) {
		List<String> jokeList = new ArrayList<String>();
		jokeList.add("程序员见禅师：我学了 hello world 和水仙花数，想自己开发个操作系统，希望大师指点。禅师笑而不语，抓来一只鸡，在鸡腿上缠根线，他一拉线，鸡立即跌倒，鸡挣扎起来继续走，禅师又一拉，鸡 又跌倒，如此反复八次之多。程序员若有所悟：“大师您是让百折不挠，再接再厉？”禅师一笑：“小伙子，我是让你拉鸡八倒。”");
		jokeList.add("青年问禅师：“我的同事都用Java，我却只会JavaScript，他们都鄙视我，我该怎么办？” 禅师笑而不语，拿出一件文胸，晃了晃。 青年目测文胸为C罩杯，看着挺大的，顿悟到：“大师的意思是让我宽大为怀，不与他们一般见识？” 禅师叹了口气，说：“我TM是让你学C!”");
		jokeList.add("本人急用钱转让半瓶雪碧上个月9号买的，才喝一囗，里面还有很多气，平时没舍得喝，一直放在冰箱里、九成新，假一罚十，真心好喝，一小口透心凉，心飞杨， 价格私聊，买不起别吱声，支付方式有微信转帐支付宝，四大银行。谁都有急用钱时，谁也别笑话谁，我的雪碧是正宗的，我就在线等……");
		jokeList.add("\"大爷，您是个卖水泥的，找了个大妈却这么漂亮，说说你和大妈的故事吧。\"“我也不知道你大妈咋看上我的，那年情人节，我卖完水泥，路过一家黄金首饰店， 进去看看热闹，你大妈在里面当销售员。我就习惯性地问了一句：“这玩意多少钱一吨...”后来我们就结婚了…结果结婚以后，一吵架她就骂我装逼  ");
		jokeList.add("在外面遛狗，忽然跳出一杀手把狗杀死。我问道：为什么杀死我的狗，杀手答：有人买你的狗命。我高兴的问到：你语文老师是谁？我给他包个红包。后来越聊越投机。杀手忽然问到:女朋友哪里人？我说到：还没女朋友呢；杀手忽然就把刀子捅过来，嘴里还说到:单身狗也是狗！");
		jokeList.add("项羽被刘邦紧紧围在垓下，陷入困境。 夜间项羽听见四面响起了楚歌，大惊道：“是谁在唱歌！” 虞姬一愣：“温…温暖了寂寞？”");
		jokeList.add("今天跟老妹看 NBA，这丫头突然问我：老哥，你微信上跟其他女孩聊天都称呼她们妹纸，跟我聊天都是妹子，有什么区别，是不是觉着我比她们都重要？我瞥了她一眼说：纸是可以捅破的…… ");
		jokeList.add("沙僧是个细心的人，他整理大师兄的内裤，发现有个洞，然后就耐心的缝了起来；第二天又有个洞，于是又补了起来；第三天依旧还是有个洞，正当他拿起针线时， 猴哥过来，壹脚踹飞了沙僧。你TM把洞缝上，我尾巴搁哪儿，搁哪儿？是不是欠，是不是欠？这个故事告诉我们你的付出不是所有人都能接受。");
		jokeList.add("今天上午，金正恩将军在朝外记者陪同下 视察朝鲜航天局时宣布：10年内，要让朝鲜宇航员登陆太阳！ 一位美国记者问 道，太阳温度那么高你们怎么登上去呢？ 顿时全场鸦雀无声。大家不知道该怎样回 答这个问题。 这时金将军缓缓说道，我们天黑去！顿时全场朝鲜人响起雷鸣般的 掌声…… 正在看电视直播的奥巴马，冷笑 着对周围的同僚说：\"这二货，天黑了根本没太阳！\" 白宫内也响起了雷鸣般的掌声。");
		jokeList.add("在发廊洗头，跟洗头妹子聊得很投缘。正想问是否有更深入地了解项目，又怕妹子正经人，给她留下不好的印象。正犹豫时，进来一大叔，直言想跟妹子发生着关 系，问要多少钱。妹子很气愤地骂：死变态，臭流氓，给老娘滚远点！大叔很无奈地走了，我为缓和气氛，说：这人一把年纪了，真不知廉耻！妹子说：就是。他不 但年纪大，玩法还很变态，最重要的是玩了还不给钱！简直就是流氓！ ");
		int size = jokeList.size();
		return setContent(message, jokeList.get(RandomUtils.nextInt(1, 100)%(size-1)));
	}
}
