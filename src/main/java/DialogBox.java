import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class DialogBox extends HBox {

    private Label text;
    private ImageView displayPicture;

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the
     * right.
     */
    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
    }

    public static DialogBox getUserDialog(String s, Image i) {
        var db = new DialogBox(s, i);
        db.setSpacing(20);
        db.setStyle("-fx-background-color: #f8cffc; -fx-padding: 10; -fx-background-radius: 10;");
        return db;
    }

    public static DialogBox getDukeDialog(String s, Image i) {
        var db = new DialogBox(s, i);
        db.setSpacing(20);
        db.setStyle("-fx-background-color: #edfccf; -fx-padding: 10; -fx-background-radius: 10;");
        db.flip();
        return db;
    }

    public DialogBox(String s, Image i) {
        text = new Label(s);
        displayPicture = new ImageView(i);
        this.getChildren().addAll(text, displayPicture);

        Circle clip = new Circle(50, 50, 50); // CenterX, CenterY, Radius
        displayPicture.setClip(clip); // Clip the ImageView into a circle

        // Styling the dialog box
        text.setWrapText(true);
        displayPicture.setFitWidth(100.0);
        displayPicture.setFitHeight(100.0);
        this.setAlignment(Pos.TOP_RIGHT);
    }
}
