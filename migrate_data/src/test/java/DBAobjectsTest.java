import com.lxf.mapper.BFSMapper;
import com.lxf.pojo.DbaObjects;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class DBAobjectsTest {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        Map dbaobjMap = new HashMap();
        dbaobjMap.put("objectID", 3);
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            BFSMapper mapper = (BFSMapper) sqlSession.getMapper(BFSMapper.class);
            DbaObjects dbaobj = mapper.selectDbaObjects(dbaobjMap);
            System.out.println(dbaobj);
            sqlSession.close();
        } catch (IOException v) {
        }
    }
}

