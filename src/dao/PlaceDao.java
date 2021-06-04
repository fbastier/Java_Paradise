package dao;

import java.util.List;

public interface PlaceDao<ID, P> {
    ID createPlace(P object);
    P findPlaceById(ID id);
    Boolean updatePlace(P object);
    Boolean removePlace(P object);
    List<P> findAllPlace();
}
