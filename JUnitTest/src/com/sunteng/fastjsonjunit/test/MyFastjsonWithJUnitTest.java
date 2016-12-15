package com.sunteng.fastjsonjunit.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class MyFastjsonWithJUnitTest {

	    // Java bean to json
	    //@Test
	    public void JavaBeanToJson() {
	        Person person = new Person(1, "zhanglu", "Hubei");
	        String json = JSON.toJSONString(person);
	        System.out.println(json);
	    }

	    // Json to Javabean
	    //@Test
	    public void JsonToJavaBean() {
	        String json = "{'address':'Hubei','id':1,'name':'zhanglu'}";
	        Person person = JSON.parseObject(json, Person.class);
	        System.out.println(person);
	    }

	    // List<JavaBean> to json
	    //@Test
	    public void listJavaBeanToJson() {
	        Person p1 = new Person(1, "zhanglu", "Hubei");
	        Person p2 = new Person(2, "wukang", "Hubei");
	        List<Person> personlist = new ArrayList<>();
	        personlist.add(p1);
	        personlist.add(p2);
	        String json = JSON.toJSONString(personlist);
	        System.out.println(json);
	    }

	    // Json to List<JavaBean>
	    //@Test
	    public void JsonToListBean() {
	        String json = "[{'address':'Hubei','id':1,'name':'zhanglu'},{'address':'Hubei','id':2,'name':'wukang'}]";
	        List<Person> persons = JSON.parseArray(json, Person.class);
	        for (Person person : persons) {
	            System.out.println(person);
	        }
	    }

	    // List<String> to json
	    //@Test
	    public void listStringToJson() {
	        List<String> list = new ArrayList<>();
	        list.add("zhanglu");
	        list.add("wukang");
	        String json = JSON.toJSONString(list);
	        System.out.println(json);
	    }

	    // json to List<String>
	    //@Test
	    public void JsonToListString() {
	        String json = "['zhanglu','wukang']";
	        List<String> list = JSON.parseArray(json, String.class);
	        for (String str : list) {
	            System.out.println(str);
	        }
	    }

	    // Map<String,Object> to json
	    //@Test
	    public void MapToJson() {
	        Map<String, Person> map = new HashMap<>();
	        map.put("person1", new Person(1, "zhanglu", "Hubei"));
	        map.put("person2", new Person(2, "wukang", "Hubei"));
	        String json = JSON.toJSONString(map);
	        System.out.println(json);
	    }

	    // Json to Map<String,JavaBean>
	    //@Test
	    public void JsonToMap() {
	        String json = "{'person1':{'address':'Hubei','id':1,'name':'zhanglu'},'person2':{'address':'Hubei','id':2,'name':'wukang'}}";
	        Map<String, Person> map = JSON.parseObject(json,
	                new TypeReference<Map<String, Person>>() {
	                });
	        for (String key : map.keySet()) {
	            System.out.println("key:" + key);
	            System.out.println(map.get(key));
	        }
	    }

	    // Test references javaBean
	    // Animal,Cat
	    //@Test
	    public void TestReferences() {
	        Animal animal = new Animal();
	        animal.setName("animal");
	        Cat cat = new Cat();
	        cat.setId(1);
	        cat.setName("MiMi");
	        Cat cat2 = new Cat();
	        cat2.setId(1);
	        cat2.setName("CiCi");
	        cat.setAnimal(animal);
	        cat2.setAnimal(animal);
	        List<Cat> catlist = new ArrayList<>();
	        catlist.add(cat2);
	        catlist.add(cat);
	        animal.setCatlist(catlist);
	        String json = JSON.toJSONString(animal);
	        System.out.println(json);
	    }

	    // Test references javaBean
	    // Animal,Cat
	    //@Test
	    public void TestReferences2() {
	        Animal animal = new Animal();
	        animal.setName("animial");
	        Cat cat = new Cat();
	        cat.setId(1);
	        cat.setName("MiMi");
	        Cat cat2 = new Cat();
	        cat2.setId(1);
	        cat2.setName("CiCi");
	        cat.setAnimal(animal);
	        cat2.setAnimal(animal);
	        List<Cat> catlist = new ArrayList<>();
	        catlist.add(cat2);
	        catlist.add(cat);
	        animal.setCatlist(catlist);
	        String json = JSON.toJSONString(animal,SerializerFeature.DisableCircularReferenceDetect);
	        System.out.println(json);
	    }

	    // methods 01 transient
	    // @JSONField(serialize=false)
	    
	    // Date to Json
	    @Test
	    public void DateToJson(){
	        StudentInfo studentInfo = new StudentInfo();
	        studentInfo.setBirthday(new Date());
	        studentInfo.setId(1);
	        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
	        String json = JSON.toJSONString(studentInfo,SerializerFeature.WriteDateUseDateFormat);
	        System.out.println(json);
	    }
}
