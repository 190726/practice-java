package toby.practice.generic;

import com.sk.my.app.MyAppApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ParameterizedTypeTest {
    public static void main(String[] args) {
        RestTemplate rt = new RestTemplate();
        List<MyAppApplication.User> body = rt.exchange("http://localhost:8080/users",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MyAppApplication.User>>(){}).getBody();
        body.forEach(System.out::println);
    }
}
