package mapper;


import entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
+-----------+--------------+------+-----+---------+----------------+
| Field     | Type         | Null | Key | Default | Extra          |
+-----------+--------------+------+-----+---------+----------------+
| id        | int(11)      | NO   | PRI | NULL    | auto_increment |
| full_name | varchar(50)  | NO   |     |         |                |
| age       | int(11)      | YES  |     | NULL    |                |
| email     | varchar(100) | NO   |     |         |                |
| password  | varchar(50)  | NO   |     |         |                |
+-----------+--------------+------+-----+---------+----------------+
*/
public interface UserMapper {

    //单个参数传递：通过Map传参， map的key要和#{}中的参数一致
    public Integer InsertUserForMap(Map<String, Object> userAttrMap);


    //单个参数传递：通过实体类对象传参
    public Integer InsertUserForObject(User user);

    //单个参数传递：基本类型传参
    public User selectUserById(Integer userId);


    //多个参数传递
    public Integer updateUser(@Param("email") String email, @Param("userId") Integer id);


    //Map接收返回的单条数据
    public Map<String, Object>  selectUserReceiveByMap(Integer userId);


    //Map接收返回的多条数据
    public List<Map<String, Object>> selectAllUserReceiveByListMap();

    //Map<String, Map>接收返回的多条数据:使用List<Map>进行接收多条数据，对结果集中的数据进行查询，需要顺序遍历查询，不方便。
    //为了方便查询，可以拿数据记录的id（主键）做key，由整条数据记录封装而成的Map作为value组成的Map<String, Map<String, Object>> 接收
    @MapKey("id")
    public Map<String, Map<String, Object>> selectAllUserReceiveByMapMap();



    //resultMap 进行结果映射:  当查询的数据库的列名和 java 对象的属性名对应不上时，如user表的full_name字段，在User实体类的属性名称为fullName
    public User selectUserByAge(Integer age);

}






















