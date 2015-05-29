package domain;

import java.io.Serializable;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public abstract class AbstractEntity implements JsonItem, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public JsonObject toJson() {
		
		JsonObjectBuilder builder = Json.createObjectBuilder();
		addJson(builder);
		return builder.build();
	}
	
	
	

}
