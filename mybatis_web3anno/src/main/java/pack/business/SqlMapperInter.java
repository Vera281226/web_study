package pack.business;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SqlMapperInter {
	@Select("SELECT*FROM membertab")
	public List<DataDto> selectMemberAll();

	@Select("SELECT*FROM membertab WHERE id=#{id}")
	public DataDto selectMemberPart(String id);
	
	@Insert("INSERT INTO membertab VALUES(#{id},#{name},#{passwd},now())")
	public int insertMemberData(DataFormBean bean);
	
	@Update("UPDATE membertab SET name=#{name}, passwd=#{passwd} WHERE id=#{id}")
	public int updateMemberData(DataFormBean bean);
	
	@Delete("DELETE FROM membertab WHERE id=#{id}")
	public int deleteMemberData(String id);
}