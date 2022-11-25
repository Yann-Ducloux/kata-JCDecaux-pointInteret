package service;

import Interface.IZoneService;
import model.PointInteret;
import model.Zone;

import java.util.List;

/**
 * service qui gére le service les points interets d'une zone.
 */
public class ZoneService implements IZoneService {

    /**
     * The Increment.
     */
    private static final double INCREMENT = 0.5;

    @Override
    public boolean estPointInteretDansLaZone(double latitude, double longitude, double minLatitude, double minLongitude) {
        return latitude >= minLatitude &&latitude <= minLatitude + INCREMENT &&
                longitude >= minLongitude && longitude <= minLongitude + INCREMENT;
    }
    @Override
    public int calcul(List<PointInteret> pointInterets, Zone zone) {
        int nombrePointInteretDansLaZone = 0;
        for (PointInteret pointInteret: pointInterets) {
            if(estPointInteretDansLaZone(pointInteret.getLat(), pointInteret.getLon(), zone.getMinLat(), zone.getMinLon())) {
                nombrePointInteretDansLaZone++;
            }
        }
        return nombrePointInteretDansLaZone;
    }
}
