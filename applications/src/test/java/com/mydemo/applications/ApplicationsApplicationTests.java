package com.mydemo.applications;

import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ApplicationsApplicationTests {

	@Test
	void contextLoads() {
		/*try {
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			File configFile=new File("E:\\idea\\jianzhi\\applications\\src\\main\\resources\\gen.xml");
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
