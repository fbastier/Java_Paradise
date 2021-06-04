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
