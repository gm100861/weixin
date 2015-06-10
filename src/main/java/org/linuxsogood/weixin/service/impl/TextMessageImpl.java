/**
 * linuxsogood.org
 * Copyright (c) 2014-2024 GaoXin,Inc.All Rights Reserved.
 */
package org.linuxsogood.weixin.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author gm100861, </br> gm100861@gmail.com
 * @see org.linuxsogood.weixin.service.impl.TextMessageImpl
 * @version	V0.0.1-SNAPSHOT, 2015��6��10�� ����1:14:22
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
		log.info("��Ϣ����ɹ�:"+message.getMsgId());
		return MessageUtils.textMessageToXml(text);
	}

	@Override
	public String testMessage(WxMessageText message) {
		WxMessageText text = new WxMessageText();
		text.setFromUserName(message.getToUserName());
		text.setToUserName(message.getFromUserName());
		text.setMsgType(WxMessageType.TEXT);
		text.setCreateTime(new Date().getTime()+"");
		text.setContent("���յ����㷢��������Ϣ,��Ϣ����Ϊ:"+message.getContent());
		text.setMsgId(message.getMsgId());
		log.info("��Ϣ����ɹ�:"+message.getMsgId());
		return MessageUtils.textMessageToXml(text);
	}

	@Override
	public String unknowMessage(WxMessageText message) {
		WxMessageText text = new WxMessageText();
		text.setFromUserName(message.getToUserName());
		text.setToUserName(message.getFromUserName());
		text.setMsgType(WxMessageType.TEXT);
		text.setCreateTime(new Date().getTime()+"");
		text.setContent("δ֪��ѡ��:"+message.getContent());
		text.setMsgId(message.getMsgId());
		log.info("��Ϣ����ɹ�:"+message.getMsgId());
		return MessageUtils.textMessageToXml(text);
	}

	@Override
	public String subscribe(WxMessageText message) {
		StringBuffer sb = new StringBuffer();
		sb.append("��ӭ��ע�ҵĶ��ĺ�,�������������ָ���ȡ����Ҫ����Ϣ:\r\n");
		sb.append("1:��ȡ�Ϻ��������\r\n");
		sb.append("2:����Ц��\r\n");
		sb.append("?:���ڱ����ĺ�");
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
			sb.append(weather.getCity()+"������������:\r\n");
			sb.append("�Ϻ��н���:"+weather.getWeather());
			sb.append("\r\n�������"+weather.getTemp2());
			sb.append("\r\n�������"+weather.getTemp1());
			sb.append("���������������й�������,����ʱ��:"+weather.getPtime());
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
		jokeList.add("����Ա����ʦ����ѧ�� hello world ��ˮ�ɻ��������Լ�����������ϵͳ��ϣ����ʦָ�㡣��ʦЦ�����ץ��һֻ�����ڼ����ϲ����ߣ���һ���ߣ����������������������������ߣ���ʦ��һ������ �ֵ�������˷����˴�֮�ࡣ����Ա�������򣺡���ʦ�����ð��۲��ӣ��ٽ�����������ʦһЦ����С���ӣ��������������˵�����");
		jokeList.add("��������ʦ�����ҵ�ͬ�¶���Java����ȴֻ��JavaScript�����Ƕ������ң��Ҹ���ô�죿�� ��ʦЦ������ó�һ�����أ����˻Ρ� ����Ŀ������ΪC�ֱ�������ͦ��ģ����򵽣�����ʦ����˼�����ҿ��Ϊ������������һ���ʶ���� ��ʦ̾�˿�����˵������TM������ѧC!��");
		jokeList.add("���˼���Ǯת�ð�ƿѩ���ϸ���9����ģ��ź�һ�����滹�кܶ�����ƽʱû��úȣ�һֱ���ڱ�����ų��£���һ��ʮ�����ĺúȣ�һС��͸�������ķ�� �۸�˽�ģ������֨����֧����ʽ��΢��ת��֧�������Ĵ����С�˭���м���Ǯʱ��˭Ҳ��Ц��˭���ҵ�ѩ�������ڵģ��Ҿ����ߵȡ���");
		jokeList.add("\"��ү�����Ǹ���ˮ��ģ����˸�����ȴ��ôƯ����˵˵��ʹ���Ĺ��°ɡ�\"����Ҳ��֪�������զ�����ҵģ��������˽ڣ�������ˮ�࣬·��һ�һƽ����ε꣬ ��ȥ�������֣�����������浱����Ա���Ҿ�ϰ���Ե�����һ�䣺�����������Ǯһ��...���������Ǿͽ���ˡ��������Ժ�һ������������װ��  ");
		jokeList.add("�������޹�����Ȼ����һɱ�ְѹ�ɱ�������ʵ���Ϊʲôɱ���ҵĹ���ɱ�ִ���������Ĺ������Ҹ��˵��ʵ�����������ʦ��˭���Ҹ����������������Խ��ԽͶ����ɱ�ֺ�Ȼ�ʵ�:Ů���������ˣ���˵������ûŮ�����أ�ɱ�ֺ�Ȼ�Ͱѵ���ͱ���������ﻹ˵��:����Ҳ�ǹ���");
		jokeList.add("�����������Χ�����£����������� ҹ�������������������˳��裬�󾪵�������˭�ڳ��裡�� �ݼ�һ㶣����¡���ů�˼�į����");
		jokeList.add("��������ÿ� NBA����ѾͷͻȻ���ң��ϸ磬��΢���ϸ�����Ů�����춼�ƺ�������ֽ���������춼�����ӣ���ʲô�����ǲ��Ǿ����ұ����Ƕ���Ҫ����Ƴ����һ��˵��ֽ�ǿ���ͱ�Ƶġ��� ");
		jokeList.add("ɳɮ�Ǹ�ϸ�ĵ��ˣ��������ʦ�ֵ��ڿ㣬�����и�����Ȼ������ĵķ����������ڶ������и����������ֲ������������������ɻ����и�������������������ʱ�� ��������Ҽ���߷���ɳɮ����TM�Ѷ����ϣ���β�͸��Ķ������Ķ����ǲ���Ƿ���ǲ���Ƿ��������¸���������ĸ������������˶��ܽ��ܡ�");
		jokeList.add("�������磬�����������ڳ��������ͬ�� �Ӳ쳯�ʺ����ʱ������10���ڣ�Ҫ�ó����Ա��½̫���� һλ���������� ����̫���¶���ô��������ô����ȥ�أ� ��ʱȫ��ѻȸ��������Ҳ�֪���������� ��������⡣ ��ʱ�𽫾�����˵�����������ȥ����ʱȫ������������������� �������� ���ڿ�����ֱ���İ°�����Ц �Ŷ���Χ��ͬ��˵��\"�����������˸���û̫����\" �׹���Ҳ�������������������");
		jokeList.add("�ڷ���ϴͷ����ϴͷ�����ĵú�ͶԵ���������Ƿ��и�������˽���Ŀ���������������ˣ��������²��õ�ӡ������ԥʱ������һ���壬ֱ��������ӷ����Ź� ϵ����Ҫ����Ǯ�����Ӻ����ߵ������̬������å���������Զ�㣡��������ε����ˣ���Ϊ�������գ�˵������һ������ˣ��治֪���ܣ�����˵�����ǡ����� ����ʹ��淨���ܱ�̬������Ҫ�������˻�����Ǯ����ֱ������å�� ");
		int size = jokeList.size();
		return setContent(message, jokeList.get(RandomUtils.nextInt(1, 100)%(size-1)));
	}
}
