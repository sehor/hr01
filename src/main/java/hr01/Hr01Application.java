package hr01;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableCaching
public class Hr01Application {

	public static void main(String[] args) {
		SpringApplicationBuilder builder=new SpringApplicationBuilder(Hr01Application.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);
	}

}
