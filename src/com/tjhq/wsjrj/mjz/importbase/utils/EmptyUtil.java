package com.tjhq.wsjrj.mjz.importbase.utils;

import java.util.Collection;

/**
 * 空判断工具类，返回true时为空，false为非空
 * @author yuming
 *
 */
public class EmptyUtil {
	
	/**
	 * 对象空判断，为空时返回true
	 * @param object
	 * @return
	 */
	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}
		if (object.toString().trim().equals("")) {
			return true;
		}
        return object.toString().trim().equals("null");
    }
	
	/**
	 * 对象非空判断，非空时返回true
	 * @param object
	 * @return
	 */
	public static boolean isNotEmpty(Object object) {
        return object != null && !object.toString().trim().equals("") && !object.toString().trim().equals("null");
    }
	
	/**
	 * 判断list、set、map等集合对象是否为空，为空时返回true
	 * @param collection
	 * @return
	 */
	public static <T> boolean isEmpty(Collection<T> collection) {
		if(collection == null) {
			return true;
		}
        return collection.isEmpty();
    }
	
	/**
	 * 判断list、set、map等集合对象是否非空，非空时返回true
	 * @param collection
	 * @return
	 */
	public static <T> boolean isNotEmpty(Collection<T> collection) {
        return collection != null && !collection.isEmpty();
    }

}
