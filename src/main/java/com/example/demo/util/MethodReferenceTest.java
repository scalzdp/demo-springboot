package com.example.demo.util;

import com.example.demo.model.User;
import com.example.demo.service.UserComparator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 方法引用测试
 * */
public class MethodReferenceTest {


    public static void main(String[] args){
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("user1");
        user1.setPassword("pass1");
        user1.setPhone("12345");
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("user2");
        user2.setPassword("pass2");
        user2.setPhone("123456");
        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("user3");
        user3.setPassword("pass3");
        user3.setPhone("1234567");
        List<User> userList = Arrays.asList(user1,user2,user3);

        UserComparator userComparator = new UserComparator();
        userList.sort(userComparator::compareByUserByUserID);

//        userList.stream().map(c->c.getUserId()).forEach(System.out::println);

        Function<User,Integer> func = s->s.getUserId();
        Function<Integer,Integer> func1 = s->s+5;
//        System.out.println(func.andThen(func1).apply(user1));

//        Predicate
        filter(userList,(s)->((User)s).getUserId()>2);
        assert "aab".length() == 20 : "执行失败！";
        System.out.println("aaa");
    }

    /**使用Predicate函数式接口，可以将过滤条件函数，传入到filter中进行处理。
     *
     * */
    public static void filter(List<User> users,Predicate condition){
        users.stream().filter(c->condition.test(c))
                //.forEach(System.out::println);
                .forEach(d->System.out.println(d.getUserName()));
    }
}
