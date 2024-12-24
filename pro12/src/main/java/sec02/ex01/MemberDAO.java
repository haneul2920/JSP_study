package sec02.ex01;

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

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/mysql");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addMember(MemberVO memberVO) {
		try {
		con = dataFactory.getConnection();
		String id = memberVO.getId();
		String name = memberVO.getName();
		String number = memberVO.getNumber();
		String addr = memberVO.getAddr();
		String phone1 = memberVO.getPhone1();
		String phone2 = memberVO.getPhone2();
		String height = memberVO.getHeight();
		
		String query = "insert into member ";
		query += "(mem_id, mem_name, mem_number, addr, phone1, phone2, height)";
		query += "values(?, ?, ?, ?, ?, ?, ?)";
		System.out.println("prepareStatememt : " + query);
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, number);
		pstmt.setString(4, addr);
		pstmt.setString(5, phone1);
		pstmt.setString(6, phone2);
		pstmt.setString(7, height);
		pstmt.executeUpdate();
		pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delMember(MemberVO memberVO) {
		try {
			con = dataFactory.getConnection();
			String id = memberVO.getId();			
			String query = "DELETE FROM member";
			query+=" where mem_id=?";
			System.out.println("prepareStatememt : " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public void updateMember(MemberVO memberVO) {
		try {
			con = dataFactory.getConnection();
			String id = memberVO.getId();
			String name = memberVO.getName();
			String number = memberVO.getNumber();
			String addr = memberVO.getAddr();
			String phone1 = memberVO.getPhone1();
			String phone2 = memberVO.getPhone2();
			String height = memberVO.getHeight();
			
			String query = "update member ";
			query += "set mem_name=?, mem_number=?, addr=?, phone1=?, phone2=?, height=?";
			query += " where mem_id=?";
			System.out.println("prepareStatememt : " + query);
			pstmt = con.prepareStatement(query);			
			pstmt.setString(1, name);
			pstmt.setString(2, number);
			pstmt.setString(3, addr);
			pstmt.setString(4, phone1);
			pstmt.setString(5, phone2);
			pstmt.setString(6, height);
			pstmt.setString(7, id);
			pstmt.executeUpdate();
			pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}

	public List listMembers(MemberVO memberVO) {
		List membersList = new ArrayList();
		String _name=memberVO.getName();
		try {
			con = dataFactory.getConnection();
			String query = "select * from member ";
			
			if((_name!=null && _name.length()!=0)){
				 query+=" where mem_name=?";
				 pstmt = con.prepareStatement(query);
				 pstmt.setString(1, _name);
			}else {
				pstmt = con.prepareStatement(query);	
			}
			
			
			System.out.println("prepareStatememt: " + query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("mem_id");
				//String pwd = rs.getString("pwd");
				String number = rs.getString("mem_number");
				String name = rs.getString("mem_name");
				String addr = rs.getString("addr");
				Date debut_date = rs.getDate("debut_date");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String height = rs.getString("height");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				//vo.setPwd(pwd);
				vo.setNumber(number);
				vo.setName(name);
				vo.setAddr(addr);
				vo.setDebut_date(debut_date);
				vo.setPhone1(phone1);
				vo.setPhone2(phone2);
				vo.setHeight(height);				
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
