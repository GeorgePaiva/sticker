package service.extractor;

import domain.Contents;

import java.util.List;

public interface ExtractorContentsService {

    public List<Contents> extractorContents(String json);
}
