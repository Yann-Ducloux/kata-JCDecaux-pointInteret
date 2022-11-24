package model;

import java.util.Objects;

/**
 * @author Yann Ducloux
 * Défini la Zone dense.
 */
public class ZoneDense {
    /**
     * The Min lat.
     */
    protected double minLat;
    /**
     * The Max lat.
     */
    protected double maxLat;
    /**
     * The Min lon.
     */
    protected double minLon;
    /**
     * The Max lon.
     */
    protected double maxLon;

    /**
     * Instantiates a new Zone dense.
     */
    public ZoneDense() {
    }

    /**
     * Instantiates a new Zone dense.
     *
     * @param minLat the min lat
     * @param maxLat the max lat
     * @param minLon the min lon
     * @param maxLon the max lon
     */
    public ZoneDense(double minLat, double maxLat, double minLon, double maxLon) {
        this.minLat = minLat;
        this.maxLat = maxLat;
        this.minLon = minLon;
        this.maxLon = maxLon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZoneDense ZoneDense = (ZoneDense) o;
        return Double.compare(ZoneDense.minLat, minLat) == 0 && Double.compare(ZoneDense.minLon, minLon) == 0 && Double.compare(ZoneDense.maxLat, maxLat) == 0 && Double.compare(ZoneDense.maxLon, maxLon) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minLat, maxLat, minLon, maxLon);
    }
}
