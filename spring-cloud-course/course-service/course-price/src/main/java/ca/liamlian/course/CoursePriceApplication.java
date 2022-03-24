package ca.liamlian.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
// Spring Cloud has removed Hystrix in later versions
@EnableCircuitBreaker
public class CoursePriceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoursePriceApplication.class, args);
    }
}
