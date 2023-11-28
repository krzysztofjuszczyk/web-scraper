package jobsAlert;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        JJITScraper jjitScraper = new JJITScraper();
        List<String> jobOffers = jjitScraper.getOffers();
        jobOffers.forEach(System.out::println);
//        List<JobOffer> jobOffers = jjitScraper.getOffers();
//        jobOffers.forEach(o -> System.out.println(o.url()));
    }


    }

