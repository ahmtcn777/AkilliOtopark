import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    Button parkTanimla;
    Button p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25;
    Button[] allButtons = {p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25};
    @Override
    public void start(Stage primaryStage) throws IOException, SQLException, ClassNotFoundException {
        primaryStage.setTitle("Akıllı Otopark");
        primaryStage.setMaxHeight(450);
        primaryStage.setMaxWidth(500);
        primaryStage.setMinHeight(450);
        primaryStage.setMinWidth(500);
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Tanimla(root);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void Main(String[] args) {
        launch(args);
    }

    private void Tanimla(Parent root) throws SQLException, ClassNotFoundException {
        for(int i = 0; i < allButtons.length; i++){
            allButtons[i] = (Button) root.lookup("#" + i);
            ParkYeri parkYeri = new ParkYeri(""+i,0,allButtons[i]);
            parkYeri.getBtn().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        parkYeri.durumDegistir();
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}