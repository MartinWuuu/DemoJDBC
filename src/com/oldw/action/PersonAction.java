package com.oldw.action;

import java.sql.SQLException;
import java.util.List;

import com.oldw.dao.PersonDAO;
import com.oldw.model.Person;

public class PersonAction {

	
	
	public static void main(String[] args) throws SQLException {
		
		PersonDAO p = new PersonDAO();
		
		
//		添加
//		Person newPerson = new Person("小丽",20,"天津市");
//		p.addPerson(newPerson);
		
//		查询
//		Person person = p.query(6);
//		person.setName("Lucy");
//		person.setAge(19);
//		person.setAddress("USA");
		
//		修改
//		p.updatePerson(person);
		
//		删除
//		p.delPerson(4);

//		查询全部
		List<Person> list =  p.queryAll();
		for(Person pn : list){
			System.out.println(pn.getId()+","+pn.getName()+","+pn.getAge()+","+pn.getAddress());
		}
	}
	
}
