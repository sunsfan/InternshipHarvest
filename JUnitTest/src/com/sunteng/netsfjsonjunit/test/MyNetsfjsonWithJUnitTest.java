package com.sunteng.netsfjsonjunit.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class MyNetsfjsonWithJUnitTest {
	// JavaBean to Json
	//@Test
	public void JavaBeanToJson() {
		PersonBean person = new PersonBean(1, "zhanglu", "Hubei");
		JSONObject json = JSONObject.fromObject(person);
		System.out.println(json);
	}

	// Json to JavaBean
	//@Test
	public void JsonToJavaBean() {
		String json = "{'id':1,'address':'Hubei','name':'zhanglu'}";
		PersonBean person = (PersonBean) JSONObject.toBean(JSONObject.fromObject(json), PersonBean.class);
		System.out.println(person);
		// Console result:This is person, id = 1, name = zhanglu, address =
		// Hubei
	}

	// List<JavaBean> to Json
	//@Test
	public void ListToJson() {
		List<PersonBean> personlist = new ArrayList<PersonBean>();
		personlist.add(new PersonBean(1, "zhanglu", "Hubei"));
		personlist.add(new PersonBean(2, "maomao", "Hebei"));
		String jsonString = JSONArray.fromObject(personlist).toString();
		System.out.println(jsonString);
		// Console
		// result:[{"id":1,"address":"Hubei","name":"zhanglu"},{"id":2,"address":"Hebei","name":"maomao"}]
	}

	// JsonString to List<JavaBean>
	@SuppressWarnings("unchecked")
	//@Test
	public void JsonStringToList() {
		String jsonString = "[{'id':1,'address':'Hubei','name':'zhanglu'},{'id':2,'address':'Hebei','name':'maomao'}]";
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		// List<PersonBean> list = JSONArray.toList(jsonArray, objectClass);过时
		List<PersonBean> list = JSONArray.toList(jsonArray, new PersonBean(), new JsonConfig());
		for (PersonBean person : list) {
			System.out.println(person);
		}
	}

	// Array to Json
	//@Test
	public void ArrayToJson() {
		Object[] obj = new Object[] { new PersonBean(1, "zhanglu", "Hubei"), new PersonBean(2, "maomao", "Hebei") };
		String jsonString = JSONArray.fromObject(obj).toString();
		System.out.println(jsonString);
	}

	// Json to Array
	//@Test
	public void JsonToArray() {
		String jsonString = "[{'id':1,'address':'Hubei','name':'zhanglu'},{'id':2,'address':'Hebei','name':'maomao'}]";
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		Object[] obj = (Object[]) JSONArray.toArray(jsonArray, PersonBean.class);
		for (int i = 0; i < obj.length; i++) {
			System.out.println((PersonBean) obj[i]);
		}
	}

	// Map to Json
	//@Test
	public void MapToJson() {
		Map<String, PersonBean> map = new HashMap<String, PersonBean>();
		map.put("person1", new PersonBean(1, "zhanglu", "Hubei"));
		map.put("person2", new PersonBean(2, "maomao", "Hebei"));
		String json = JSONObject.fromObject(map).toString();
		System.out.println(json);
	}

	// Json to map
	//@Test
	public void JsonToMap() {
		String jsonStr = "{'person1':{'id':1,'address':'Hubei','name':'zhanglu'},'person2':{'id':2,'address':'Hebei','name':'maomao'}}";
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		Map<String, PersonBean> map = new HashMap<String, PersonBean>();
		for (Iterator<?> iter = jsonObject.keys(); iter.hasNext();) {
			String key = (String) iter.next();
			map.put(key, (PersonBean) JSONObject.toBean((JSONObject) jsonObject.get(key), PersonBean.class));
		}
		for (String key : map.keySet()) {
			System.out.println((PersonBean) map.get(key));
		}
	}

	// Reference, ClassInfoBean ===> StudentBean or ClassInfoBean <===
	// StudentBean
	//@Test
	public void ReferenceToJson() {
		ClassInfoBean classInfo1 = new ClassInfoBean(1, "Java_1");
		ClassInfoBean classInfo2 = new ClassInfoBean(2, "Java_2");
		StudentInfo student1 = new StudentInfo(1, "zhanglu", classInfo1);
		StudentInfo student2 = new StudentInfo(2, "wukang", classInfo1);
		StudentInfo student3 = new StudentInfo(3, "maomao", classInfo2);
		List<StudentInfo> stulist = new ArrayList<StudentInfo>();
		stulist.add(student1);
		stulist.add(student2);
		stulist.add(student3);
		String jsonString = JSONArray.fromObject(stulist).toString();
		System.out.println(jsonString);
		// Console result:
		// [{"id":1,"classInfo":{"classId":1,"className":"Java_1"},"stuName":"zhanglu"},
		// {"id":2,"classInfo":{"classId":1,"className":"Java_1"},"stuName":"wukang"},
		// {"id":3,"classInfo":{"classId":2,"className":"Java_2"},"stuName":"maomao"}]
	}

	// references to bean
	@SuppressWarnings("unchecked")
	//@Test
	public void RefrenceToBean() {
		String json = "[{'id':1,'classInfo':{'classId':1,'className':'Java_1'},'stuName':'zhanglu'},{'id':2,'classInfo':{'classId':1,'className':'Java_1'},'stuName':'wukang'},{'id':3,'classInfo':{'classId':2,'className':'Java_2'},'stuName':'maomao'}]";
		JSONArray jsonArray = JSONArray.fromObject(json);
		List<StudentInfo> list = JSONArray.toList(jsonArray, new StudentInfo(), new JsonConfig());
		for (StudentInfo stu : list) {
			System.out.println(stu);
		}
		// Console result:
		// This is a student , id = 1, name = zhanglu,ClassInfo: className =
		// Java_1
		// This is a student , id = 2, name = wukang,ClassInfo: className =
		// Java_1
		// This is a student , id = 3, name = maomao,ClassInfo: className =
		// Java_2
	}

	// Error Reference Animail <==> Cat
	//@Test
	public void ErrorReferemce() {
		Animal animal = new Animal();
		animal.setId(1);
		animal.setName("猫");
		List<Cat> catlist = new ArrayList<Cat>();
		catlist.add(new Cat(1, "MiMi", animal));
		catlist.add(new Cat(2, "喵喵", animal));
		catlist.add(new Cat(3, "CiCi", animal));
		animal.setCatlist(catlist);// 双向
		String json = JSONArray.fromObject(animal).toString();
		System.out.println(json);
		// net.sf.json.JSONException: There is a cycle in the hierarchy!
		// 双向引用会出现死循环. 如果没有异常, 这也是一个错误的结果, 导致json数据庞大 , 可能会出现内存溢出
	}

	// References filter JsonConfig
	//@Test
	public void ReferencesFiterJsonConfig() {
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter() {
			@Override
			public boolean apply(Object source, String name, Object value) {
				return name.equals("catlist");// 设置过滤catlist集合
			}
		});
		Animal animal = new Animal();
		animal.setId(1);
		animal.setName("猫");
		List<Cat> catlist = new ArrayList<Cat>();
		catlist.add(new Cat(1, "MiMi", animal));
		catlist.add(new Cat(2, "喵喵", animal));
		catlist.add(new Cat(3, "CiCi", animal));
		animal.setCatlist(catlist);// 双向
		String json = JSONArray.fromObject(animal, config).toString();// 引用配置对象
		System.out.println(json);
		// Console result:[{"id":1,"name":"猫"}]
	}

	// References filter
	//@Test
	public void setFilterProperty() {
		Animal animal = new Animal();
		animal.setId(1);
		animal.setName("猫");
		List<Cat> catlist = new ArrayList<Cat>();
		catlist.add(new Cat(1, "MiMi", animal));
		catlist.add(new Cat(2, "喵喵", animal));
		catlist.add(new Cat(3, "CiCi", animal));
		animal.setCatlist(catlist);// 双向
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "catlist" });
		String json = JSONArray.fromObject(animal, config).toString();// 引用配置对象
		System.out.println(json);
		// Console result:[{"id":1,"name":"猫"}]
	}
}
