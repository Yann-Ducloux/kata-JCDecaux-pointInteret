package Interface;

import model.PointInteret;
import model.Zone;

import java.util.List;

/**
 * Interface qui gére les services les points interets d'une zone.
 */
public interface IZoneService {

    /**
     * Nombre point interet dans la zone.
     *
     * @param pointInteret the point interet
     * @param zone         the zone
     * @return the int du nombre point interet dans la zone
     */
    int calcul(List<PointInteret> pointInteret, Zone zone);

    /**
     * Est point interet dans la zone boolean.
     *
     * @param latitude     the latitude
     * @param longitude    the longitude
     * @param minLatitude  the min latitude
     * @param minLongitude the min longitude
     * @return the boolean
     */
    boolean estPointInteretDansLaZone(double latitude, double longitude, double minLatitude, double minLongitude);

}
