import entity.User;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import utils.DbOperatorUtil;

import java.util.HashMap;
import java.util.Map;

class MybatisExample{
    public void test1(){
        Map<String, Object> user = new HashMap<String, Object>();
        user.put("id", 1);
        user.put("fullName", "张一");
        user.put("age", 1);
        user.put("email", "email-1");
        user.put("password", 11111111);

        SqlSession sqlSession = DbOperatorUtil.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.InsertUserForMap(user);

        sqlSession.commit();
    }

    public void test2(){
        User user = new User();
        user.setId(2);
        user.setAge(2);
        user.setEmail("email-2");
        user.setFullName("李二");
        user.setPassword("2222222");

        SqlSession sqlSession = DbOperatorUtil.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.InsertUserForObject(user);

        sqlSession.commit();
    }

    public void test3(){
        SqlSession sqlSession = DbOperatorUtil.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectUserById(1);
        System.out.println(user);
    }

    public void test4(){

    }

    public void test5(){

    }
}


public class MybatisTest {
    public static void main(String[] args) {
        MybatisExample mybatisExample = new MybatisExample();
        //mybatisExample.test1();
        //mybatisExample.test2();
        mybatisExample.test3();
    }
}
