package dao;

import dao.jdbc.JdbcPlaceDao;
import dao.jdbc.JdbcTripDao;

public class DaoFactory {

    private DaoFactory() {
    }

    public static JdbcTripDao getTripDao() {
        return null;
    }

    public static JdbcPlaceDao getPlaceDao() {
        return null;
    }
}
