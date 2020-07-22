package com.api.crew.aso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.api.crew.aso.model.CrewDetails;
import com.api.crew.aso.model.CrewMemberDetails;
import com.api.crew.aso.model.FlightCrewDetails;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com.api.crew.aso" ,"com.api.crew.aso.model", "com.api.crew.aso.service", "com.api.crew.aso.configuration"})
public class Swagger2SpringBoot implements CommandLineRunner {

    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }
 
    public static void main(String[] args) throws Exception {
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

   

	class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        public int getExitCode() {
            return 10;
        }

    }
}
