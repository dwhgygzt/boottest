package cn.guzt.boottest;

import cn.guzt.boottest.dto.CityDto;
import cn.guzt.boottest.dto.UserDto;
import cn.guzt.boottest.service.SysService;
import cn.guzt.boottest.config.MyYmlConfig;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	// 默认logback日志
	private static Logger logger = LoggerFactory.getLogger(ApplicationTests.class);

	@Autowired
	private SysService sysService;

	@Autowired
	private Environment environment;

	@Autowired
	private MyYmlConfig myYmlConfig;

	@Value("${myparamers.simpleProp}")
	String simpleProp;

	@Test
	public void testMyParamers(){
		logger.info("value 方式注入参数：{}",simpleProp);
		logger.info(myYmlConfig.getSimpleProp());
		myYmlConfig.getListProp2().stream().forEach(logger :: info);
	}

	@Test
	@Ignore
	public void saveCityTest() {
		String[] envs = environment.getDefaultProfiles();
		Arrays.stream(envs).forEach(logger :: info);
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		//logger.info("applicationName={}",ctx.getApplicationName());
		CityDto cityDto = new CityDto();
		cityDto.setName("大连");
		cityDto.setCode("1012");
		sysService.saveCity(cityDto);
	}

	@Test
	@Ignore
	public void saveUserTest() {
		UserDto userDto = new UserDto();
		userDto.setCityCode("1004");
		userDto.setUserName("阿炳");
		userDto.setMobile("13584061123");
		userDto.setPassword("bbc");
		sysService.saveUser(userDto);

	}


}
