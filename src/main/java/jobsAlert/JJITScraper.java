package jobsAlert;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.List;

public class JJITScraper {
    private final String baseURL = "https://justjoin.it/experience-level_junior/remote_yes?keyword=junior";

// ?keyword=junior&keyword=nazwa

    public List<JobOffer> getOffers() throws IOException {
        Document doc = Jsoup.connect(baseURL).get();
//        List<Element> searchTxts = doc.select("input[placeholder='Search'");
//        Element searchTxt = searchTxts.get(0);

        Elements elements = doc.getElementsByAttributeValue("item","[object Object]");
        elements.forEach(e -> System.out.println(e.toString()));

        return null;
    }

}
