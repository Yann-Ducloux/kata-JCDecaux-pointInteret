package service;

import Interface.IPointInteretFichierService;
import Interface.IZoneService;
import model.PointInteret;
import model.Zone;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * service de test qui test les points interets d'une zone.
 */
class ZoneServiceTest {


    private final IPointInteretFichierService pointInteretFichierCSVService = new PointInteretFichierCsvService();
    private final IZoneService pointInteretZoneService = new ZoneService();

    /**
     * Nombre de point interet dans une zone.
     *
     * @throws IOException the io exception
     */
    @Test
    public void nombre_de_point_interet_dans_une_zone() throws IOException {
        //GIVEN
        List<PointInteret> pointInterets = PointInteretUtils.getPointInterets();
        int nombrePointInteretDansLaZoneAttendue = 2;
        Zone zone = new Zone(6.5, -7);

        //WHEN
        int nombrePointInteretDansLaZone = pointInteretZoneService.calcul(pointInterets, zone);

        //THEN
        assertEquals(nombrePointInteretDansLaZoneAttendue, nombrePointInteretDansLaZone);
    }
}