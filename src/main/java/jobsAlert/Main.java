package jobsAlert;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        JJITScraper jjitScraper = new JJITScraper();
        jjitScraper.getOffers();
    }


    }

