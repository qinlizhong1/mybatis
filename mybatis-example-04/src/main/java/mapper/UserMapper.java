package mapper;


import entity.User;

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


    //单个参数传递：通过对象传参， map的key要和#{}中的参数一致
    public Integer InsertUserForObject(User user);

    //单个参数传递：基本类型
    public User selectUserById(Integer userId);


}
