package com.kuaishou.esp.langchain4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-14
 */
@SpringBootApplication(scanBasePackages = {"com.kuaishou.esp.langchain4j"})
public class EspHhswAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EspHhswAppApplication.class, args);
    }
}
