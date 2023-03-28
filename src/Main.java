import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    try {
      String css =
        this.getClass().getResource("CSS\\default.css").toExternalForm();
      Parent root = FXMLLoader.load(getClass().getResource("FXML\\Main.FXML"));
      Scene scene = new Scene(root);
      scene.getStylesheets().add(css);
      primaryStage.initStyle(StageStyle.UNDECORATED);
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Override
  public void stop() {
    File locvalue = new File("C:\\Windows\\Temp\\Temporary.CLT");
    locvalue.delete();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
