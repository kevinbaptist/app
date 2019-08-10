package ovh.ladon.restapidocker.springbootdocker.random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(value = "/random")
public class RandomController {
    private static final int MAX = 10;
    private static final int MIN = 0;


    @GetMapping
    public int getRandom() {
        Random random = new Random();
        return random.nextInt((MAX - MIN) + 1) + MIN;
    }
}
