package pack;

public class Jspex9Gugu {
	// 싱글턴 패턴을 통한 다수 사용자에 의한 생성자의 메모리 과다 사용을 막는 것이 좋다. 
	// getInstance를 통한 클래스에서 객체를 만들어 반환시는 것으로 사용하는것이 좋다.  
	private static Jspex9Gugu gugu = new Jspex9Gugu();
	
	public static Jspex9Gugu getInstance() {
		return gugu;
	}
	public int[] compute(int dan) {
		int gu[] = new int[9];
				for(int i=0; i<9; i++) { gu[i] = dan*i; }
				return gu;
	}
}
