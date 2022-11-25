package service;

import model.PointInteret;

import java.util.ArrayList;
import java.util.List;

public class PointInteretUtils {

    static List<PointInteret> getPointInterets() {
        List<PointInteret> pointInteretsAttendu = new ArrayList<PointInteret>();
        String identifiantPremier = "id1";
        double latFirst = -48.6;
        double lonFirst = -37.7;

        String identifiantDeuxieme = "id2";
        double latDeuxieme = -27.1;
        double lonDeuxieme = 8.4;

        String identifiantTroisieme = "id3";
        double latTroisieme = 6.6;
        double lonTroisieme = -6.9;

        String identifiantQuatrieme = "id4";
        double latQuatrieme = -2.3;
        double lonQuatrieme = 38.3;

        String identifiantCinquieme = "id5";
        double latCinquieme = 6.8;
        double lonCinquieme = -6.9;

        String identifiantSixieme = "id6";
        double latSixieme = -2.5;
        double lonSixieme = 38.3;

        String identifiantSeptieme = "id7";
        double latSeptieme = 0.1;
        double lonSeptieme = -0.1;

        String identifiantHuitieme = "id8";
        double latHuitieme = -2.1;
        double lonHuitieme = 38.1;

        PointInteret pointInteretFirst = new PointInteret(identifiantPremier, latFirst, lonFirst);
        PointInteret pointInteretDeuxieme = new PointInteret(identifiantDeuxieme, latDeuxieme, lonDeuxieme);
        PointInteret pointInteretTroisieme = new PointInteret(identifiantTroisieme, latTroisieme, lonTroisieme);
        PointInteret pointInteretQuatrieme = new PointInteret(identifiantQuatrieme, latQuatrieme, lonQuatrieme);
        PointInteret pointInteretCinquieme = new PointInteret(identifiantCinquieme, latCinquieme, lonCinquieme);
        PointInteret pointInteretSixieme = new PointInteret(identifiantSixieme, latSixieme, lonSixieme);
        PointInteret pointInteretSeptieme = new PointInteret(identifiantSeptieme, latSeptieme, lonSeptieme);
        PointInteret pointInteretHuitieme = new PointInteret(identifiantHuitieme, latHuitieme, lonHuitieme);

        pointInteretsAttendu.add(pointInteretFirst);
        pointInteretsAttendu.add(pointInteretDeuxieme);
        pointInteretsAttendu.add(pointInteretTroisieme);
        pointInteretsAttendu.add(pointInteretQuatrieme);
        pointInteretsAttendu.add(pointInteretCinquieme);
        pointInteretsAttendu.add(pointInteretSixieme);
        pointInteretsAttendu.add(pointInteretSeptieme);
        pointInteretsAttendu.add(pointInteretHuitieme);

        return pointInteretsAttendu;
}
}
