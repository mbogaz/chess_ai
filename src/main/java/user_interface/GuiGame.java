package user_interface;

import config.Constants;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Piece;
import util.BoardUtil;
import util.FxUtil;

public class GuiGame extends Application {

    private GridPane gridPane;
    private Piece[][] board;
    private double cellSize;
    private ImageView selected;
    private final Pane selectedPane;

    public GuiGame() {
        selectedPane = new Pane();
        selectedPane.setStyle("-fx-background-color: aqua");
        selectedPane.setOpacity(0.3);
        board = BoardUtil.initBoard();
    }

    private void draw() {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                Pane pane = new Pane();
                pane.setPrefSize(100, 100);
                pane.toBack();
                pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {
                        int y = GridPane.getColumnIndex((Node) event.getSource());
                        int x = GridPane.getRowIndex((Node) event.getSource());
                        if (selected != null) {
                            GridPane.setColumnIndex(selected, y);
                            GridPane.setRowIndex(selected, x);
                            gridPane.getChildren().remove(selectedPane);
                        }
                    }
                });
                gridPane.add(pane, j, i);
                Piece piece = board[i][j];
                if (piece != null) {
                    gridPane.add(createImageView(cellSize, piece), j, i);
                }
            }
        }

    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chess");

        gridPane = FxUtil.loadView("fxml/main.fxml");
        cellSize = gridPane.getColumnConstraints().get(0).getPrefWidth();
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        draw();
    }

    private ImageView createImageView(double cellSize, Piece piece) {
        final ImageView view = new ImageView();
        view.setFitHeight(cellSize);
        view.setFitWidth(cellSize);
        view.setImage(FxUtil.createImage(piece));
        view.toFront();
        view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                selected = view;
                GridPane board = (GridPane) view.getParent();
                if (selected != null) {
                    board.getChildren().remove(selectedPane);
                }
                board.add(selectedPane, GridPane.getColumnIndex(view), GridPane.getRowIndex(view));
            }
        });
        return view;
    }
}
