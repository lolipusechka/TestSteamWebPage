package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UtilReadConfig {

    private  Reader reader;
    private  JsonNode parser;

    public UtilReadConfig() {
        try {
            reader = Files.newBufferedReader(Paths.get("src/test/java/resources/Config.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            parser = objectMapper.readTree(this.reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getWindowSize() {
        String width = "", height = "";
        try {
            for (JsonNode windowSizes : parser.path("windows_size")) {
                width = windowSizes.path("width").asText();
                height = windowSizes.path("height").asText();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return width + "," + height;
    }

    public int getTimeOutInSeconds() {
        return parser.path("timeOutInSeconds").asInt();
    }

    public int getPauseInMilliSeconds() {
        return parser.path("pauseInMilliSeconds").asInt();
    }

    public String getLanguage() {
        return parser.path("language").asText();
    }

}