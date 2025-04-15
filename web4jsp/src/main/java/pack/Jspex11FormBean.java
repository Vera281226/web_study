package pack;

public class Jspex11FormBean {
	// 클라이언트부터 수신되는 값이 복수일 경우 한꺼번에 처리하기 위한 클래스 객체
	// get, set Property에서 사용되는 값처럼 변수명은 일치시켜줘야한다.
	private String name;
	private int kor;
	private int eng;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getKor() { return kor; }
	public void setKor(int kor) { this.kor = kor; }
	public int getEng() { return eng; }
	public void setEng(int eng) { this.eng = eng; }
}
