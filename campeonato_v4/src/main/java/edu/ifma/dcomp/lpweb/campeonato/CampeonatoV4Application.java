package edu.ifma.dcomp.lpweb.campeonato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"edu.ifma.dcomp.lpweb.campeonato.model"}) // Add this line

public class CampeonatoV4Application {

	public static void main(String[] args) {
		SpringApplication.run(CampeonatoV4Application.class, args);
	}

}
