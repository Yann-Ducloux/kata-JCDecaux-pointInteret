package model;

/**
 * @author Yann Ducloux
 * Défini le Point interet.
 */
public class PointInteret {
    /**
     * The Identifiant.
     */
    protected String identifiant;
    /**
     * The Lat.
     */
    protected double lat;
    /**
     * The Lon.
     */
    protected double lon;

    /**
     * Instantiates a new Point interet.
     *
     * @param identifiant the identifiant
     * @param lat         the lat
     * @param lon         the lon
     */
    public PointInteret(String identifiant, double lat, double lon) {
        this.identifiant = identifiant;
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    /**
     * Instantiates a new Point interet.
     */
    public PointInteret() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointInteret that = (PointInteret) o;
        return Double.compare(that.lat, lat) == 0 && Double.compare(that.lon, lon) == 0 && identifiant.equals(that.identifiant);
    }
}
