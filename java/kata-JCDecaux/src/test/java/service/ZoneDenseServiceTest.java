package service;

import model.PointInteret;
import model.ZoneDense;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * service de test qui test les zone les plus denses.
 */
class ZoneDenseServiceTest {


    private final PointInteretFichierCsvService pointInteretFichierCsvService = new PointInteretFichierCsvService();
    private final ZoneDenseService zoneDenseService = new ZoneDenseService();

    /**
     * Zones plus denses.
     *
     * @throws IOException the io exception
     */
    @Test
    public void zones_plus_denses() throws IOException {
        //GIVEN
        List<ZoneDense> zoneDensesAttendue = new ArrayList<ZoneDense>();
        ZoneDense zoneDensePremiere = new ZoneDense(-2.5, -2, 38,38.5);
        ZoneDense zoneDenseSeconde = new ZoneDense(6.5, 7, -7,-6.5);
        zoneDensesAttendue.add(zoneDensePremiere);
        zoneDensesAttendue.add(zoneDenseSeconde);

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
        List<PointInteret> pointInteretsActual = pointInteretFichierCsvService.recuperer(mockFile);
        List<ZoneDense> zoneDensesActualExcel = zoneDenseService.recuperer(pointInteretsActual);

        //THEN
        assertEquals(zoneDensesAttendue, zoneDensesActualExcel);
    }
}