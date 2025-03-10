package com.munaf.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}


/*

1. Add this :
		<dependency>
			<groupId>io.github.resilience4j</groupId>
			<artifactId>resilience4j-spring-boot3</artifactId>
		</dependency>

2.Add @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
annotation where 2 microservices are called, and create a fallback method with defined name
and also fallback method have s	ame return type and arguments


3. Add this :

# ACTUATOR CONFIGURATIONS
management:
  health:
    circuitbreakers:
      enabled: true
  endpoints:
    web:
      exposure:
        include: health

  endpoint:
    health:
      show-details: ALWAYS

# RESILIENCE4j CONFIGURATIONS
resilience4j:
  circuitbreaker:
    instances:
      ratingHotelBreaker:
        registerHealthIndicator: true
        eventConsumerBufferSize: 10
        failureRateThreshold: 50
        minimumNumberOfCalls: 5
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 6s
        permittedNumberOfCallsInHalfOpenState: 3
        slidingWindowSize: 10
        slidingWindowType: COUNT_BASED

* */


