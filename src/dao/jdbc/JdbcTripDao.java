package dao.jdbc;

import dao.TripDao;
import model.Place;
import model.Trip;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTripDao extends JdbcDao implements TripDao<Long, Trip> {

    @Override
    public Long createTrip(Trip object) {
        Long id = null;

        String query  = "INSERT INTO TripTable(departurePlace, arrivalPlace, price) VALUES (?, ?, ?)";

        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pSt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            pSt.setLong(1, object.getDeparturePlace().getId());
            pSt.setLong(2, object.getArrivalPlace().getId());
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
    public Trip findTrip(Long id) {
        Trip tripFound = null;

        String query = "SELECT * FROM TripTable WHERE id = ?";

        try (PreparedStatement pSt = ConnectionManager.getConnection().prepareStatement(query)) {
            pSt.setLong(1, id);
            ResultSet rs = pSt.executeQuery();
            if (rs.next()) {
                tripFound = mapToTrip(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tripFound;
    }

    @Override
    public boolean updateTrip(Trip tripToUpdate) {
        int updateRows = 0;

        String query = "UPDATE TripTable SET departurePlace = ?, arrivalPlace = ?, price = ?  WHERE id = ?";

        try(PreparedStatement pSt = ConnectionManager.getConnection().prepareStatement(query)) {
            pSt.setLong(1, tripToUpdate.getDeparturePlace().getId());
            pSt.setLong(2, tripToUpdate.getArrivalPlace().getId());
            pSt.setFloat(3, tripToUpdate.getPrice());
            pSt.setLong(2, tripToUpdate.getId());
            updateRows = pSt.executeUpdate();
            connection.commit();
        }catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }catch (SQLException f) {
                f.printStackTrace();
            }
        }
        return (updateRows>0);
    }

    @Override
    public boolean removeTrip(Trip tripToDelete) {
        boolean tripDeleted = false;
        String query = "DELETE FROM TripTable WHERE id = ? ";
        try(PreparedStatement pSt = ConnectionManager.getConnection().prepareStatement(query)) {
            pSt.setLong(1,tripToDelete.getId());
            tripDeleted = pSt.execute();
            ConnectionManager.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try{
                ConnectionManager.getConnection().rollback();
            } catch (SQLException f) {
                f.printStackTrace();
            }
        }
        return tripDeleted;
    }

    @Override
    public List<Trip> findAllTrip() {
        List<Trip> tripList = new ArrayList<>();
        String query = "SELECT * FROM TripTable";
        try(Statement st = ConnectionManager.getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tripList.add(mapToTrip(rs));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return tripList;
    }

    private Trip mapToTrip(ResultSet rs) throws SQLException {
        JdbcPlaceDao jdbcPlaceDao = new JdbcPlaceDao();
        Long id = rs.getLong("id");
        Long departurePlace = rs.getLong("departurePlace");
        Long arrivalPlace = rs.getLong("arrivalPlace");
        Float price = rs.getFloat("price");
        return new Trip (id,jdbcPlaceDao.findPlaceById(departurePlace),jdbcPlaceDao.findPlaceById(arrivalPlace),price );
    }
}
