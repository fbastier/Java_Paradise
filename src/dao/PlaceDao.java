package dao;

import java.util.List;

public interface PlaceDao<ID, P> {
    ID createPlace(P object);
    P findPlaceById(ID id);
    boolean updatePlace(P object);
    boolean removePlace(P object);
    List<P> findAllPlace();
}
