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
import pak.dtos.MyEntityDto;
import pak.entities.MyEntity;
import pak.exception.AppException;
import pak.mappers.MyEntityMapper;
import pak.services.MyService;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/db")
@RequiredArgsConstructor
public class MyControllerDb {

    private final MyService myService;
    private final MyEntityMapper mapper;

    @PostMapping("/my-entities")
    public MyEntityDto addMyEntity(@RequestBody MyEntityDto myEntityDto) {
        MyEntity result = myService.save(mapper.mapDtoToEntity(myEntityDto));
        return mapper.mapEntityToDto(result);
    }

    @PutMapping("/my-entities")
    public MyEntityDto updateMyEntity(@RequestBody MyEntityDto myEntityDto) {
        MyEntity result = myService.save(mapper.mapDtoToEntity(myEntityDto));
        return mapper.mapEntityToDto(result);
    }

    @DeleteMapping("/my-entities/{id}")
    public void deleteMyEntity(@PathVariable Long id) {
        myService.deleteById(id);
    }

    @GetMapping("/my-entities")
    public List<MyEntityDto> getMyEntities() {
        return myService.findAll().stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @GetMapping("/my-entities/{id}")
    public MyEntityDto getMyEntity(@PathVariable Long id) throws AppException {
        return mapper.mapEntityToDto(myService.findById(id));
    }

    @GetMapping("/my-entities/by-name/{name}")
    public MyEntityDto getMyEntityByName(@PathVariable String name) throws AppException {
        return mapper.mapEntityToDto(myService.findByName(name));
    }

    @GetMapping("/my-entities/by-info/{info}")
    public List<MyEntityDto> getMyEntitiesByInfo(@PathVariable String info) {
        return myService.searchByInfo(info).stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @GetMapping("time")
    public Instant getDbTime() {
        return myService.getDatabaseTime();
    }

}
