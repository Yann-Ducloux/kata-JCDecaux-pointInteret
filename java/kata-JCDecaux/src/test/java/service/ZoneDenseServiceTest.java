package service;

import Interface.IPointInteretFichierService;
import Interface.IZoneDenseService;
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
    private final IZoneDenseService zoneDenseService = new ZoneDenseService();

    /**
     * Zones plus denses.
     *
     * @throws IOException the io exception
     */
    @Test
    public void zones_plus_denses() throws IOException {
        //GIVEN
        List<PointInteret> pointInterets = PointInteretUtils.getPointInterets();
        List<ZoneDense> zoneDensesAttendue = new ArrayList<ZoneDense>();
        ZoneDense zoneDensePremiere = new ZoneDense(-2.5, -2, 38,38.5);
        ZoneDense zoneDenseSeconde = new ZoneDense(6.5, 7, -7,-6.5);
        zoneDensesAttendue.add(zoneDensePremiere);
        zoneDensesAttendue.add(zoneDenseSeconde);

        //WHEN
        List<ZoneDense> zoneDenses = zoneDenseService.recuperer(pointInterets);

        //THEN
        assertEquals(zoneDensesAttendue, zoneDenses);
    }
}