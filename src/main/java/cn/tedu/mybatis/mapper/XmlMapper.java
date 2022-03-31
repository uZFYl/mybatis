package cn.tedu.mybatis.mapper;

import cn.tedu.mybatis.entity.Dept;
import cn.tedu.mybatis.entity.User;
import cn.tedu.mybatis.vo.UserVo;

import java.util.List;

public interface XmlMapper {


    String findUsername();

    //动态sql foreach删除方法
    //为了调用方便,使用可变参数
    Integer deleteByIds(Integer... ids);

    //动态sql if修改方法
    //可以修改任何属性,所以传入user对象
    Integer updateUserInfo(User user);

    //动态sql if查询方法
    //参数可以设置为User类型,这里设置为3个参数体验不同效果
    List<User> findUserByParam(
            String username,
            Integer age,
            String phone
    );

    //值对象查询
    List<UserVo> findUserDept();


    //执行关联查询
    Dept getDeptWithUser(Integer id);



}
