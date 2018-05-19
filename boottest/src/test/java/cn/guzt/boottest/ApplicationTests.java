package cn.guzt.boottest;

import cn.guzt.boottest.dto.CityDto;
import cn.guzt.boottest.dto.UserDto;
import cn.guzt.boottest.service.SysService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private SysService sysService;

	@Test
	@Ignore
	public void saveCityTest() {
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
