package pack;

import java.util.List;

public class MybatisMain {
	public static void main(String[] args) {
		ProcessDao processDao = ProcessDao.getInstance();
		try {
			/*
			System.out.println("자료 추가");
			DataDto dto = new DataDto();
			dto.setCode("1");
			dto.setSang("알파카");
			dto.setSu("10");
			dto.setDan("750000");
			processDao.insertData(dto);
			*/
			/*
			System.out.println("자료 수정");
			DataDto dto = new DataDto();
			dto.setCode("1");
			dto.setSang("라마");
			dto.setSu("20");
			dto.setDan("550000");
			processDao.updateData(dto);
			*/
			
			boolean b = processDao.deleteData(1);
			if(b) System.out.println("삭제 성공");
			else System.out.println("삭제 실패");
			System.out.println("전체 자료 읽기");
			List<DataDto> list = processDao.selectDataALL();
			for(DataDto s:list) {
				System.out.println(s.getCode()+" "+s.getSang()+" "+s.getSu()+" "+s.getDan());	
			}
			System.out.println("부분 자료 읽기");
			String code = "2";
			DataDto dto2 = processDao.selectDataPart(code);
			System.out.println(dto2.getCode()+" "+dto2.getSang()+" "+dto2.getSu()+" "+dto2.getDan());	
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}