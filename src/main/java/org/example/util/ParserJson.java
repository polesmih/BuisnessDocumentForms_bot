package org.example.util;

import org.example.bot.settings.ConfigSettings;
import org.example.entity.DocumentInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class ParserJson {
    private final String JSON_DOC;

    public ParserJson() {
        this.JSON_DOC = ConfigSettings.getInstance().getJsonPath();
    }

    public List<DocumentInfo> getDocumentInfoList() {
        List<DocumentInfo> infoList = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

            ((JSONArray) jsonData.get("documents")).forEach(docObj -> {
                JSONObject jsonObject = (JSONObject) docObj;

                var docIndex = ((Long) jsonObject.get("docIndex")).intValue();
                var docName = (String) jsonObject.get("docName");
                var docPath = (String) jsonObject.get("docPath");
                var docType = (String) jsonObject.get("docType");

                infoList.add(DocumentInfo.builder()
                        .docIndex(docIndex)
                        .docName(docName)
                        .docPath(docPath)
                        .docType(docType)
                        .dateCreate(LocalDateTime.now())
                        .build());
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return infoList;
    }

    private String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(JSON_DOC));
            lines.forEach(builder::append);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}