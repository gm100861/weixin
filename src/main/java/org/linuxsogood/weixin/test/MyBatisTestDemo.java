package org.linuxsogood.weixin.test;

/**
 * Created by m on 16/7/23.
 */
public class MyBatisTestDemo {

    public static void main(String[] args) {
/*
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        Configuration configuration = new Configuration();
        SpringManagedTransactionFactory transactionFactory = new SpringManagedTransactionFactory();
        SqlSessionFactory build = builder.build(configuration);
        SqlSession sqlSession = build.openSession();*/
        Person person = new Person();
        person.setName("honway");
        System.out.println(person.getName());

    }

}
