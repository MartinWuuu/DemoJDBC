package com.oldw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oldw.db.DBUtils;
import com.oldw.model.Person;


/**
 * Data Access Object 
 * @author Brave
 *
 */
public class PersonDAO {
	
	
	/**
	 * �����ݿ����һ����¼
	 * @param person ����
	 * @return
	 * @throws SQLException
	 */

	public boolean addPerson(Person person) throws SQLException{
		
		Connection conn = DBUtils.getConnection();
		String sql = "insert into person" + "(name,age,address)"+"values(?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, person.getName());
		ptmt.setInt(2, person.getAge());
		ptmt.setString(3, person.getAddress());
		boolean is = ptmt.execute();
		
		
		if(ptmt != null){
			ptmt.close();
		}
		
		if(conn != null){
			conn.close();
		}
		return is;
	}
	
	
	/**
	 * ����һ�����ݿ��¼
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	public boolean updatePerson(Person person) throws SQLException{
		Connection conn = DBUtils.getConnection();
		String sql = " update person " + " set name=?,age=?,address=? "+" where id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, person.getName());
		ptmt.setInt(2, person.getAge());
		ptmt.setString(3, person.getAddress());
		ptmt.setInt(4, person.getId());
		boolean is = ptmt.execute();
		
		if(ptmt != null){
			ptmt.close();
		}
		
		if(conn != null){
			conn.close();
		}
		return is;
	}
	
	
	/**
	 * ɾ��һ����¼
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean delPerson(Integer id) throws SQLException{
		Connection conn = DBUtils.getConnection();
		String sql = " delete from person " + " where id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1,id);
		boolean is = ptmt.execute();
		
		if(ptmt != null){
			ptmt.close();
		}
		
		if(conn != null){
			conn.close();
		}
		return is;
	}
	
	
	/**
	 * ��ȡ���ݿ��е�ǰ������ж���
	 * @return
	 * @throws SQLException
	 */
	public List<Person> queryAll() throws SQLException{
		
		
		List<Person> list = new ArrayList<Person>();
		
		Connection conn = DBUtils.getConnection();
//		��ȡ���ݿ��������
		Statement stmt = conn.createStatement();
		
//		ִ��SQL���
		ResultSet rs = stmt.executeQuery("select * from person");
		
		while(rs.next()){
			Person p = new Person(rs.getString("name"),rs.getInt("age"),rs.getString("address"),rs.getInt("id"));
			list.add(p);
		}
		
//		�ر����Ӷ���
		if(rs != null){
			rs.close();
		}
		
		if(stmt != null){
			stmt.close();
		}
		
		if(conn != null){
			conn.close();
		}
		
		return list;
	}
	
	
	/**
	 * ��ȡһ����¼������
	 * @param id �û�id
	 * @return
	 * @throws SQLException
	 */
	public Person query(Integer id) throws SQLException{
		
		Person person = null;
		Connection conn = DBUtils.getConnection();
		String sql = " select * from person " + " where id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1,id);
		ResultSet rs =  ptmt.executeQuery();
		if(rs.next()){
			person = new Person(rs.getString("name"), rs.getInt("age"), rs.getString("address"),rs.getInt("id"));
		}
		
		if(ptmt != null){
			ptmt.close();
		}
		
		if(conn != null){
			conn.close();
		}
		return person;
	}
	
	
	/**
	 * ͨ���û�����ȡһ����¼
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public Person query(String name) throws SQLException{
		
		Person person = null;
		Connection conn = DBUtils.getConnection();
		String sql = " select * from person " + " where name like ? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, "%"+name+"%");
		ResultSet rs =  ptmt.executeQuery();
		if(rs.next()){
			person = new Person(rs.getString("name"), rs.getInt("age"), rs.getString("address"),rs.getInt("id"));
		}
		
		if(ptmt != null){
			ptmt.close();
		}
		
		if(conn != null){
			conn.close();
		}
		return person;
	}

}
