package pak.entities.converter;

import pak.enums.Title;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TitleConverter implements AttributeConverter<Title, Long> {

    @Override
    public Long convertToDatabaseColumn(Title title) {
        return title.getId();
    }

    @Override
    public Title convertToEntityAttribute(Long id) {
        return Title.valueOf(id);
    }

}
