package cn.tedu.mybatis.mapper;

import cn.tedu.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    //mybatis的初步使用
    //查询t_user表中id为1的用户名
    //@Select()表示要执行查询操作,()里面就是sql语句
    @Select("SELECT username FROM t_user WHERE id=1")
    //接口中的方法不需要写方法实现
    //返回值需要匹配查询的结果
    //方法名是随意起的
    String selectUsername();

    //t_user表的单行查询
    //如果一个sql语句中需要条件变化
    //在需要变化的表达式位置位置编写#{name}即可
    @Select("SELECT id,username,`PASSWORD`,age,phone,email " +
            " FROM t_user WHERE id=#{id}")
    //这个查询查询出了所有t_user表的列,所以需要使用与其对应的实体类类型接收
    User getUserById(Integer id);

    //t_user表的多行查询
    @Select("select * from t_user")
    //返回多行的查询使用List接收,泛型指定实体类的类型
    List<User> getUsers();

    //新增t_user表数据的方法
    @Insert("INSERT INTO t_user VALUES(NULL," +
            "#{username},#{password},#{age},#{phone},#{email})")
    //下面的注解能够实现在对象新增到数据库时,由Mybatis为这个对象的id赋值
    @Options(useGeneratedKeys = true,keyProperty = "id")
    //增删改表的返回值都是受影响的行数所以使用Integer
    Integer insertUser(User user);

    @Update("update t_user set username=#{username}," +
            "password=#{password},age=#{age},phone=#{phone}" +
            ",email=#{email} where id=#{id}")
    Integer updateUser(User user);

    //按照id修改密码的方法
    @Update("update t_user set password=#{password} where id=#{id}")
    Integer updatePassword(String password,Integer id);
    // 如果是没有使用SpringBoot的项目中,
    // 并且出现了方法参数是两个以及两个以上的情况
    // 那么代码要写成下面的样子才能正常运行
    /*
        Integer updatePassword(
            @Param("password") String password,
            @Param("id") Integer id);
    */

    @Delete("delete from t_user where id=#{id}")
    Integer deleteById(Integer id);


    @Select("select * from t_user order by ${col}")
    List<User> selectOrder(String col);





}
