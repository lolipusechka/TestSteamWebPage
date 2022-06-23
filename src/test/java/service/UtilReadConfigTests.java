package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UtilReadConfigTests {

    private Reader reader;
    private JsonNode parser;

    public UtilReadConfigTests() {
        try {
            reader = Files.newBufferedReader(Paths.get("src/test/java/resources/ConfigTests.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            parser = objectMapper.readTree(this.reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return parser.path("url").asText();
    }

    public String getCheckBoxOs() {
        return parser.path("checkBoxByOs").asText();
    }

    public String getCheckBoxByNumberOfPlayers() {
        return parser.path("checkBoxByNumberOfPlayers").asText();
    }

    public String getCheckBoxByTag() {
        return parser.path("checkBoxByTag").asText();
    }

}