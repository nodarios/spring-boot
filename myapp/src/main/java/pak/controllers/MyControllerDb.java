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
import pak.annotation.MyAnnotation;
import pak.dtos.MyEntityDto;
import pak.entities.MyEntity;
import pak.mappers.MyEntityMapper;
import pak.services.MyService;
import pak.validators.ValidatorWrapper;

import javax.validation.Valid;
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
    @MyAnnotation
    public MyEntityDto addMyEntity(@RequestBody @Valid MyEntityDto dto) {
        MyEntity entity = myService.save(mapper.mapDtoToEntity(dto));
        return mapper.mapEntityToDto(entity);
    }

    @PutMapping("/my-entities")
    public MyEntityDto updateMyEntity(@RequestBody MyEntityDto dto) {
        ValidatorWrapper.validate(dto);
        MyEntity entity = myService.save(mapper.mapDtoToEntity(dto));
        return mapper.mapEntityToDto(entity);
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
    public MyEntityDto getMyEntity(@PathVariable Long id) {
        return mapper.mapEntityToDto(myService.findById(id));
    }

    @GetMapping("/my-entities/by-name/{name}")
    public MyEntityDto getMyEntityByName(@PathVariable String name) {
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
