package com.oldw.action;

import java.sql.SQLException;
import java.util.List;

import com.oldw.dao.PersonDAO;
import com.oldw.model.Person;

public class PersonAction {

	
	
	public static void main(String[] args) throws SQLException {
		
		PersonDAO p = new PersonDAO();
		
		
//		���
//		Person newPerson = new Person("С��",20,"�����");
//		p.addPerson(newPerson);
		
//		��ѯ
//		Person person = p.query(6);
//		person.setName("Lucy");
//		person.setAge(19);
//		person.setAddress("USA");
		
//		�޸�
//		p.updatePerson(person);
		
//		ɾ��
//		p.delPerson(4);

//		��ѯȫ��
		List<Person> list =  p.queryAll();
		for(Person pn : list){
			System.out.println(pn.getId()+","+pn.getName()+","+pn.getAge()+","+pn.getAddress());
		}
	}
	
}
