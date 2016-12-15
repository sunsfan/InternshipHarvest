package com.sunteng.gsonjunit.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class MyGsonWithJUnitTest {
	     private Gson gson = new Gson(); 
	   //private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); 
	    //javabean到json字符串
	    //@Test
	    public void beanToJson(){
	        Person person  = new Person();
	        person.setId(1);
	        person.setName("zhanglu");
	        person.setAddress("湖北大悟");
	        System.out.println(gson.toJson(person));
	    }

	    //json字符串到javabean
	    //@Test
	    public void jsonTobean(){
	        String json = "{'id':'1','name':'zhang','address':'Hubei'}";
	        Person person = gson.fromJson(json, Person.class);
	        System.out.println(person);
	    }
	    
	    //bean列表到json
	    //@Test
	    public void listBeanToJson(){
	        Person person1 = new Person(1, "zhang", "Hubei");
	        Person person2 = new Person(2,"lu","DaWu");
	        List<Person> persons = new ArrayList<>();
	        persons.add(person1);
	        persons.add(person2);
	        String json = gson.toJson(persons);
	        System.out.println(json);
	    }
	    
	    //json到bean列表
	    //@Test
	    public void jsonToListBean(){
	        String json = "[{'id':'1','name':'zhang','address':'Hubei'},{'id':'2','name':'lu','address':'DaWu'}]";
	        List<Person> persons = gson.fromJson(json, new TypeToken<List<Person>>(){}.getType());
	        for(Person per : persons){
	            System.out.println(per);
	        }
	    }
	    
	    
	    //字符串列表到json字符串
	    //@Test
	    public void listStringToJson(){
	        List<String> list = new ArrayList<>();
	        list.add("zhanglu");
	        list.add("hubei");
	        list.add("Dawu");
	        String json = gson.toJson(list);
	        System.out.println(json);
	    }
	    
	    //json字符串到字符串列表
	    //@Test
	    public void jsonToListString(){
	        String json = "['zhanglu','hubei','Dawu']";
	        List<String> list = gson.fromJson(json, new TypeToken<List<String>>(){}.getType());
	        for(String str : list){
	            System.out.println(str);
	        }
	    }
	    
	    //Map键值对到json
	    //@Test
	    public void mapToJson(){
	        Map<String, Person> map = new HashMap<>();
	        Person person = new Person(1, "zhanglu", "湖北大悟");
	        Person person2 = new Person(2, "Alone", "HuBeiDaWu");
	        map.put("person", person);
	        map.put("person2", person2);
	        String json = gson.toJson(map);
	        System.out.println(json);
	    }
	    
	    //json到Map键值对
	    //@Test
	    public void jsonToMap(){
	        String json = "{'person':{'id':1,'name':'zhanglu','address':'湖北大悟'},'person2':{'id':2,'name':'Alone','address':'HuBeiDaWu'}}";
	        Map<String, Person> map = gson.fromJson(json, new TypeToken<Map<String,Person>>(){}.getType());
	        for(String str : map.keySet()){
	            System.out.println("key:"+str);
	            System.out.println((Person)map.get(str));
	        }
	    }
	    
	    //引用对象测试
	    //如果双向引用, 会产生死循环, 
	    //方法1: 在需要被过滤的字段上加上修饰符transient, Cat的animal加上了
	    /*//方法2：排除Modifier为指定类型的字段Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.PROTECTED) // <---.create();*/
	    //方法3：使用@Expose注解,注意，没有被 @Expose标注的字段会被排除，如下所示：
	    //@Test
	    public void testReferences(){
	        Animal animal = new Animal();
	        animal.setName("Animal");
	        Cat cat = new Cat();
	        cat.setId(1);
	        cat.setName("Cat1");
	        cat.setAnimal(animal);
	        Cat cat2 = new Cat();
	        cat2.setId(2);
	        cat2.setName("Cat2");
	        cat.setAnimal(animal);
	        List<Cat> cats  = new ArrayList<>();
	        cats.add(cat2);
	        cats.add(cat);
	        animal.setCatlist(cats);
	        String json = gson.toJson(animal);
	        System.out.println(json);
	    }
	    
	    //方法4：使用ExclusionStrategy定制字段排除策略,这种方式最灵活，下面的例子把所有名为classInfo的字段全部都排除掉：
	    @Test
	    public void ExclusionStrategy(){
	        ClassInfo classInfo = new ClassInfo();
	        classInfo.setClassNo("C0001");
	        classInfo.setClassName("Java_1");
	        StudentInfo stu1 = new StudentInfo();
	        stu1.setStuId(1);
	        stu1.setStuName(1);
	        StudentInfo stu2 = new StudentInfo();
	        stu2.setStuId(2);
	        stu2.setStuName(2);
	        stu1.setClassInfo(classInfo);
	        stu2.setClassInfo(classInfo);
	        List<StudentInfo> stulist = new ArrayList<>();
	        stulist.add(stu2);
	        stulist.add(stu1);
	        classInfo.setStudentslist(stulist);
	        ExclusionStrategy myExclusionStrategy = new ExclusionStrategy() {
	              @Override
	              public boolean shouldSkipField(FieldAttributes fa) {
	                  return fa.getName().equals("classInfo");
	              }

	              @Override
	              public boolean shouldSkipClass(Class<?> clazz) {
	                  return false;
	              }
	         };
	        Gson gson = new GsonBuilder().setExclusionStrategies(myExclusionStrategy).create();
	        String json = gson.toJson(classInfo);
	        System.out.println(json);
	    }
}
