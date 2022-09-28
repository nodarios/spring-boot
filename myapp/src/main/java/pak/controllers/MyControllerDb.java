package pak.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pak.entities.MyEntity;
import pak.exception.AppException;
import pak.services.MyService;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/db")
@RequiredArgsConstructor
public class MyControllerDb {

    private final MyService myService;

    @PostMapping("/my-entities")
    public MyEntity addMyEntity(@RequestBody MyEntity myEntity) {
        return myService.save(myEntity);
    }

    @PutMapping("/my-entities")
    public MyEntity updateMyEntity(@RequestBody MyEntity myEntity) {
        return myService.save(myEntity);
    }

    @DeleteMapping("/my-entities/{id}")
    public void deleteMyEntity(@PathVariable Long id) {
        myService.deleteById(id);
    }

    @GetMapping("/my-entities")
    public Iterable<MyEntity> getMyEntities() {
        return myService.findAll();
    }

    @GetMapping("/my-entities/{id}")
    public MyEntity getMyEntity(@PathVariable Long id) throws AppException {
        return myService.findById(id);
    }

    @GetMapping("/my-entities/by-name/{name}")
    public MyEntity getMyEntityByName(@PathVariable String name) throws AppException {
        return myService.findByName(name);
    }

    @GetMapping("/my-entities/by-info/{info}")
    public List<MyEntity> getMyEntitiesByInfo(@PathVariable String info) {
        return myService.searchByInfo(info);
    }

    @GetMapping("time")
    public Instant getDbTime() {
        return myService.getDatabaseTime();
    }

}
