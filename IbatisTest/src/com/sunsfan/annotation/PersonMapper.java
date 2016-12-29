package com.sunsfan.annotation;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

@CacheNamespace(readWrite = true)
public interface PersonMapper {
	@Select("select * from person where id = #{id}")
	@Options(useCache = true, flushCache = false)
	Person selectById(Integer id);

	@SelectProvider(type = SqlProvider.class, method = "selectAllSql")
	List<Person> selectAll();

	@Select("select * from person where name like #{%name%}")
	List<Person> selectPersonsByName(String name);

	@Insert({ "insert into person(name,birthday,sex)", "values(#{name},#{birthday},#{sex})" })
	void insertPerson(Person person);

	@Delete("delete from person where id = #{id}")
	void deletePerson(Person person);

	@Update({ "update person set name=#{name},birthday=#{birthday},sex=#{sex}", "where id=#{id}" })
	void updatePerson(Person person);
}
