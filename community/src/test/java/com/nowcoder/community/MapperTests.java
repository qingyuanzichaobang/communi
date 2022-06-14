package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(11);
        System.out.println(user);
        user = userMapper.selectByName("nowcoder13");
        System.out.println(user);
        user = userMapper.selectByEmail("nowcoder112@sina.com");
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("qyz");
        user.setPassword("123");
        user.setSalt("abc");
        user.setEmail("3@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreatTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println("===================================");
        System.out.println(rows);
        System.out.println(user.getId());
    }
    @Test
    public void testupdateUser(){
        int rows = userMapper.updateStatus(150,1);
        System.out.println(rows);
        rows = userMapper.updateHeader(150,"http://www.nowcoder.com/102.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150,"hello");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0,0,10);
        System.out.println(list.size());
        System.out.println(list);
    }
}
