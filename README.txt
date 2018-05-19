
 1. 这是一个 Spring-boot 的练手项目，配置简单易用。
   pom.xml 中的配置全部基于 boot-starter集成进来，例如
		<!-- alibaba druid 数据源 -->
		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>druid-spring-boot-starter</artifactId>
			<version>${boot.druid.version}</version>
		</dependency>
		<!-- mysql jdbc driver -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>${mysql.connector.version}</version>
		</dependency>
		<!-- mybatis boot starter -->
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>${boot.mybatis.version}</version>
		</dependency>
		<!--通用mapper 避免单表在xml写sql语句-->
		<dependency>
			<groupId>tk.mybatis</groupId>
			<artifactId>mapper-spring-boot-starter</artifactId>
			<version>${boot.tk.mybatis.version}</version>
		</dependency>
		<!--swagger-ui-->
		<dependency>
			<groupId>com.spring4all</groupId>
			<artifactId>swagger-spring-boot-starter</artifactId>
			<version>${boot.swagger.version}</version>
		</dependency>
 
  2. MyBatis采用目前流行的通用Mapper方式进行DAO开发，避免单表在xml写sql语句
  
  3. 采用PageHelper分页插件
  
  4. spring boot包含 dev、prod两个环境配置文件
  
  5. 集成 swagger-ui，方便Controller层接口展示和调试
     dev环境下启动后访问 http://localhost:8080/swagger-ui.html
  
  6. 项目中包含SpringMVC相关的代码（分页查询，单表插入），单元测试等。
  
  7. 数据库采用mysql，脚本文件在项目中的 script文件夹下。
  
  
  
  