package com.onei;

import com.onei.irishrail.wsdl.ArrayOfObjStationData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner lookup(TrainClient trainClient) {
        return args -> {
            String country = "SKILL";

            if (args.length > 0) {
                country = args[0];
            }
            ArrayOfObjStationData station = trainClient.getStationByCode(country);
            System.out.println(station);
        };
    }
}