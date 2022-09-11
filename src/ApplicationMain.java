import config.ClientHttp;
import domain.Contents;
import service.extractor.ExtractorContentsService;
import service.extractor.impl.ExtractorContentsServiceImpl;
import service.stickers.impl.StickersServiceImpl;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class ApplicationMain {

    public static void main(String[] args) throws Exception {

        String url = "https://imdb-api.com/en/API/Top250Movies/k_qwcuiexj";
        ExtractorContentsService extractor = new ExtractorContentsServiceImpl();

        ClientHttp http = new ClientHttp();
        String json = http.searchData(url);

        List<Contents> contents = extractor.extractorContents(json);

        var stickers = new StickersServiceImpl();

        //Exibir e manipular os dados.
        for (int i = 0; i < 3; i++) {

            Contents content = contents.get(i);

            InputStream inputStream = new URL(content.getImage()).openStream();
            String nameFile = "saida/" + content.getTitle() + ".png";

            stickers.criarStickers(inputStream, nameFile);

            System.out.println();
            System.out.println(content.getTitle());
            System.out.println();


        }
    }

}
