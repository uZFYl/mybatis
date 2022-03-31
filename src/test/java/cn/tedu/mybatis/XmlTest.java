package cn.tedu.mybatis;

import cn.tedu.mybatis.entity.Dept;

import cn.tedu.mybatis.mapper.XmlMapper;
import cn.tedu.mybatis.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class XmlTest {

    @Resource
    XmlMapper xmlMapper;
    @Test
    public void testXml(){
        String username=xmlMapper.findUsername();
        System.out.println(username);
    }
    @Test
    void testDeleteForeach(){
        Integer num=xmlMapper.deleteByIds(14,19);
        System.out.println(num);
    }
    /*@Test
    void testUpdate(){
        User user=new User();
        user.setId(20);
        user.setPassword("8888");
        user.setPhone("13077899655");
        //user.setAge(18);
//        user.setEmail("bajie@qq.com");
        Integer num=xmlMapper.updateUserInfo(user);
        System.out.println(num);
    }*/

    /*@Test
    void select(){
        List<User> list=xmlMapper.findUserByParam(
                "frank0%",
                27,
                "138%");
        for(User u : list){
            System.out.println(u);
        }
    }

    @Test
    void selectVo(){
        List<UserVo> list=xmlMapper.findUserDept();
        for(UserVo u: list){
            System.out.println(u);
        }
    }

    @Test
    public void link(){
        Dept dept=xmlMapper.getDeptWithUser(1);
        System.out.println(dept);
    }
*/

}
