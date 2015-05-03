package util;

import java.time.LocalTime;
import java.sql.Time;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time>  {

	@Override
	public Time convertToDatabaseColumn(LocalTime attribute) {
		
		if (attribute!=null) 
			return Time.valueOf(attribute);
		else 
			return null;
	}

	@Override
	public LocalTime convertToEntityAttribute(Time dbData) {
		if (dbData!=null)
			
			return dbData.toLocalTime();
		else 
			return null;
	}

}
