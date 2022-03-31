package cn.tedu.mybatis;

import cn.tedu.mybatis.entity.User;
import cn.tedu.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
        String username=userMapper.selectUsername();
        System.out.println(username);
    }
    @Test
    void selectOne(){
        User user=userMapper.getUserById(10);
        System.out.println(user);
    }
    @Test
    void selectAll(){
        List<User> users=userMapper.getUsers();
        for(User u : users){
            System.out.println(u);
        }
    }
    @Test
    void addUser(){
        User u=new User(null,"孙悟空","1234"
                ,600,"13788884451","sun@qq.com");
        Integer num=userMapper.insertUser(u);
        System.out.println("受影响行数:"+num);
        System.out.println("现在User对象的id为:"+u.getId());
    }
    @Test
    void updateUser(){
        //先查询出要修改的用户信息
        User user=userMapper.getUserById(17);
        //修改信息
        //user.setUsername("曹丕");
        user.setAge(25);
        user.setEmail("pi@qq.com");
        //执行修改操作
        Integer num=userMapper.updateUser(user);
        System.out.println("受影响行数:"+num);
    }

    @Test
    void updatePassword(){
        Integer num=userMapper.updatePassword("8888",17);
        System.out.println("受影响行数:"+num);
    }
    @Test
    void delete(){
        Integer num=userMapper.deleteById(17);
        System.out.println("受影响行数:"+num);
    }

    @Test
    void order(){
        List<User> users=userMapper.selectOrder("age desc");
        for (User u:users) {
            System.out.println(u);
        }
    }


}
