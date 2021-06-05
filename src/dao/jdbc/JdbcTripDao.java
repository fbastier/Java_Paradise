package dao.jdbc;

import dao.TripDao;
import model.Trip;
import util.ConnectionManager;

import java.sql.*;
import java.util.List;

public class JdbcTripDao extends JdbcDao implements TripDao<Long, Trip> {

    @Override
    public Long createTrip(Trip object) {
        Long id = null;

        String query  = "INSERT INTO TripTable(departurePlace, arrivalPlace, price) VALUES (?, ?, ?)";

        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pSt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            pSt.setString(1, object.getDeparturePlace().getName());
            pSt.setString(2, object.getArrivalPlace().getName());
            pSt.setFloat(3, object.getPrice());
            pSt.execute();

            ResultSet rs = pSt.getGeneratedKeys();
            rs.next();
            id = rs.getLong(1);

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException f){
                f.printStackTrace();
            }
        }
        return id;
    }


    @Override
    public Trip findTrip(Long aLong) {
        return null;
    }

    @Override
    public boolean updateTrip(Trip object) {
        return false;
    }

    @Override
    public boolean removeTrip(Trip object) {
        return false;
    }

    @Override
    public List<Trip> findAllTrip() {
        return null;
    }
}
