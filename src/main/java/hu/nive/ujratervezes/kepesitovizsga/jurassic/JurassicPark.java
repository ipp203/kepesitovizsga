package hu.nive.ujratervezes.kepesitovizsga.jurassic;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {
    private final DataSource dataSource;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation() {
        String sql = "SELECT DISTINCT(breed) AS name FROM dinosaur " +
                "WHERE actual > expected " +
                "ORDER BY breed ASC";

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            List<String> result = new ArrayList<>();
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
            return result;

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect to database", sqle);
        }
    }
}
