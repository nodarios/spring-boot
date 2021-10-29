package pak.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pak.dtos.GreetingDto;
import pak.dtos.GreetingPojo;
import pak.enums.Country;

@Mapper(componentModel = "spring")
public abstract class GreetingMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "country", target = "nationality", qualifiedByName = "mapCountryToNationality")
    public abstract GreetingDto mapPojoToDto(GreetingPojo greetingPojo);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "nationality", target = "country", qualifiedByName = "mapNationalityToCountry")
    public abstract GreetingPojo mapDtoToPojo(GreetingDto greetingDto);

    @Named("mapCountryToNationality")
    protected String mapCountryToNationality(Country country) {
        return country.name();
    }

    @Named("mapNationalityToCountry")
    protected Country mapNationalityToCountry(String nationality) {
        return Country.valueOf(nationality);
    }

}
