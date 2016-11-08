package sjh.spring.config

import java.text.SimpleDateFormat

import org.springframework.expression.ParseException

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jsonparser,
            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
        String date = jsonparser.getText()

		println "${date}를 변환 중"				
        try {
            return format.parse(date)
        } catch (ParseException e) {
            throw new RuntimeException(e)
        }

    }

}
