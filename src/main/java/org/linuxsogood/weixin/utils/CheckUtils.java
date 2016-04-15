/**
 * 
 */
package org.linuxsogood.weixin.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author Administrator
 *
 */
public class CheckUtils {
	private static final Logger log = LoggerFactory.getLogger(CheckUtils.class);
	//在微信公众平台中写的token
	private static final String token = "JustJava";
	/**
	 * 加密/校验流程如下：
	 * 	1. 将token、timestamp、nonce三个参数进行字典序排序
	 *	2. 将三个参数字符串拼接成一个字符串进行sha1加密
	 *	3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		try {
			//按照字段进行排序
			String[] arr = {token,timestamp,nonce};
			Arrays.sort(arr);
			//SHA1加密并对比与signature是否一致
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]);
			}
			String encode = EncoderHandler.encode("SHA1", sb.toString());
			return signature.equals(encode);
		} catch (Exception e) {
			if(log.isErrorEnabled()){
				log.error("检验签名的时候出现异常："+e.getMessage());
			}
		}
		return false;
	}
}
