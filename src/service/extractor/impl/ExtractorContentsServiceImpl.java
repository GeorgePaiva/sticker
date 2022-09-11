package service.extractor.impl;

import domain.Contents;
import service.extractor.ExtractorContentsService;
import util.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractorContentsServiceImpl implements ExtractorContentsService {

    public List<Contents> extractorContents(String body) {

        //Pegar só os dados que nos interessa(titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> attributesList = parser.parse(body);

        List<Contents> contentsList = new ArrayList<>();

        //popular a lista de conteudos
        for (Map<String, String> attributes : attributesList) {
            String title = attributes.get("title");
            String image = attributes.get("image").replace("(@+)(.*).jpg", "$1.jpg");
            var content = new Contents(title, image);
            contentsList.add(content);
        }

        return contentsList;
    }
}
