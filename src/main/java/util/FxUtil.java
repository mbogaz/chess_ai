package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import model.Piece;

import java.io.IOException;
import java.util.Locale;

public class FxUtil {

    public static Image createImage(Piece piece) {
        String imageUrl = "icons/"
                + piece.getSide().name().toLowerCase(Locale.ENGLISH)
                + "_"
                + piece.getClass().getSimpleName().toLowerCase(Locale.ENGLISH)
                + ".png";

        return new Image(FxUtil.class.getClassLoader().getResource(imageUrl).toString());
    }

    public static <T> T loadView(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FxUtil.class.getClassLoader().getResource(fxmlPath));
        try {
            return (T) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR ON LOADING : " + fxmlPath);
        }
    }
}
