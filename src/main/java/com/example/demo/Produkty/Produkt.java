package com.example.demo.Produkty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.MAX_VALUE;

public class Produkt {

    private int id;
    private String tytul;
    private BigDecimal price;

    public Produkt(int id, String tytul, BigDecimal cena) {

        this.price = cena;
        this.id = id;
        this.tytul = tytul;
    }

    public int getId() {
        return id;
    }

    public String getTytul() {
        return tytul;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<BigDecimal> getPrices(List<Produkt> lista) {
        List<BigDecimal> prices = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            Produkt produkt = lista.get(i);
            BigDecimal price1 = produkt.getPrice();
            prices.add(price1);
        }
        return prices;
    }

    public static BigDecimal getPricesSum(List<BigDecimal> prices) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal bigDecimal : prices) {
            sum = sum.add(bigDecimal);
        }
        return sum;
    }

    public static List<Produkt> generateProducts(int n) {

        Random random = new Random();
        List<Produkt> productsList = new ArrayList<>();

        int id = 1;

        for (int i = 1; i <= n; i++) {
            String title = randomString();
            BigDecimal price = BigDecimal.valueOf(random.nextInt(MAX_VALUE)); //random number from 1 to Integer.MaxValue

            productsList.add(new Produkt(id++, title, price));
        }

        return productsList;
    }

    private static String randomString() {
        StringBuilder st = new StringBuilder();
        final int stringLength = 5;

        for (int i = 0; i < stringLength; i++) {
            String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            char randomChar = abc.charAt(new Random().nextInt(abc.length()));
            st.append(randomChar);
        }
        return String.valueOf(st);
    }


}
