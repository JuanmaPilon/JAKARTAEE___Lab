package ModuloPeaje.messaging;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonWriter;
import lombok.Data;

import java.io.StringReader;
import java.io.StringWriter;

@Data

public class RealizadoMessage {

    private String tag;
    private Long vehiculo;
    private String matricula;

    public RealizadoMessage(String tag, Long vehiculo, String matricula) {
        this.tag = tag;
        this.vehiculo = vehiculo;
        this.matricula = matricula;
    }

    public String toJson() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("tag", this.tag)
                .add("vehiculo", Long.toString(this.vehiculo))
                .add("matricula", this.matricula).build();

        StringWriter sw = new StringWriter();
        try (JsonWriter jsonWriter = Json.createWriter(sw)) {
            jsonWriter.write(jsonObject);
        }
        return sw.toString();
    }

    public static RealizadoMessage readFromJson(String jsonPagoRealizada) {
        JsonReader reader = Json.createReader(new StringReader(jsonPagoRealizada));
        JsonObject json = reader.readObject();
        return new RealizadoMessage(
                json.getString("tag"),
                Long.valueOf(json.getString("vehiculo")),
                json.getString("matricula"));
    }

}
