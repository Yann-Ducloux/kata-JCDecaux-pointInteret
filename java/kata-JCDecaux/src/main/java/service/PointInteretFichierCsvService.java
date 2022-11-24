package service;

import Interface.IPointInteretFichierService;
import model.PointInteret;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PointInteretFichierCsvService implements IPointInteretFichierService {
    /**
     * The Identifiant.
     */
    private static final int IDENTIFIANT = 0;
    /**
     * The Lat.
     */
    private static final int LATITUDE = 1;
    /**
     * The Lon.
     */
    private static final int LONGGITUDE = 2;
    /**
     * The Comma delimiter.
     */
    private static final String VIRGULE_DELIMITER = ",";
    /**
     * The Lat.
     */
    private static final int PREMIERE_LIGNE_INDEX = 1;
    public List<PointInteret> recuperer(MultipartFile multipartFile) {
        try {
            List<PointInteret> pointInterets = new ArrayList<>();
            InputStream is = multipartFile.getInputStream();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                Stream<String> lignes = br.lines();
                lignes.skip(PREMIERE_LIGNE_INDEX).forEach(ligne -> {
                    String[] donnees = ligne.split(VIRGULE_DELIMITER);
                    pointInterets.add(new PointInteret(donnees[IDENTIFIANT],
                            (Double.parseDouble(donnees[LATITUDE])), (Double.parseDouble(donnees[LONGGITUDE]))));
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return pointInterets;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
