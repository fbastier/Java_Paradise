package dao.jdbc;

import dao.PlaceDao;
import model.Place;

import java.util.List;

public class JdbcPlaceDao extends JdbcDao implements PlaceDao<Long, Place> {

    @Override
    public Long createPlace(Place place) {
        return null;
    }

    @Override
    public Place findPlaceById(Long id) {
        return null;
    }

    @Override
    public Boolean updatePlace(Place place) {
        return null;
    }

    @Override
    public Boolean removePlace(Place place) {
        return null;
    }

    @Override
    public List<Place> findAllPlace() {
        return null;
    };
}
