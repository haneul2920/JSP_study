package ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StaffDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public StaffDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/mysql");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addStaff(StaffVO staffVO) {
		try {
		con = dataFactory.getConnection();
		String code = staffVO.getCode();
		String name = staffVO.getName();
		String age = staffVO.getAge();
		String sex = staffVO.getSex();
		String addr = staffVO.getAddr();
		String phone = staffVO.getPhone();
		String dept= staffVO.getDept();
		String rank = staffVO.getRank();
		
		String query = "insert into member ";
		query += "(staff_code, staff_name, staff_age, staff_sex, staff_addr, staff_ponenumber, dept_code, staff_rank)";
		query += "values(?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println("prepareStatememt : " + query);
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, code);
		pstmt.setString(2, name);
		pstmt.setString(3, age);
		pstmt.setString(4, sex);
		pstmt.setString(5, addr);
		pstmt.setString(6, phone);
		pstmt.setString(7, dept);
		pstmt.setString(8, rank);
		pstmt.executeUpdate();
		pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delStaff(StaffVO staffVO) {
		try {
			con = dataFactory.getConnection();
			String id = staffVO.getCode();			
			String query = "DELETE FROM member";
			query+=" where staff_code=?";
			System.out.println("prepareStatememt : " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public void updateStaff(StaffVO staffVO) {
		try {
			con = dataFactory.getConnection();
			String code = staffVO.getCode();
			String name = staffVO.getName();
			String age = staffVO.getAge();
			String sex = staffVO.getSex();
			String addr = staffVO.getAddr();
			String phone = staffVO.getPhone();
			String dept= staffVO.getDept();
			String rank = staffVO.getRank();
			
			String query = "update member ";
			query += "set staff_code=?, staff_name=?, staff_age=?, staff_sex=?, staff_addr=?, staff_ponenumber=? dept_code, staff_rank";
			query += " where staff_code=?";
			System.out.println("prepareStatememt : " + query);
			pstmt = con.prepareStatement(query);			
			pstmt.setString(1, code);
			pstmt.setString(2, name);
			pstmt.setString(3, age);
			pstmt.setString(4, sex);
			pstmt.setString(5, addr);
			pstmt.setString(6, phone);
			pstmt.setString(7, dept);
			pstmt.setString(8, rank);
			pstmt.executeUpdate();
			pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}

	public List listStaff(StaffVO staffVO) {
		List membersList = new ArrayList();
		String _name=staffVO.getName();
		try {
			con = dataFactory.getConnection();
			String query = "select * from member ";
			
			if((_name!=null && _name.length()!=0)){
				 query+=" where staff_code=?";
				 pstmt = con.prepareStatement(query);
				 pstmt.setString(1, _name);
			}else {
				pstmt = con.prepareStatement(query);	
			}
			
			
			System.out.println("prepareStatememt: " + query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String code = rs.getString("staff_code");
				//String pwd = rs.getString("pwd");
				String name = rs.getString("staff_name");
				String age = rs.getString("staff_age");
				String sex = rs.getString("staff_sex");
				String addr = rs.getString("staff_addr");
				String phone = rs.getString("staff_ponenumber");
				String dept = rs.getString("dept_code");
				String rank = rs.getString("staff_rank");
				StaffVO vo = new StaffVO();
				vo.setCode(code);
				//vo.setPwd(pwd);
				vo.setName(name);
				vo.setAge(age);
				vo.setSex(sex);
				vo.setAddr(addr);
				vo.setPhone(phone);
				vo.setDept(dept);
				vo.setRank(rank);				
				membersList.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return membersList;
	}

}
