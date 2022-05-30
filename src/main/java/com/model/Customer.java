package com.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "customer")
public class Customer {
    @Id
    private String dni;
    private String name;
    private String surname;
    private String age;
    private String phone;
    @Column(name = "color_car")
    private String favoriteColorCar;
    @Column(name = "brand_card")
    private String favoriteBrandCar;
    @Embedded
    @ElementCollection
    @CollectionTable(name = "cards_of_customer")
    private List<Card> cards = new ArrayList<>();



    // empty constructor
    protected Customer() {

    }
    //constructor with card
    public Customer(String dni, String name, String surname, String age, String phone, String favoriteColorCar, String favoriteBrandCar, List<Card> cards){
        this.setDni(dni);
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        this.setPhone(phone);
        this.setFavoriteColorCar(favoriteColorCar);
        this.setFavoriteBrandCar(favoriteBrandCar);
        this.setCards(cards);
    }

    //constructor without card
    public Customer(String dni, String name, String surname, String age, String phone, String favoriteColorCar, String favoriteBrandCar) {
        this.setDni(dni);
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        this.setPhone(phone);
        this.setFavoriteColorCar(favoriteColorCar);
        this.setFavoriteBrandCar(favoriteBrandCar);
    }

    ////--------------------methods get---------------
    public String getDNI(){
        return this.getDni();
    }
    public List<Card> getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public String getFavoriteColorCar() {
        return favoriteColorCar;
    }

    public String getFavoriteBrandCar() {
        return favoriteBrandCar;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
    ////--------------------methods set---------------

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFavoriteColorCar(String favoriteColorCar) {
        this.favoriteColorCar = favoriteColorCar;
    }

    public void setFavoriteBrandCar(String favoriteBrandCar) {
        this.favoriteBrandCar = favoriteBrandCar;
    }

    ////--------------------methods show---------------
    public void showCards(Customer customer){
        for(Card card: customer.getCards()){
            System.out.println(card);
        }

    }

    ////--------------------methods add---------------
    public List<Card> addCard(Card card){
        this.getCards().add(card);
        return getCards();
    }
    ////--------------------methods add---------------
    public void deleteCards(Customer customer, String b){
        for(int i = 0; i < this.getCards().size(); i++){
            String nc = String.valueOf(customer.getCards().get(i).getNumberCard());
            if(nc.equals(b)){
                customer.getCards().remove(i);
            }
        }
    }

    public boolean existsCards(Customer customer, String b){
        for(int i = 0; i < this.getCards().size(); i++){
            String nc = String.valueOf(customer.getCards().get(i).getNumberCard());
            if(nc.equals(b)){
                return true;
            }
        }return  false;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "dni='" + this.getDni() + '\'' +
                ", name='" + this.getName() + '\'' +
                ", surname='" + this.getSurname() + '\'' +
                ", age=" + this.getAge() +
                ", phone='" + this.getPhone() + '\'' +
                ", favoriteColorCar='" + this.getFavoriteColorCar() + '\'' +
                ", favoriteBrandCar='" + this.getFavoriteBrandCar() + '\'' +
                ", cards=" + this.getCards() +
                '}';
    }


}