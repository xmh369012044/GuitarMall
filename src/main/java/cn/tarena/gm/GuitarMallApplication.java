package cn.tarena.gm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("cn.tarena.gm.mapper")
public class GuitarMallApplication extends SpringBootServletInitializer{

	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(GuitarMallApplication.class);

	}

	public static void main(String[] args) {
		SpringApplication.run(GuitarMallApplication.class, args);
	}
}
