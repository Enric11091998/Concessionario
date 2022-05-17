package com.model;

public class Card {
    public long numberCard;
    public String expiration;
    public String type;
    public String securityCode;


    public Card() {

    }

    public Card(long numberCard, String expiration, String type, String securityCode) {
        this.numberCard = numberCard;
        this.expiration = expiration;
        this.type = type;
        this.securityCode = securityCode;
    }

    public long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(long numberCard) {
        this.numberCard = numberCard;
}

    public String getExpiration() {
        return expiration;
    }
    @Override
    public String toString() {
        return "Card{" +
                "numberCard=" + numberCard +
                ", expiration='" + expiration + '\'' +
                ", type='" + type + '\'' +
                ", securityCode=" + securityCode +
                '}';
    }
}