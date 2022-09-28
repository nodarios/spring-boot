package pak.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pak.dtos.MyEntityDto;
import pak.entities.MyEntity;
import pak.enums.Title;

@Mapper(componentModel = "spring")
public abstract class MyEntityMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "info", target = "info")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "titleId", target = "title", qualifiedByName = "mapTitleIdToTitle")
    public abstract MyEntity mapDtoToEntity(MyEntityDto myEntityDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "info", target = "info")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "title", target = "titleId", qualifiedByName = "mapTitleToTitleId")
    public abstract MyEntityDto mapEntityToDto(MyEntity myEntity);

    @Named("mapTitleIdToTitle")
    protected Title mapTitleIdToTitle(Long id) {
        return Title.valueOf(id);
    }

    @Named("mapTitleToTitleId")
    protected Long mapTitleToTitleId(Title title) {
        return title.getId();
    }

}
