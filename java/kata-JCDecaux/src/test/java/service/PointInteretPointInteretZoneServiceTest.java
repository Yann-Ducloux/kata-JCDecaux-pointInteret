package service;

import model.PointInteret;
import model.Zone;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * service de test qui test les points interets d'une zone.
 */
class PointInteretPointInteretZoneServiceTest {


    private final PointInteretFichierCsvService pointInteretFichierCSVService = new PointInteretFichierCsvService();
    private final PointInteretZoneService pointInteretZoneService = new PointInteretZoneService();

    /**
     * Nombre de point interet dans une zone.
     *
     * @throws IOException the io exception
     */
    @Test
    public void nombre_de_point_interet_dans_une_zone() throws IOException {
        //GIVEN
        int nombrePointInteretDansLaZoneAttendue = 2;
        Zone zone = new Zone(6.5, -7);
        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append("@id,@lat,@lon\n");
        csvBuilder.append("id1,-48.6,-37.7\n");
        csvBuilder.append("id2,-27.1,8.4\n");
        csvBuilder.append("id3,6.6,-6.9\n");
        csvBuilder.append("id4,-2.3,38.3\n");
        csvBuilder.append("id5,6.8,-6.9\n");
        csvBuilder.append("id6,-2.5,38.3\n");
        csvBuilder.append("id7,0.1,-0.1\n");
        csvBuilder.append("id8,-2.1,38.1\n");
        InputStream is = new ByteArrayInputStream(csvBuilder.toString().getBytes());
        MultipartFile mockFile = new MockMultipartFile("yann", "listPointInteret.csv", "plain/text", is);

        //WHEN
        List<PointInteret> pointInterets = pointInteretFichierCSVService.recuperer(mockFile);
        int nombrePointInteretDansLaZone = pointInteretZoneService.calcul(pointInterets, zone);

        //THEN
        assertEquals(nombrePointInteretDansLaZoneAttendue, nombrePointInteretDansLaZone);
    }
}