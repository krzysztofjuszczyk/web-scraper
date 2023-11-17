package org.example;

import java.util.List;

public record Offer(String url, String name, String description, String address, String photoUrl) {

    public boolean containsWord(List<String> blockListedWords) {
        return blockListedWords.stream()
                .anyMatch(blockedWord -> name.toLowerCase().contains(blockedWord.toLowerCase())
                        || description.toLowerCase().contains(blockedWord.toLowerCase())
                        || address.toLowerCase().contains(blockedWord.toLowerCase()));

    }
}
