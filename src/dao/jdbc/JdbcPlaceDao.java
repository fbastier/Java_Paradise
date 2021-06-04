package dao.jdbc;

import dao.PlaceDao;
import model.Place;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPlaceDao extends JdbcDao implements PlaceDao<Long, Place> {

    @Override
    public Long createPlace(Place placeToCreate) {
        Long id = null;
        //Place createdPlace = null;

        String query  = "INSERT INTO PlaceTable(name) VALUES (?)";

        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pSt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            pSt.setString(1, placeToCreate.getName());
            pSt.execute();

            ResultSet rs = pSt.getGeneratedKeys();
            rs.next();
            id = rs.getLong(1);
            //createdPlace = findPlaceById(id);

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
    public Place findPlaceById(Long id) {
        Place placeFound = null;

        String query = "SELECT * FROM PlaceTable WHERE id = ?";

        try (PreparedStatement pSt = ConnectionManager.getConnection().prepareStatement(query)) {
            pSt.setLong(1, id);
            ResultSet rs = pSt.executeQuery();
            if (rs.next()) {
                placeFound = mapToPlace(rs);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return placeFound;
    }

    @Override
    public boolean updatePlace(Place placeToUpdate) {
        int updateRows = 0;
        String query = "UPDATE PlaceTable SET name = ? WHERE id = ?";
        try(PreparedStatement pSt = ConnectionManager.getConnection().prepareStatement(query)) {
            pSt.setString(1, placeToUpdate.getName());
            pSt.setLong(2, placeToUpdate.getId());
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
    public boolean removePlace(Place placeToDelete) {
        boolean placeDeleted = false;
        String query = "DELETE FROM PlaceTable WHERE id = ? ";
        try(PreparedStatement pSt = ConnectionManager.getConnection().prepareStatement(query)) {
            pSt.setLong(1,placeToDelete.getId());
            placeDeleted = pSt.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try{
                connection.rollback();
            } catch (SQLException f) {
                f.printStackTrace();
            }
        }
        return placeDeleted;
    }

    @Override
    public List<Place> findAllPlace() {
        List<Place> placeList = new ArrayList<>();
        String query = "SELECT * FROM PlaceTable";
        try(Statement st = ConnectionManager.getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                placeList.add(mapToPlace(rs));
                }
            } catch (SQLException e){
            e.printStackTrace();
            }
        return placeList;
    }

    private Place mapToPlace(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        Place pl = new Place();
        pl.setId(id);
        pl.setName(name);
        return pl;
    }
}
