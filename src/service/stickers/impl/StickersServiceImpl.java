package service.stickers.impl;

import service.stickers.StickersService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class StickersServiceImpl implements StickersService {


    public void criarStickers(InputStream inputStream, String nomeArquivo) throws IOException {

        //leitura da imagem
//        InputStream inputStream =
//                new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_Ratio0.6716_AL_.jpg")
//                        .openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //cria nova imagem com transparencia e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copia a imagem original pra uma nova imagem(em memoria)
        Graphics graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configura a fonte
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 70);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        //escreve uma frase ma nova imagem
        graphics.drawString("TOPZEIRA!", 100, novaAltura - 100);


    }
}
