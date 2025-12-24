package kutuStech.wenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//mvn spring-boot:run

@SpringBootApplication
public class WendaApplication {
	public static void main(String[] args) {
		SpringApplication.run(WendaApplication.class, args);
		System.out.println("===== SERVIÇO WENDA TI RODANDO");
	}
}
