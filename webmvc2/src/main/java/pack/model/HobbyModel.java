package pack.model;

import java.util.ArrayList;

public class HobbyModel { // 비즈니스 로직
	public ArrayList<String> getHobby(String hobby){
		ArrayList<String> list = new ArrayList();
		
		if(hobby.equals("m")) {
			list.add("설악산");
			list.add("북한산");
		} else if(hobby.equals("t")) {
			list.add("동해안");
			list.add("남해안");
			list.add("서해안");
		}else if(hobby.equals("s")) {
			list.add("수영장");
		}else if(hobby.equals("j")) {
			list.add("탈출 기술");
			list.add("공격 기술");
		}
		return list;
	}
}