package service;

import Interface.IPointInteretFichierService;
import model.PointInteret;
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
 * Service de test qui test la récupération des points d'intérêt à partir d'un fichier csv.
 */
class PointInteretFichierCsvServiceTest {
    private final IPointInteretFichierService pointInteretFichierCSVService = new PointInteretFichierCsvService();

    /**
     * test de la récupération des points interets du csv.
     *
     * @throws IOException the io exception
     */
    @Test
    public void recuperation_des_points_interets_du_csv() throws IOException {
        //GIVEN
        List<PointInteret> pointInteretsAttendu = PointInteretUtils.getPointInterets();
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
        MultipartFile mockFile = new MockMultipartFile("yann", "pointInteret.csv", "plain/text", is);

        //WHEN
        List<PointInteret> pointInterets = pointInteretFichierCSVService.recuperer(mockFile);

        //THEN
        assertEquals(pointInteretsAttendu, pointInterets);
    }
}