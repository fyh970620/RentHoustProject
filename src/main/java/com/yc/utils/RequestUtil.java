package com.yc.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class RequestUtil {
	
	/**
	 * 工具类：将request中的参数取出，将参数值对应的存到一个clazz生成的对象中
	 * 注意：只能取出request中的参数值是一个的情况，如果是多个值还是用request.getParameterValues("参数名")；
	 * @param request
	 * @param 
	 * @return  clazz对应的对象
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static <T>T parseRequest(  HttpServletRequest request,Class<T> clazz ) throws Exception{
		//将参数值转存成单个值
		Map<String,String[]>maps = request.getParameterMap();
		Map<String,String> m = new HashMap<String,String>();
		for( Map.Entry<String, String[]>entry:maps.entrySet() ){  
			m.put( entry.getKey(),  entry.getValue()[0] );
		}
		return parseRequest( m,clazz);
	}
	
	public static<T> T parseRequest( Map<String,String>m,Class<T> clazz) throws Exception{
		//创建clazz对象，反射实例
		T obj = clazz.newInstance(); // Product p = new Product();  //newInstance()调用无参构造方法
		//取set方法
		List<Method> allSetMethods = getAllSetMethod( clazz); //取所有的set方法
		//循环m,取出每个参数
		for( Map.Entry<String,String>entry:m.entrySet()){
			String parameterName = entry.getKey();
			String parameterValue = entry.getValue();
			
			//取allSetMethods中的方法的方法名
			for(Method method:allSetMethods){
				String methodName=method.getName();  //setPname setPrice
				if(methodName.equalsIgnoreCase( "set" + parameterName) ){
					
					//取到当前的method中的参数的类型，判断是哪一种，再进行类型的转换
					String parameterTypeName=method.getParameterTypes()[0].getName();
					
					if( methodName.equals(parameterTypeName)|| "java.lang.Double".equals(parameterTypeName)){
						double v =Double.parseDouble( parameterValue);
						method.invoke(obj, v);
					}else if("int".equals(parameterTypeName)||"java.lang.Integer".equals(parameterTypeName)){
						int v = Integer.parseInt( parameterValue );
						method.invoke(obj, v);
					}else if("float".equals(parameterTypeName)||"jav.lang.Float".equals(parameterTypeName)){
						float v = Float.parseFloat( parameterValue);
						method.invoke(obj, v);
					}else{
						//激活方法: argument type mismatch
						method.invoke(obj, parameterValue); //price在product类中的double型，但map中price是String类型，所以要类型转换
					}
				}
				
			}
		}
		return obj;
	}
	
	/**
	 * 取出一个类中所有的set方法
	 * @param clazz
	 * @return
	 */
	private static List<Method> getAllSetMethod( Class clazz){
		List<Method> allSetMethods = new ArrayList<Method>();
		Method[] ms = clazz.getMethods();
		for( Method m :ms){
			if(m.getName().startsWith("set")){ //只要set方法
				allSetMethods.add( m);
			}
		}
		return allSetMethods;
		
	}
	
	public static void main(String[] args) throws Exception{
		Map<String,String>map = new HashMap<String,String>();
		map.put("id", 11+"");
		map.put("username", "john");
		map.put("password", "234");
	}
	

}
