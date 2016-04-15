package org.linuxsogood.weixin.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.linuxsogood.weixin.entity.WxMessageText;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @see org.linuxsogood.weixin.utils.MessageUtils
 * @version	V0.0.1-SNAPSHOT, 2015年6月9日 上午11:44:05
 * @description 微信消息文本转换工具
 * 
 */
public class MessageUtils {

	/**
	 * @description 从请求中读取微信推送过来的消息内容,消息内容是xml格式的,所以需要把消息转换为map格式来处理
	 * @param request HTTP请求体
	 * @return 返回转换为map的结果
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Map<String,String> xmlToMap(HttpServletRequest request) throws DocumentException, IOException {
		//创建一个用于保存转换数据的map
		Map<String,String> map = new HashMap<String, String>();
		//创建一个sax的解析器
		SAXReader reader = new SAXReader();
		//使用解析器从请求流中获取文档
		Document document = reader.read(request.getInputStream());
		//获取文档的根元素
		Element rootElement = document.getRootElement();
		//拿到根元素后获取整个文档的内容
		List<Element> list = rootElement.elements();
		//遍历文档的所有内容并放入map中
		for (Element element : list) {
			map.put(element.getName(), element.getText());
		}
		return map;
	}

	/**
	 * 文本消息对象转换成xml
	 *
	 * @param textMessage 文本消息对象
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
				// 对所有xml节点的转换都增加CDATA标记
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
