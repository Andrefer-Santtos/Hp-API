package write.your.magic.hp.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import write.your.magic.hp.model.Slytherin;
import write.your.magic.hp.repository.SlytherinRepository;
import write.your.magic.hp.service.SlytherinService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/slytherin")
public class SlytherinResource {

    @Autowired
    SlytherinService slytherinService;

    @Autowired
    SlytherinRepository slytherinRepository;

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String Welcome() {
        return "Welcome to Slytherin";
    }

    @GetMapping("/slytherins")
    public ResponseEntity<List<Slytherin>> getAllSlytherins(@RequestParam(required = false) String criador) {
        try {
            List<Slytherin> slytherins = new ArrayList<Slytherin>();

            if (criador == null) slytherins.addAll(slytherinRepository.findAll());
            else slytherins.addAll(slytherinRepository.findByCriador(criador));

            if (slytherins.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(slytherins, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/slytherins/{id}")
    public ResponseEntity<Slytherin> getSlytherinById(@PathVariable("id") Integer id) {
        Optional<Slytherin> slytherinID = slytherinRepository.findById(id);

        return slytherinID.map(slytherin -> new ResponseEntity<>(slytherin, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/slytherins")
    public ResponseEntity<Slytherin> createSlytherin(@RequestBody Slytherin slytherin) {
        try {
            Slytherin _slytherin = slytherinRepository.save(new Slytherin(slytherin.getId(), slytherin.getCriador(), slytherin.getAnimal(), slytherin.getFantasma()));
            return new ResponseEntity<>(_slytherin, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/slytherins/{id}")
    public ResponseEntity<Slytherin> updateSlytherin(@PathVariable("id") Integer id, @RequestBody Slytherin slytherin) {
        Optional<Slytherin> slytherinData = slytherinRepository.findById(id);

        if (slytherinData.isPresent()) {
            Slytherin _slytherin = slytherinData.get();
            _slytherin.setCriador(slytherin.getCriador());
            _slytherin.setAnimal(slytherin.getAnimal());
            _slytherin.setFantasma(slytherin.getFantasma());
            return new ResponseEntity<>(slytherinRepository.save(_slytherin), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/slytherins/{id}")
    public ResponseEntity<HttpStatus> deleteSlytherin(@PathVariable("id") Integer id) {
        try {
            slytherinRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/slytherins")
    public ResponseEntity<HttpStatus> deleteAllSlytherins() {
        try {
            slytherinRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @GetMapping("/slytherins/published")
//    public ResponseEntity<List<Slytherin>> findByPublished() {
//        try {
//            List<Slytherin> slytherins = slytherinRepository.findByPublished(true);
//
//            if (slytherins.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(slytherins, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
