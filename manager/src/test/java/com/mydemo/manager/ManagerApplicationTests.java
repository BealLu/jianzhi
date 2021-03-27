package com.mydemo.manager;

import com.mydemo.common.OSSTemplate;
import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ManagerApplicationTests {
	@Test
	void contextLoads() {
		//ApplicationContext
		//逆向工程
	/*	try {
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			File configFile=new File("E:\\idea\\jianzhi\\manager\\src\\main\\resources\\gen.xml");
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator MyBatisGenerator =
					new MyBatisGenerator(config, callback, warnings);
			MyBatisGenerator.generate(null);
		}catch (Exception e){
			e.printStackTrace();
		}*/
	}

}
