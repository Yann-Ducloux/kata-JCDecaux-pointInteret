package Interface;

import model.PointInteret;
import model.ZoneDense;

import java.util.List;

/**
 * @author Yann Ducloux
 * Interface qui gére les services zones denses.
 */
public interface IZoneDenseService {
    /**
     * les zones plus dense.
     *
     * @param pointInterets the point interets
     * @return the list des zone dense
     */
    List<ZoneDense> recuperer(List<PointInteret> pointInterets);
    /**
     * Recuperer toutes les zones.
     *
     * @param pointInterets the point interets
     * @return the list des zone dense
     */
    List<ZoneDense> touteLesZones(List<PointInteret> pointInterets);

    /**
     * Nombre maximum de point interet dans les zones les plus dense.
     *
     * @param zoneResponses the zone responses
     * @return the long nombre maximum de point interet dans zone les plus dense
     */
    long nombreMaximumPointInteretDansZoneLesPlusDense(List<ZoneDense> zoneResponses);

    /**
     * calcul les zones les plus dense.
     *
     * @param zoneResponses the zone responses
     * @return the list des zone dense
     */
    List<ZoneDense> calculer(List<ZoneDense> zoneResponses);
}
