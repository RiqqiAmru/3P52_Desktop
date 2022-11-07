package d_riqqi;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class KoneksiRiqqi {

    protected Connection conn;
    protected Statement stmt;

    //konstrutor
    public KoneksiRiqqi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                conn = (Connection) DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/telepon_db_riqqi", "root", "");
            } catch (SQLException e) {
                System.out.println("SQL ERROR : " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("DRIVER ERROR : " + e.getMessage());
        }

    }

    public Statement createStatement() throws SQLException {
        return stmt = conn.createStatement();
    }

    public static void main(String[] args) throws SQLException {
//        koneksi database
        KoneksiRiqqi conn = new KoneksiRiqqi();
        Statement stmt = conn.createStatement();

//        insert data
        try {
            String insert = "INSERT INTO buku_telepon_riqqi"
                    + "(nama, alamat, telepon, handphone) VALUES"
                    + "('budi','Pekalongan','0216149812','086422654792')";
            stmt.executeUpdate(insert);
        } catch (SQLException e) {
            System.out.println("SQL ERROR : " + e.getMessage());
        }
//          SELECT DATA
        String select = "SELECT * FROM buku_telepon_riqqi";
        ResultSet res = stmt.executeQuery(select);
        String nama = "";
        while (res.next()) {
            nama = res.getString("nama");
        }
        System.out.println("nama : " + nama);

    }
}
