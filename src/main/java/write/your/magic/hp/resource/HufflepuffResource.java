package write.your.magic.hp.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hufflepuff")
public class HufflepuffResource {

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String Welcome() {
        return "Welcome to Hufflepuff";
    }
}
