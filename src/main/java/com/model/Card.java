package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "card")
public class Card {
    @Id
    private long numberCard ;
    private String expiration;
    private String type;
    private String securityCode;
    protected Card() {

    }


    public Card(long numberCard, String expiration, String type, String securityCode) {
        this.expiration =expiration;
        this.numberCard = numberCard;
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

    private void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }
    @Override
    public String toString() {
        return "Card{" +
                "numberCard=" + getNumberCard() +
                ", expiration='" + getExpiration() + '\'' +
                ", type='" + getType() + '\'' +
                ", securityCode=" + getSecurityCode() +
                '}';
    }
}