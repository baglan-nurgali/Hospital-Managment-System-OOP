package model;
import model.menu.Menu;
import model.menu.HospitalMenu;
import java.sql.Connection;
import java.sql.DriverManager;


public class Main {
    public static void main(String[] args) {
        Menu menu = new HospitalMenu();
        menu.run();
    }
}