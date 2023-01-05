package com.tjhq.wsjrj.mjz.importbase.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理工具类
 * @author yuming
 *
 */
public class StringHandleUtil {
	
	/**
	 * 获取异常信息
	 * @param e
	 * @param length	null获取全部，指定长度时会根据长度进行截取，可以防止超长
	 * @return
	 */
	public static String getExceptMsg(Throwable e, Integer length) {
		String msg = e.getMessage();
		if(EmptyUtil.isEmpty(msg)) {
			try {
				msg = e.getStackTrace()[0].toString();
			} catch (Exception e2) {
				StringWriter result = new StringWriter();
				PrintWriter print = new PrintWriter(result);
				e.printStackTrace(print);
				msg = result.getBuffer().toString();
			}
		}
//		if(msg.indexOf(MsgUtil.getMsg("common_exp_type")) < 0) {
//			msg = MsgUtil.getMsg("common_exp_type") + " : " + e.getClass().getSimpleName() + "; " + MsgUtil.getMsg("common_exp_msg") + " : " + msg;
//		}
    	return getMsgByLength(msg, length);
	}
	
	/**
	 * 信息截取，防止信息超长保存失败
	 * @param msg
	 * @param length
	 * @return
	 */
	public static String getMsgByLength(String msg, Integer length) {
		if(length == null) {
			return msg;
		}
		
		int msgLength = msg.length();
    	if(msgLength >= length) {
    		msgLength = length-1;
    	}
    	return msg.substring(0, msgLength);
	}

	/**
	 * 字符串中提取出整数
	 * @param str
	 * @return
	 */
	public static Integer collectInteger(String str) {
		String regEx="[^0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		try {
			return Integer.parseInt(m.replaceAll("").trim());
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 去除子字符串后，再去除前后空格
	 * @param str
	 * @param sonStr
	 * @return
	 */
	public static String removeSonStr(String str, String sonStr) {
		str = str.replaceAll(sonStr, "");
		return str.trim();
	}
	
	/**
	 * 生成指定长度验证码
	 * @param length	验证码长度
	 * @param isOnlyNumber	是否存数字验证码，为true时生成存数字的验证码
	 * @return
	 */
	public static String createIndentifyCodeByLength(int length, boolean isOnlyNumber) {
		String[] codeArraryWithStr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
	               "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
	               "A","B","C","D","E","F","G","H","I","J", "K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
	               };
		String[] codeArraryOnlyNumber = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		String[] verificationCodeArrary;
		if(isOnlyNumber) {	//纯数字验证码
			verificationCodeArrary = codeArraryOnlyNumber;
		} else {
			verificationCodeArrary = codeArraryWithStr;
		}
		
        String verificationCode = "";
        Random random = new Random();
        for(int i=0; i<length; i++) {
        	verificationCode += verificationCodeArrary[random.nextInt(verificationCodeArrary.length)];
        }
        return verificationCode;
	}
	
	/**
	 * obj转字符串，如果为null，返回空字符串
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		if(EmptyUtil.isEmpty(obj)) {
			return "";
		} else {
			return obj.toString().trim();
		}
	}
}
