package com.boliangshenghe.outteam.util;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtils {

	private static final SerializeConfig mapping;
	private static final SerializerFeature[] features = { SerializerFeature.WriteMapNullValue, // 输出空置字段
			SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
			SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
			SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
			SerializerFeature.WriteNullStringAsEmpty // 字符类型字段如果为null，输出为""，而不是null
	};
	static {
		mapping = new SerializeConfig();
		mapping.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
		mapping.put(Date.class, new JSONLibDataFormatSerializer());
	}

	/**
	 * 由字符串反序列化成实体类 针对的是一个实体，此实体中的属性不包括自定义的类型，如Teacher类型，或者List<Teacher>类型
	 * 
	 * @param source
	 *            传入json中的字符串
	 * @param beanClass
	 *            实体类的类型
	 * @return 实体类
	 */
//	public static Object getObjFromJsonArrStr(String source, Class beanClass) {
//		return JSONObject.parseObject(source, beanClass);
//	}

	/**
	 * 由字符串反序列化成实体类 针对的是一个实体，此实体中的属性包括自定义的类型，如Teacher类型，或者List<Teacher>类型
	 * 
	 * @param jsonArrStr
	 * @param clazz
	 * @param classMap
	 * @return
	 */
	// public static Object getObjFromJsonArrStr(String jsonArrStr, Class clazz,
	// Map classMap) {
	// setDataFormat2JAVA();
	// JSONObject jsonObj = JSONObject.fromObject(jsonArrStr);
	// return JSONObject.toBean(jsonObj, clazz, classMap);
	// }

	/**
	 * 将string转换成listBean
	 * 
	 * @param jsonArrStr
	 *            需要反序列化的字符串
	 * @param clazz
	 *            被反序列化之后的类
	 * @return 实体list
	 */
	public static <T> List<T> getListFromJsonArrStr(String jsonArrStr, Class<T> clazz) {
		// setDataFormat2JAVA();
		return JSONArray.parseArray(jsonArrStr, clazz);
		// List list = new ArrayList();
		// for (int i = 0; i < jsonArr.size(); i++) {
		// list.add(JSONObject.toBean(jsonArr.getJSONObject(i), clazz));
		// }
		// return list;
	}

	/**
	 * 将string转换成listBean 属性中包含实体类等 如List<Student> 而Student中含有属性List<Teacher>
	 * 
	 * @param jsonArrStr
	 *            需要反序列化的字符串
	 * @param clazz
	 *            反序列化后的类
	 * @param classMap
	 *            将属性中包含的如Teacher加入到一个Map中，格式如map.put("teacher",Teacher.class)
	 * @return 反序列化后的字符串 使用示例： Map classMap = new HashMap(); //必须要对Parent进行初始化
	 *         否则不识别 Teacher p = new Teacher(); classMap.put("teacher",
	 *         p.getClass()); List mlist =
	 *         JSONTransfer.getListFromJsonArrStr(resultStr, Student.class,
	 *         classMap);
	 */
//	public static List getListFromJsonArrStr(String jsonArrStr, Class clazz, Map classMap) {
//		JSONArray jsonArr = JSONArray.fromObject(jsonArrStr);
//		List list = new ArrayList();
//		for (int i = 0; i < jsonArr.size(); i++) {
//			list.add(JSONObject.toBean(jsonArr.getJSONObject(i), clazz, classMap));
//		}
//		return list;
//	}

	// private static void setDataFormat2JAVA() {
	// // 设定日期转换格式
	// JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new
	// String[] { "yyyy-MM-dd HH:mm:ss" }));
	// }

	/***
	 * 将List对象序列化为JSON文本
	 */
	public static <T> String toJSONString(List<T> list) {

		return JSONArray.toJSONString(list, mapping, features);
	}
	/***
	 * 将List对象序列化为JSON文本
	 */
	public static <T> String toJSONStringNoMapping(List<T> list) {

		return JSONArray.toJSONString(list, features);
	}
	
	/***
	 * 将object对象序列化为JSON文本
	 */
	public static <T> String objtoJSONString(Object obj) {

		return JSONArray.toJSONString(obj, features);
	}

	/***
	 * 将JSON对象序列化为JSON文本
	 * 
	 * @param jsonObject
	 * @return
	 */
	public static String toJSONString(JSONObject jsonObject) {
		return jsonObject.toString();
	}
	
	/**
	 * object 转为json
	 * 
	 * @Description : 方法描述
	 * @Method_Name : toJson
	 * @param obj
	 * @return
	 * @Update Author : leonlau
	 */
	public static String toJson(Object obj) {
		return JSON.toJSONString(obj, mapping, features);
		
	}

	/***
	 * 将对象转换为List对象
	 * 
	 * @param object
	 * @return
	 */
//	public static List toArrayList(Object object) {
//		
//		return  JSON.parseArray(JSON.toJSONString(object));
////		List arrayList = new ArrayList();
////
////		JSONArray jsonArray = JSONArray.fromObject(object);
////
////		Iterator it = jsonArray.iterator();
////		while (it.hasNext()) {
////			JSONObject jsonObject = (JSONObject) it.next();
////
////			Iterator keys = jsonObject.keys();
////			while (keys.hasNext()) {
////				Object key = keys.next();
////				Object value = jsonObject.get(key);
////				arrayList.add(value);
////			}
////		}
//
////		return arrayList;
//	}

	/***
	 * 将对象转换为Collection对象
	 * 
	 * @param object
	 * @return
	 */
//	public static Collection toCollection(Object object) {
//		JSONArray jsonArray = JSONArray.fromObject(object);
//
//		return JSONArray.toCollection(jsonArray);
//	}

	/***
	 * 将对象转换为JSON对象数组
	 * 
	 * @param object
	 * @return
	 */
//	public static JSONArray toJSONArray(Object object) {
//		return JSONArray.fromObject(object);
//	}

	/***
	 * 将对象转换为JSON对象
	 * 
	 * @param object
	 * @return
	 */
//	public static JSONObject toJSONObject(Object object) {
//		return JSONObject.fromObject(object);
//	}

	/***
	 * 将对象转换为HashMap
	 * 
	 * @param object
	 * @return
	 */
//	public static HashMap toHashMap(Object object) {
//		HashMap<String, Object> data = new HashMap<String, Object>();
//		JSONObject jsonObject = JsonUtils.toJSONObject(object);
//		Iterator it = jsonObject.keys();
//		while (it.hasNext()) {
//			String key = String.valueOf(it.next());
//			Object value = jsonObject.get(key);
//			data.put(key, value);
//		}
//
//		return data;
//	}

	/***
	 * 将对象转换为List<Map<String,Object>>
	 * 
	 * @param object
	 * @return
	 */
	// 返回非实体类型(Map<String,Object>)的List
//	public static List<Map<String, Object>> toList(Object object) {
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		JSONArray jsonArray = JSONArray.fromObject(object);
//		for (Object obj : jsonArray) {
//			JSONObject jsonObject = (JSONObject) obj;
//			Map<String, Object> map = new HashMap<String, Object>();
//			Iterator it = jsonObject.keys();
//			while (it.hasNext()) {
//				String key = (String) it.next();
//				Object value = jsonObject.get(key);
//				map.put((String) key, value);
//			}
//			list.add(map);
//		}
//		return list;
//	}

	/***
	 * 将JSON对象数组转换为传入类型的List
	 * 
	 * @param <T>
	 * @param jsonArray
	 * @param objectClass
	 * @return
	 */
//	@SuppressWarnings("deprecation")
//	public static <T> List<T> toList(JSONArray jsonArray, Class<T> objectClass) {
//		return JSONArray.toList(jsonArray, objectClass);
//	}

	/***
	 * 将对象转换为传入类型的List
	 * 
	 * @param <T>
	 * @param jsonArray
	 * @param objectClass
	 * @return
	 */

	public static <T> List<T> toList(Object object, Class<T> objectClass) {
		if(object instanceof String){
			return JSON.parseArray(object.toString(), objectClass);
		}
		return JSON.parseArray(JSON.toJSONString(object), objectClass);
//		JSONArray jsonArray = JSONArray.fromObject(object);
//
//		return JSONArray.toList(jsonArray, objectClass);
	}

	/***
	 * 将JSON对象转换为传入类型的对象
	 * 
	 * @param <T>
	 * @param jsonObject
	 * @param beanClass
	 * @return
	 */
//	public static <T> T toBean(JSONObject jsonObject, Class<T> beanClass) {
//		return (T) JSONObject.toBean(jsonObject, beanClass);
//	}

	/***
	 * 将将对象转换为传入类型的对象
	 * 
	 * @param <T>
	 * @param object
	 * @param beanClass
	 * @return
	 */
	public static <T> T toBean(Object object, Class<T> beanClass) {
		if(object instanceof String){
			return JSONObject.parseObject(object.toString(), beanClass);
		}
		return JSONObject.parseObject(JSON.toJSONString(object), beanClass);
	}

	/***
	 * 将JSON文本反序列化为主从关系的实体
	 * 
	 * @param <T>
	 *            泛型T 代表主实体类型
	 * @param <D>
	 *            泛型D 代表从实体类型
	 * @param jsonString
	 *            JSON文本
	 * @param mainClass
	 *            主实体类型
	 * @param detailName
	 *            从实体类在主实体类中的属性名称
	 * @param detailClass
	 *            从实体类型
	 * @return
	 */
//	public static <T, D> T toBean(String jsonString, Class<T> mainClass, String detailName, Class<D> detailClass) {
//		JSONObject jsonObject = JSONObject.fromObject(jsonString);
//		JSONArray jsonArray = (JSONArray) jsonObject.get(detailName);
//
//		T mainEntity = JsonUtils.toBean(jsonObject, mainClass);
//		List<D> detailList = JsonUtils.toList(jsonArray, detailClass);
//
//		try {
//			BeanUtils.setProperty(mainEntity, detailName, detailList);
//		} catch (Exception ex) {
//			throw new RuntimeException("主从关系JSON反序列化实体失败！");
//		}
//
//		return mainEntity;
//	}

	/***
	 * 将JSON文本反序列化为主从关系的实体
	 * 
	 * @param <T>泛型T 代表主实体类型
	 * @param <D1>泛型D1 代表从实体类型
	 * @param <D2>泛型D2 代表从实体类型
	 * @param jsonString
	 *            JSON文本
	 * @param mainClass
	 *            主实体类型
	 * @param detailName1
	 *            从实体类在主实体类中的属性
	 * @param detailClass1
	 *            从实体类型
	 * @param detailName2
	 *            从实体类在主实体类中的属性
	 * @param detailClass2
	 *            从实体类型
	 * @return
	 */
//	public static <T, D1, D2> T toBean(String jsonString, Class<T> mainClass, String detailName1,
//			Class<D1> detailClass1, String detailName2, Class<D2> detailClass2) {
//		JSONObject jsonObject = JSONObject.fromObject(jsonString);
//		JSONArray jsonArray1 = (JSONArray) jsonObject.get(detailName1);
//		JSONArray jsonArray2 = (JSONArray) jsonObject.get(detailName2);
//
//		T mainEntity = JsonUtils.toBean(jsonObject, mainClass);
//		List<D1> detailList1 = JsonUtils.toList(jsonArray1, detailClass1);
//		List<D2> detailList2 = JsonUtils.toList(jsonArray2, detailClass2);
//
//		try {
//			BeanUtils.setProperty(mainEntity, detailName1, detailList1);
//			BeanUtils.setProperty(mainEntity, detailName2, detailList2);
//		} catch (Exception ex) {
//			throw new RuntimeException("主从关系JSON反序列化实体失败！");
//		}
//
//		return mainEntity;
//	}

	/***
	 * 将JSON文本反序列化为主从关系的实体
	 * 
	 * @param <T>泛型T 代表主实体类型
	 * @param <D1>泛型D1 代表从实体类型
	 * @param <D2>泛型D2 代表从实体类型
	 * @param jsonString
	 *            JSON文本
	 * @param mainClass
	 *            主实体类型
	 * @param detailName1
	 *            从实体类在主实体类中的属性
	 * @param detailClass1
	 *            从实体类型
	 * @param detailName2
	 *            从实体类在主实体类中的属性
	 * @param detailClass2
	 *            从实体类型
	 * @param detailName3
	 *            从实体类在主实体类中的属性
	 * @param detailClass3
	 *            从实体类型
	 * @return
	 */
//	public static <T, D1, D2, D3> T toBean(String jsonString, Class<T> mainClass, String detailName1,
//			Class<D1> detailClass1, String detailName2, Class<D2> detailClass2, String detailName3,
//			Class<D3> detailClass3) {
//		JSONObject jsonObject = JSONObject.fromObject(jsonString);
//		JSONArray jsonArray1 = (JSONArray) jsonObject.get(detailName1);
//		JSONArray jsonArray2 = (JSONArray) jsonObject.get(detailName2);
//		JSONArray jsonArray3 = (JSONArray) jsonObject.get(detailName3);
//
//		T mainEntity = JsonUtils.toBean(jsonObject, mainClass);
//		List<D1> detailList1 = JsonUtils.toList(jsonArray1, detailClass1);
//		List<D2> detailList2 = JsonUtils.toList(jsonArray2, detailClass2);
//		List<D3> detailList3 = JsonUtils.toList(jsonArray3, detailClass3);
//
//		try {
//			BeanUtils.setProperty(mainEntity, detailName1, detailList1);
//			BeanUtils.setProperty(mainEntity, detailName2, detailList2);
//			BeanUtils.setProperty(mainEntity, detailName3, detailList3);
//		} catch (Exception ex) {
//			throw new RuntimeException("主从关系JSON反序列化实体失败！");
//		}
//
//		return mainEntity;
//	}

	/***
	 * 将JSON文本反序列化为主从关系的实体
	 * 
	 * @param <T>
	 *            主实体类型
	 * @param jsonString
	 *            JSON文本
	 * @param mainClass
	 *            主实体类型
	 * @param detailClass
	 *            存放了多个从实体在主实体中属性名称和类型
	 * @return
	 */
//	public static <T> T toBean(String jsonString, Class<T> mainClass, HashMap<String, Class> detailClass) {
//		JSONObject jsonObject = JSONObject.fromObject(jsonString);
//		T mainEntity = JsonUtils.toBean(jsonObject, mainClass);
//		for (Object key : detailClass.keySet()) {
//			try {
//				Class value = (Class) detailClass.get(key);
//				BeanUtils.setProperty(mainEntity, key.toString(), value);
//			} catch (Exception ex) {
//				throw new RuntimeException("主从关系JSON反序列化实体失败！");
//			}
//		}
//
//		return mainEntity;
//	}
}
