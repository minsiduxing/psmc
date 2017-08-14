package priv.guochun.psmc.system;

public class Student {
	private String temaNum;
	private String name;
	private String age;
	private String sex;
	
	public Student(String temaNum, String name, String age, String sex) {
		super();
		this.temaNum = temaNum;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public String getTemaNum() {
		return temaNum;
	}
	public void setTemaNum(String temaNum) {
		this.temaNum = temaNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
