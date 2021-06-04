package dao;

import java.util.List;

public interface TripDao<ID, T> {
    ID createTrip(T object);
    T findTrip(ID id);
    boolean updateTrip(T object);
    boolean removeTrip(T object);
    List<T> findAllTrip();
}
