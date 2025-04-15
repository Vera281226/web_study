package pack;

public class Jspex12logic { // DB 입력 및 비즈니스 로직 파일
	// 총점과 평균 등의 계산을 하는 business logic 클래스
	private Jspex12FormBean formBean;
	
	public void setFormBean(Jspex12FormBean formBean) {
		this.formBean=formBean;
	}
	
	public int getTot() {
		return formBean.getPrice() - formBean.getDiscount();
	}
}