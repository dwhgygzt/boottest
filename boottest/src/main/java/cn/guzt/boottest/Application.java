package cn.guzt.boottest;

import cn.guzt.boottest.constants.Constants;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 系统启动入口
 */
@SpringBootApplication
@EnableSwagger2Doc // 开启Swagger支持
@MapperScan(basePackages = "cn.guzt.boottest.dao") // 通用mapper扫描dao的路径
public class Application {

	// 默认logback日志
	private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		logger.debug("Spring Boot Demo 启动，当前版本{}...", Constants.SYSTEM_VERSION);
		SpringApplication.run(Application.class, args);
	}
}
