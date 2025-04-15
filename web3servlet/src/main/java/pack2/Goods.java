package pack2;

public class Goods { // 장바구니에 담을 상품 정보들을 저장하기 위한 DTO 클래스
	private String name;
	private int price;
	
	public Goods(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public String getName() { return name; }
	public int getPrice() { return price; }
}
