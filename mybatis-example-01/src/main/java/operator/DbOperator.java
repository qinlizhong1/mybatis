package operator;

import entity.User;
import org.apache.ibatis.session.SqlSession;
import utils.DbOperatorUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbOperator {

    /**
     * 使用Map可以给SQL语句的占位符传值，占位符中写map集合的key，如果key不存在，获取的是null，一般map集合的key起名的时候要见名知意。
     * @param user
     */
    public void addByMap(User user){
        System.out.println("----------------------- 通过map传参插入数据 ----------------------");
        SqlSession sqlSession = DbOperatorUtil.getSession();
        Map map = new HashMap();
        map.put("id", user.getId());
        map.put("age", user.getAge());

        //key注意要和userMapper中insert语句 #{fullName}相同
        map.put("fullName", user.getFullName());
        map.put("email", user.getEmail());
        map.put("password", user.getPassword());

        int count = sqlSession.insert("addByMap", map);
        if (count ==  1){
            System.out.println("插入数据成功,插入的id是:" + user.getId());
        }else {
            System.out.println("插入失败");
        }
        sqlSession.commit();
        DbOperatorUtil.closeSession(sqlSession);
    }

    /**
     * 使用普通的java对象给SQL语句的占位符传值
     * mybatis在底层给占位符?传值的时候，先要获取对象属性值，通过调用对象的get方法。
     * @param user
     */
    public void addByObject(User user){
        System.out.println("\n----------------------- 通过对象传参插入数据 ----------------------");
        SqlSession sqlSession = DbOperatorUtil.getSession();

        int count = sqlSession.insert("addByObject", user);
        if (count ==  1){
            System.out.println("插入数据成功,插入的id是:" + user.getId());
        }else {
            System.out.println("插入失败");
        }
        sqlSession.commit();
        DbOperatorUtil.closeSession(sqlSession);
    }

    public void deleteById(Integer id){
        SqlSession sqlSession = DbOperatorUtil.getSession();


        sqlSession.commit();
        DbOperatorUtil.closeSession(sqlSession);
    }

    public void deleteAll(){
        SqlSession sqlSession = DbOperatorUtil.getSession();
        System.out.println("\n-------------------------- 删除整个表数据 ---------------------------");
        int count = sqlSession.delete("deleteAll");
        System.out.println("删除的数据条数:" + count);
        sqlSession.commit();
        DbOperatorUtil.closeSession(sqlSession);
    }

    public void updateById(User user){
        System.out.println("\n-------------------------- 更新单条数据 -----------------------------");
        SqlSession sqlSession = DbOperatorUtil.getSession();

        int count = sqlSession.update("updateById", user);
        if (count ==  1){
            System.out.println("更新数据成功,id是:" + user.getId());
        }else {
            System.out.println("更新失败");
        }

        sqlSession.commit();
        DbOperatorUtil.closeSession(sqlSession);
    }

    public void queryById(Integer id){
        System.out.println("\n-------------------------- 查询单条数据 -----------------------------");
        SqlSession sqlSession = DbOperatorUtil.getSession();
        User user = sqlSession.selectOne("user.queryById", id);
        System.out.println(user);
        DbOperatorUtil.closeSession(sqlSession);

    }

    public void queryAll(){
        System.out.println("\n-------------------------- 查询所有数据 -----------------------------");
        SqlSession sqlSession = DbOperatorUtil.getSession();

        List<User> userList = sqlSession.selectList("queryAll");

        for (User user : userList){
            System.out.println(user);
        }

        DbOperatorUtil.closeSession(sqlSession);
    }

    /**
     * 当不同的 SQLMapper 映射文件中，存在 sqlId 相同的两个SQL语句，若使用SQL语句时不使用命名空间，则会报错
     * 命名空间的使用 namespace.sqlId ，如：newuser.queryById
     * @param id
     */
    public void queryNewById(Integer id){
        System.out.println("\n-------------------------- 查询单条数据 -----------------------------");
        SqlSession sqlSession = DbOperatorUtil.getSession();
        User user = sqlSession.selectOne("newuser.queryById", id);
        System.out.println(user);
        DbOperatorUtil.closeSession(sqlSession);

    }
}
