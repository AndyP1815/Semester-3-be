package Skect

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan


@SpringBootApplication
@EntityScan("Skect.repositories.Entity")
public class SkectApplication {

     public static void main(String[] args) {
        SpringApplication.run(SkectApplication.class, args)
    }

}
