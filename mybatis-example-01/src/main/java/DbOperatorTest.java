import entity.User;
import operator.DbOperator;

//测试对user表增删改查操作
public class DbOperatorTest {
    public static void main(String[] args) {
        DbOperator dbOperator = new DbOperator();

        /*
        dbOperator.addByMap(new User(1, "qinzli", 18, "email1", "111111"));
        dbOperator.addByObject(new User(2, "liuxiao", 19, "email2", "22222"));
        dbOperator.updateById(new User(2, "zhanzhilinsssss", 199, "email2222", "333"));
        dbOperator.queryById(1);
        dbOperator.queryAll();
        dbOperator.deleteAll();
        */
        dbOperator.queryNewById(1);
    }
}
