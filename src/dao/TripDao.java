package dao;

import java.util.List;

public interface TripDao<ID, T> {
    ID createTrip(T object);
    T findTrip(ID id);
    Boolean updateTrip(T object);
    Boolean removeTrip(T object);
    List<T> findAllTrip();
}
