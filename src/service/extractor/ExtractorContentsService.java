package service.extractor;

import domain.contents.Contents;

import java.util.List;

public interface ExtractorContentsService {

    public List<Contents> extractorContents(String json);
}
