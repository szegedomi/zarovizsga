package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country){
        List<String> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select name from dog_types where country = ? order by name"))
        {
            stmt.setString(1,country.toUpperCase());
            return getResults(stmt, country);
        }
        catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect to database", sqlException);
        }
    }


    private List<String> getResults(PreparedStatement stmt, String country){
        List<String> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                result.add(rs.getString(1).toLowerCase());
            }
            return result;
        }
        catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot get resultset!", sqlException);
        }
    }
}
