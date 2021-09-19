package gr.bet4match.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Time;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		long millis=System.currentTimeMillis();
		Date date=new Date(millis);
		Time sqlTime1 = Time.valueOf("18:45:20");
		for(MatchEntity product : matchRepository.findAll()) {
			System.out.println("Id: " + product.getId());
			System.out.println("Description: " + product.getDescription());
			System.out.println("================================");
		}
		MatchEntity newMatch = new MatchEntity("ELA       ", date,sqlTime1,"test", "test2", 1);
		System.out.println("newMatch " +newMatch.getDescription() + newMatch.getMatchDate() + newMatch.getMatchTime());
		matchRepository.save(newMatch);
		return String.format("Hello %s!", name);
	}*/
}
