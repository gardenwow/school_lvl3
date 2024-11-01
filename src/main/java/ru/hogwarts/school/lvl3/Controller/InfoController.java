package ru.hogwarts.school.lvl3.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.lvl3.Model.Faculty;

import java.util.stream.Stream;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Value("${server.port}")
    private String port;


    @GetMapping("/getPort")
    public ResponseEntity<String> getPort(){
        return ResponseEntity.ok(port);
    }

    @GetMapping("/getSum")
    public Integer getSum(){
        int sum = Stream
                .iterate(1, a -> a +1)
                .parallel()
                .limit(1_000_000)
                .reduce(0, (a, b) -> a + b );
        return sum;
    }

}
