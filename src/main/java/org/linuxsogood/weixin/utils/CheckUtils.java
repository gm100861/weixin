/**
 * 
 */
package org.linuxsogood.weixin.utils;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 *
 */
public class CheckUtils {
	private static final Logger log = LoggerFactory.getLogger(CheckUtils.class);
	//��΢�Ź���ƽ̨��д��token
	private static final String token = "JustJava";
	/**
	 * ����/У���������£�
	 * 	1. ��token��timestamp��nonce�������������ֵ�������
	 *	2. �����������ַ���ƴ�ӳ�һ���ַ�������sha1����
	 *	3. �����߻�ü��ܺ���ַ�������signature�Աȣ���ʶ��������Դ��΢��
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		try {
			//�����ֶν�������
			String[] arr = {token,timestamp,nonce};
			Arrays.sort(arr);
			//SHA1���ܲ��Ա���signature�Ƿ�һ��
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]);
			}
			String encode = EncoderHandler.encode("SHA1", sb.toString());
			return signature.equals(encode);
		} catch (Exception e) {
			if(log.isErrorEnabled()){
				log.error("����ǩ����ʱ������쳣��"+e.getMessage());
			}
		}
		return false;
	}
}
