package com.munaf.ConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}

/*

1. add eureka client and config server dependency
2. add @EnableConfigServer on main file
3. add this spring.cloud.config.server.git.uri=REPO-URL (https://github.com/MunafBadarpura/hotel-microservices-configurations)
4. add config client dependency in other services where you want to use specified configurations
5. in config client service yml file add this :
  spring:
  	config:
    	import: "optional:configserver:http://localhost:8085"

*/