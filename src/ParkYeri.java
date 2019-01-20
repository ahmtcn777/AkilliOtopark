import javafx.scene.control.Button;
import java.sql.SQLException;

public class ParkYeri extends DbParkYeri {
    private String parkAdi;
    private int durum;
    private Button btn;

    public ParkYeri() {
    }

    public ParkYeri(String parkAdi, int durum, Button btn) throws SQLException, ClassNotFoundException {
        this.parkAdi = parkAdi;
        this.durum = durum;
        this.btn = btn;
        this.btn.getStylesheets().add("bos.css");
        this.btn.getStyleClass().add("bos");
        init(this.getParkAdi());
    }

    private void init(String parkAdi) throws SQLException, ClassNotFoundException {
        int parkDurumu;
        parkDurumu = durumCek("SELECT durum FROM parkyerleri WHERE parkyeri="+parkAdi,"durum");
        if(parkDurumu == 0){
            this.setDurum(0);
            //this.btn.setText("BOŞ");
            this.btn.setStyle("-fx-background-color:#00FF00;");
        }
        else {
            this.setDurum(1);
            //this.btn.setText("DOLU");
            this.btn.setStyle("-fx-background-color:#FF0000");
        }
    }

    public String getParkAdi() {
        return parkAdi;
    }

    public Button getBtn() {
        return btn;
    }

    public int getDurum() {
        return durum;
    }


    public void setParkAdi(String parkAdi) {
        this.parkAdi = parkAdi;
    }


    public void setDurum(int durum) {
        this.durum = durum;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }


    public void durumDegistir() throws SQLException, ClassNotFoundException {
        if(this.getDurum() == 0){
            databaseDegistir("UPDATE parkyerleri SET durum=1 WHERE parkyeri="+getParkAdi());
            this.setDurum(1);
            this.init(this.getParkAdi());
        }
        else{
            databaseDegistir("UPDATE parkyerleri SET durum=0 WHERE parkyeri="+getParkAdi());
            this.setDurum(0);
            this.init(this.getParkAdi());
        }
    }
}
