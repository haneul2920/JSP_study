package sec02.ex01;

import java.sql.Date;

public class MemberVO {
	private String id;
	private String pwd;
	private String number;
	private String name;
	private String addr;
	private Date debut_date;
	private String phone1;
	private String phone2;
	private String height;
	
	
	public MemberVO() {
		System.out.println("MemberVO 연동");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public Date getDebut_date() {
		return debut_date;
	}
	
	public void setDebut_date(Date debut_date) {
		this.debut_date = debut_date;
	}
	
	public String getPhone1() {
		return phone1;
	}
	
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}
	
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	public String getHeight() {
		return height;
	}
	
	public void setHeight(String height) {
		this.height = height;
	}
	
}
