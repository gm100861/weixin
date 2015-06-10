package org.linuxsogood.weixin.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.linuxsogood.weixin.entity.WxMessageText;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 
 * @see org.linuxsogood.weixin.utils.MessageUtils
 * @version	V0.0.1-SNAPSHOT, 2015��6��9�� ����11:44:05
 * @description ΢����Ϣ�ı�ת������
 * 
 */
public class MessageUtils {

	/**
	 * @description �������ж�ȡ΢�����͹�������Ϣ����,��Ϣ������xml��ʽ��,������Ҫ����Ϣת��Ϊmap��ʽ������
	 * @param request HTTP������
	 * @return ����ת��Ϊmap�Ľ��
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Map<String,String> xmlToMap(HttpServletRequest request) throws DocumentException, IOException {
		//����һ�����ڱ���ת�����ݵ�map
		Map<String,String> map = new HashMap<String, String>();
		//����һ��sax�Ľ�����
		SAXReader reader = new SAXReader();
		//ʹ�ý��������������л�ȡ�ĵ�
		Document document = reader.read(request.getInputStream());
		//��ȡ�ĵ��ĸ�Ԫ��
		Element rootElement = document.getRootElement();
		//�õ���Ԫ�غ��ȡ�����ĵ�������
		List<Element> list = rootElement.elements();
		//�����ĵ����������ݲ�����map��
		for (Element element : list) {
			map.put(element.getName(), element.getText());	
		}
		return map;
	}
	
	/**
	/**
	 * �ı���Ϣ����ת����xml
	 * 
	 * @param textMessage �ı���Ϣ����
	 * @return xml
	 */
	public static String textMessageToXml(WxMessageText textMessage) {
		XStream x = new XStream();
		x.alias("xml", textMessage.getClass());
		return x.toXML(textMessage);
	}
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// ������xml�ڵ��ת��������CDATA���
				boolean cdata = true;

				@SuppressWarnings("unchecked")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
					if(name.equals("CreateTime")){
						cdata = false;
					}
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
}
