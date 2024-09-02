package org.example.domain;

public enum Currency {
    RUB("рубль"), EUR("евро"), USD("доллар");
    private String description;
    Currency(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
