package org.example;

import java.util.List;

public class OffersFilter {
    private final List<String> blockListedWords = List.of(
                    "Ogrzewanie własne", "rudera");

    private final List<String> blockNeighbourhoods = List.of(
            "Zadupie");

    public List<Offer> filter(List<Offer> offers){
        List<Offer> resultList =  offers.stream().filter(
                offer -> !offer.containsWord(blockListedWords)
                && !offer.containsWord(blockNeighbourhoods)
        ).toList();

        if(offers.size() != resultList.size()){
            System.out.println("Wyfiltrowaliśmy oferty! Było: "  + offers.size() + ", a jest: " + resultList.size());

        }
        return resultList;
    }
}
