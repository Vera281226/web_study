package pack;

public class Jspex11logic { // DB 입력 및 비즈니스 로직 파일
	// 총점과 평균 등의 계산을 하는 business logic 클래스
	private Jspex11FormBean formBean;
	
	public void setFormBean(Jspex11FormBean formBean) {
		this.formBean=formBean;
	}
	
	public int getTot() {
		return formBean.getKor()+formBean.getEng();
	}
	public double getAvg() {
		double imsi = getTot()/2.0;
		return imsi;
	}
}
