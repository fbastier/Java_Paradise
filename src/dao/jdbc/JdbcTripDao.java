package dao.jdbc;

import dao.TripDao;
import model.Trip;

import java.util.List;

public class JdbcTripDao extends JdbcDao implements TripDao<Long, Trip> {
    @Override
    public Long createTrip(Trip object) {
        return null;
    }

    @Override
    public Trip findTrip(Long aLong) {
        return null;
    }

    @Override
    public Boolean updateTrip(Trip object) {
        return null;
    }

    @Override
    public Boolean removeTrip(Trip object) {
        return null;
    }

    @Override
    public List<Trip> findAllTrip() {
        return null;
    }
}
