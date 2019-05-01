java传统方式访问mysql数据库的两种方式：
一: jdbc
    1. 创建maven项目并添加依赖
        <!-- junit -->
        <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>4.11</version>
          <scope>test</scope>
        </dependency>
        <!-- mysql driver -->
        <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
          <version>8.0.15</version>
        </dependency>
        <!-- lombok -->
        <dependency>
          <groupId>org.projectlombok</groupId>
          <artifactId>lombok</artifactId>
          <version>1.18.6</version>
        </dependency>

    2. 数据表准备
            // 进入mysql数据库
            mysql -u root -p
            // 查看所拥有的库
            show databases;
            // 创建库
            create database springdata_test;
            // 选中创建的库
            use springdata_test;
            // 创建表
            create table student(
                id int not null auto_increment,
                name varchar(20) not null,
                age int not null,
                primary key(id)
             );
             // 查看表是否创建
            show tables;
            // 查看创建的表结构
            desc student;
            // 插入数据
            insert into student(name, age) values("zhangsan", 20);
            insert into student(name, age) values("lisi", 21);
            insert into student(name, age) values("wangwu", 22);

    3. 开发JDBCUtil工具类(获取Connection, Statement, ResultSet)
            1). 创建db.properties数据库配置文件
            2). 创建ReadPropertiesUtil工具类(类中编写来三种读取.properties的方式)
            3). 创建JDBCUtil类
            4). 编写junit测试类测试

    4. 建立数据对象模型DAO
            1). 创建查询接口
            2). 创建接口实现类
            3). 编写junit测试类

二: jdbcTemplate
    1. Maven依赖
        <!-- spring-jdbc -->
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-jdbc</artifactId>
          <version>5.1.5.RELEASE</version>
        </dependency>
        <!-- spring-context -->
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-context</artifactId>
          <version>5.1.5.RELEASE</version>
        </dependency>
    2. DataSource 和 JdbcTemplate注入
        1). 创建beans.xml配置文件
        2). 配置dataSource
        3). 注入jdbcTemplate
        4). 配置接口实现类
        5). junit测试dataSource和jdbcTemplate
