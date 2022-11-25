package service;

import Interface.IZoneDenseService;
import model.PointInteret;
import model.ZoneDense;

import java.util.*;
import java.util.stream.Collectors;

/**
 * service qui gére les zones denses.
 */
public class ZoneDenseService implements IZoneDenseService {
    /**
     * The Arrondi inférieur.
     */
    private static final float ARRONDI_INF = 0.5f;
    /**
     * The Deux.
     */
    private static final float DEUX = 2;
    @Override
    public List<ZoneDense> recuperer(List<PointInteret> pointInterets) {
        List<ZoneDense> zoneDensExcels = touteLesZones(pointInterets);
        return calculer(zoneDensExcels);
    }


    @Override
    public List<ZoneDense> calculer(List<ZoneDense> zoneResponses) {
        long nombreMaximumPointInteretDansZone = nombreMaximumPointInteretDansZoneLesPlusDense(zoneResponses);
        Map<ZoneDense, Long> mapZoneDense =
                zoneResponses.stream().collect(Collectors.groupingBy(zoneDense -> zoneDense, Collectors.counting()));
        mapZoneDense.values().removeIf(nombrePointInteret -> nombrePointInteret< nombreMaximumPointInteretDansZone);
        return new ArrayList(mapZoneDense.keySet());
    }
    @Override
    public long nombreMaximumPointInteretDansZoneLesPlusDense(List<ZoneDense> zoneResponses) {
        Collection<Long> compteurZoneDenses =  zoneResponses.stream()
                .collect(Collectors.groupingBy(zoneDense -> zoneDense, Collectors.counting()))
                .values();
        return compteurZoneDenses.stream()
                .max(Comparator.comparing(nombrePointInteret->nombrePointInteret))
                .get();
    }
    @Override
    public List<ZoneDense> touteLesZones(List<PointInteret> pointInterets) {
        List<ZoneDense> zoneResponses = new ArrayList<>();
        ZoneDense zoneResponse;
        for (PointInteret pointInteret : pointInterets ) {
            zoneResponse = new ZoneDense((arrondirDemiInf(pointInteret.getLat())),
                    (arrondirDemiSup(pointInteret.getLat())),
                    (arrondirDemiInf(pointInteret.getLon())),
                    (arrondirDemiSup(pointInteret.getLon())));
            zoneResponses.add(zoneResponse);
        }
        return zoneResponses;
    }

    private double arrondirDemiSup(double number) {
        return (Math.ceil(number * DEUX) / DEUX);
    }

    private double arrondirDemiInf(double number) {
        return (arrondirDemiSup(number) - ARRONDI_INF);
    }
}
