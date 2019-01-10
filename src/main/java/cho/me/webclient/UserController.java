package cho.me.webclient;

import cho.me.webclient.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping()
    public User[] getUsers(){

        User[] users = new User[10];

        for(int i=0;i<10;i++){
            users[i] = new User();

        }
        Flux<User> fluxUser = Flux.fromArray(users);

        return users;
    }
}
