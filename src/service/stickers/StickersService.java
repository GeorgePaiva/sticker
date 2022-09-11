package service.stickers;

import java.io.IOException;
import java.io.InputStream;

public interface StickersService {

    public void criarStickers(InputStream inputStream, String nomeArquivo) throws IOException;
}
