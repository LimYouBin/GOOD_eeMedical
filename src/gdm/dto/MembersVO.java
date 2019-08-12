package gdm.dto;

import java.sql.Date;

public class MembersVO {
	private int member_no;
	private String email;
	private String member_pwd;	
	private String member_name;
	private String nickname;
	private String phone;
	private String addr;
	private int age;
	private String gender;
	private String img;
	private String grd;
	private int money;
	private int point;
	private Date member_join;
	private String isdrop;
	
	public MembersVO(int member_no, String email, String member_pwd, String member_name, String nickname, String phone,
			String addr, int age, String gender, String img, String grd, int money, int point, Date member_join,
			String isdrop) {
		super();
		this.member_no = member_no;
		this.email = email;
		this.member_pwd = member_pwd;
		this.member_name = member_name;
		this.nickname = nickname;
		this.phone = phone;
		this.addr = addr;
		this.age = age;
		this.gender = gender;
		this.img = img;
		this.grd = grd;
		this.money = money;
		this.point = point;
		this.member_join = member_join;
		this.isdrop = isdrop;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getGrd() {
		return grd;
	}

	public void setGrd(String grd) {
		this.grd = grd;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getMember_join() {
		return member_join;
	}

	public void setMember_join(Date member_join) {
		this.member_join = member_join;
	}

	public String getIsdrop() {
		return isdrop;
	}

	public void setIsdrop(String isdrop) {
		this.isdrop = isdrop;
	}

	@Override
	public String toString() {
		return "MembersVO [member_no=" + member_no + ", email=" + email + ", member_pwd=" + member_pwd
				+ ", member_name=" + member_name + ", nickname=" + nickname + ", phone=" + phone + ", addr=" + addr
				+ ", age=" + age + ", gender=" + gender + ", img=" + img + ", grd=" + grd + ", money=" + money
				+ ", point=" + point + ", member_join=" + member_join + ", isdrop=" + isdrop + "]";
	}
		
}
