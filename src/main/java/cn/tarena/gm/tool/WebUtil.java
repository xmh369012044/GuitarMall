package cn.tarena.gm.tool;

public class WebUtil {
	/**
	 * 
	 * @param value
	 * @return 为空则返回true
	 */
	public static boolean check(String value){
		return value==null||"".equals(value.trim());
	}
	
	
}
