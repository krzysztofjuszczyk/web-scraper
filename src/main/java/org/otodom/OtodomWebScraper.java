package org.otodom;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class OtodomWebScraper {

    private final String url =
            "https://www.otodom.pl/pl/wyniki/sprzedaz/mieszkanie/swietokrzyskie/skarzyski?limit=36&ownerTypeSingleSelect=ALL&priceMax=300000&by=DEFAULT&direction=DESC&viewType=listing";

    public List<Offer> getOffers() throws IOException {
        Document document = Jsoup.connect(url).get();
        Elements elements = document.getElementsByAttributeValue("data-cy","listing-item-link");

        //        List<String> links = elements.stream()
//                        .map(e -> e.attr("href"))
//                        .toList();
//        links.forEach(url -> System.out.println("https://www.otodom.pl/"+url));
//        System.out.println(elements.size());
//        System.out.println(elements.get(0));
//        return List.of();

        List<String> links = getOffersLinksFromDocument(document)
                .subList(0,5);

        return links.stream()
                .map(this::createOffering)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    private Optional<Offer> createOffering(String link){
        try {
            Thread.sleep(10);
            System.out.println("Getting offering: "+ link);
            Document document = Jsoup.connect(link).get();
            String name = document.getElementsByAttributeValue("data-cy","adPageAdTitle").get(0).text();

            String description = document.getElementsByAttributeValue("data-cy","adPageAdDescription").get(0).text();
            String address = document.getElementsByAttributeValue("aria-label","Adres").get(0).text();

            return Optional.of(new Offer(link, name,description,address,""));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> getOffersLinksFromDocument(Document document){
        return document.getElementsByAttributeValue("data-cy","listing-item-link")
                .stream()
                .map(e -> e.attr("href"))
                .map(href -> "https://www.otodom.pl"+ href)
                .toList();

    }

}
