import entity.User;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import utils.DbOperatorUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MybatisExample{
    ////单个参数传递：通过Map传参， map的key要和#{}中的参数一致
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

    //单个参数传递：通过实体类对象传参
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

    //单个参数传递：基本类型传参
    public void test3(){
        SqlSession sqlSession = DbOperatorUtil.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);

        System.out.println(user);
    }

    //多个参数传递
    public void test4(){
        SqlSession sqlSession = DbOperatorUtil.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser("email-2-updatedV3", 2);

        sqlSession.commit();
    }

    //Map接收返回的单条数据
    public void test5(){
        SqlSession sqlSession = DbOperatorUtil.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //采用Map集合接收，mybatis会将数据库字段名做为map中key，字段值做value，如果SQL语句中使用了别名，则使用指定的别名做key
        Map<String, Object> userMap = mapper.selectUserReceiveByMap(2);

        System.out.println(userMap);
    }

    //Map接收返回的多条数据
    public void test6(){
        SqlSession sqlSession = DbOperatorUtil.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //采用Map集合接收，mybatis会将数据库字段名做为map中key，字段值做value，如果SQL语句中使用了别名，则使用指定的别名做key
        List<Map<String, Object>> userList = mapper.selectAllUserReceiveByListMap();

        System.out.println(userList);
    }

    //Map<String, Map<String, Object>> 接收多条数据
    public void test7(){
        SqlSession sqlSession = DbOperatorUtil.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //采用Map集合接收，mybatis会将数据库字段名做为map中key，字段值做value，如果SQL语句中使用了别名，则使用指定的别名做key
        Map<String, Map<String, Object>> userMapMap = mapper.selectAllUserReceiveByMapMap();

        System.out.println(userMapMap);
    }


    //单个参数传递：基本类型传参
    public void test8(){
        SqlSession sqlSession = DbOperatorUtil.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserByAge(2);

        System.out.println(user);
    }
}


public class MybatisTest {
    public static void main(String[] args) {
        MybatisExample mybatisExample = new MybatisExample();
        //mybatisExample.test1();
        //mybatisExample.test2();
        //mybatisExample.test3();
        //mybatisExample.test4();
        //mybatisExample.test5();
        //mybatisExample.test6();
        //mybatisExample.test7();
        mybatisExample.test8();
    }
}
