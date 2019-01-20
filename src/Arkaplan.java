import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.*;

class Arkaplan extends Thread{
    Parent root;

    Arkaplan(Parent root) throws IOException {
        this.root = root;
    }


    public void run(){
        while (true){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                runThread();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void runThread() throws SQLException, ClassNotFoundException {
        int durum;
        int count = 0;
        for(int i = 0; i < 26; i++){
            durum = dbBosYerBul(i);
            if(durum == 0){
                count++;
                if(i == 0 || i == 1 || i == 2){
                    butunYollariSondur();
                    Button yol_1 = (Button) root.lookup("#yol_1");
                    yol_1.setStyle("-fx-background-color:#00FF00;");
                    System.out.println("yol:L1");
                }
                else if (i == 3 || i == 4 || i == 5){
                    butunYollariSondur();
                    Button yol_1 = (Button) root.lookup("#yol_1");
                    yol_1.setStyle("-fx-background-color:#00FF00;");
                    Button yol_2 = (Button) root.lookup("#yol_2");
                    yol_2.setStyle("-fx-background-color:#00FF00;");
                    System.out.println("yol:L1->L2");
                }
                else if (i == 8 || i == 9 || i == 10 || i == 11 ){
                    butunYollariSondur();
                    Button yol_1 = (Button) root.lookup("#yol_1");
                    yol_1.setStyle("-fx-background-color:#00FF00;");
                    Button yol_4 = (Button) root.lookup("#yol_4");
                    yol_4.setStyle("-fx-background-color:#00FF00;");
                    System.out.println("yol:L1->L4");
                }
                else if (i == 6){
                    butunYollariSondur();
                    Button yol_1 = (Button) root.lookup("#yol_1");
                    yol_1.setStyle("-fx-background-color:#00FF00;");
                    Button yol_2 = (Button) root.lookup("#yol_2");
                    yol_2.setStyle("-fx-background-color:#00FF00;");
                    System.out.println("yol:L1->L2");
                }
                else if(i == 15 || i == 16 || i == 12 || i == 13 || i == 14){
                    butunYollariSondur();
                    Button yol_1 = (Button) root.lookup("#yol_1");
                    yol_1.setStyle("-fx-background-color:#00FF00;");
                    Button yol_4 = (Button) root.lookup("#yol_4");
                    yol_4.setStyle("-fx-background-color:#00FF00;");
                    Button yol_5 = (Button) root.lookup("#yol_5");
                    yol_5.setStyle("-fx-background-color:#00FF00;");
                    System.out.println("yol:L1->L4->L5");
                }
                else if(i == 7){
                    butunYollariSondur();
                    Button yol_1 = (Button) root.lookup("#yol_1");
                    yol_1.setStyle("-fx-background-color:#00FF00;");
                    Button yol_2 = (Button) root.lookup("#yol_2");
                    yol_2.setStyle("-fx-background-color:#00FF00;");
                    Button yol_3 = (Button) root.lookup("#yol_3");
                    yol_3.setStyle("-fx-background-color:#00FF00;");
                    System.out.println("yol:L1->L2->L3");
                }
                else if (i == 22 || i == 21 || i == 19 || i == 20){
                    butunYollariSondur();
                    Button yol_1 = (Button) root.lookup("#yol_1");
                    yol_1.setStyle("-fx-background-color:#00FF00;");
                    Button yol_2 = (Button) root.lookup("#yol_2");
                    yol_2.setStyle("-fx-background-color:#00FF00;");
                    Button yol_6 = (Button) root.lookup("#yol_6");
                    yol_6.setStyle("-fx-background-color:#00FF00;");
                    System.out.println("yol:L1->L2->L6");
                }
                else{
                    butunYollariSondur();
                    Button yol_1 = (Button) root.lookup("#yol_1");
                    yol_1.setStyle("-fx-background-color:#00FF00;");
                    Button yol_2 = (Button) root.lookup("#yol_2");
                    yol_2.setStyle("-fx-background-color:#00FF00;");
                    Button yol_6 = (Button) root.lookup("#yol_6");
                    yol_6.setStyle("-fx-background-color:#00FF00;");
                    Button yol_7 = (Button) root.lookup("#yol_7");
                    yol_7.setStyle("-fx-background-color:#00FF00;");
                    System.out.println("yol:L1->L2->L6->L7");
                }
                break;
            }
        }
        if(count == 0){
            butunYollariSondur();
            System.out.println("otopark dolu");
        }
    }

    public void butunYollariSondur(){

        Button yol_1 = (Button) root.lookup("#yol_1");
        yol_1.setStyle("-fx-background-color:#FF0000;");

        Button yol_2 = (Button) root.lookup("#yol_2");
        yol_2.setStyle("-fx-background-color:#FF0000;");

        Button yol_3 = (Button) root.lookup("#yol_3");
        yol_3.setStyle("-fx-background-color:#FF0000;");

        Button yol_4 = (Button) root.lookup("#yol_4");
        yol_4.setStyle("-fx-background-color:#FF0000;");

        Button yol_5 = (Button) root.lookup("#yol_5");
        yol_5.setStyle("-fx-background-color:#FF0000;");

        Button yol_6 = (Button) root.lookup("#yol_6");
        yol_6.setStyle("-fx-background-color:#FF0000;");

        Button yol_7 = (Button) root.lookup("#yol_7");
        yol_7.setStyle("-fx-background-color:#FF0000;");

    }

    public int dbBosYerBul(int parkyeri) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;


        Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mariadb://localhost/akilliotopark", "root", "");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT durum FROM parkyerleri WHERE parkyeri="+parkyeri);
        int durum = 0;
        while (resultSet.next()){
            durum = resultSet.getInt("durum");
        }
        statement.close();
        connection.close();
        return durum;
    }
}
