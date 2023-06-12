package write.your.magic.hp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import write.your.magic.hp.model.Slytherin;
import write.your.magic.hp.repository.SlytherinRepository;

import java.util.List;

@Service
public class SlytherinService {
    @Autowired
    private SlytherinRepository slytherinRepository;

    public List<Slytherin> findAll() {
        return slytherinRepository.findAll();
    }
}
