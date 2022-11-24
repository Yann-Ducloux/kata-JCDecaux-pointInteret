package model;

/**
 * @author Yann Ducloux
 * Défini la Zone.
 */
public class Zone {
    /**
     * The Min latitude.
     */
    protected double minLat;
    /**
     * The Min longitude.
     */
    protected double minLon;

    /**
     * Instantiates a new Zone.
     *
     * @param minLat the min latitude
     * @param minLon the min longitude
     */
    public Zone(double minLat, double minLon) {
        this.minLat = minLat;
        this.minLon = minLon;
    }

    public double getMinLat() {
        return minLat;
    }

    public double getMinLon() {
        return minLon;
    }
}
