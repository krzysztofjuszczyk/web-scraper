package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        OtodomWebScraper scraper = new OtodomWebScraper();
        List<Offer> offers = scraper.getOffers();

        OffersFilter offersFilter = new OffersFilter();
        List<Offer> filtered = offersFilter.filter(offers);

        offers.forEach(o -> System.out.println(o.url()));
    }
}