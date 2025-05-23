package pack.mybatis;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pack.business.SqlMapperInter;

public class SqlMapConfig {
  public static SqlSessionFactory sqlSessionFactory;
  static{
     String resource = "pack/mybatis/Configuration.xml";
     try {
         Reader reader = Resources.getResourceAsReader(resource);
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
         reader.close(); 
         
         Class[] mappers = { SqlMapperInter.class };
         for(Class m:mappers) {
        	 sqlSessionFactory.getConfiguration().addMapper(m);    	 
         }
     } catch (Exception e) {
     System.out.println("SqlMapConfig 오류 : " + e);
  }
}
public static SqlSessionFactory getSqlSession(){ return sqlSessionFactory; }
}