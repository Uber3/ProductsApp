package com.example.demo.Produkty;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Integer.MAX_VALUE;

class ProduktTest {

    //  private lista;

    @Test
    void create() {
        int id = 10;
        String tytul = "maslo";
        BigDecimal price = new BigDecimal(100);
        Produkt zmienna = new Produkt(id, tytul, price);

        assertEquals(id, zmienna.getId());
        assertEquals(tytul, zmienna.getTytul());
        assertEquals(price, zmienna.getPrice());
    }

    @Test
    void mathrandom() {
        int i;
        BigDecimal expectedTotal = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;
        for (i = 0; i < 100; i++) {
            Random mathrandom = new Random();
            int myRandInt = mathrandom.ints(1, 101).findAny().getAsInt();
            System.out.println("Produkt price between 1 and 100: " + myRandInt);
            int id = 10;
            String tytul = "maslo";
            BigDecimal price = new BigDecimal(myRandInt);
            Produkt zmienna = new Produkt(id, tytul, price);
            assertTrue(myRandInt >= 1);
            assertTrue(myRandInt <= 101);


            expectedTotal = expectedTotal.add(new BigDecimal(myRandInt));
            total = total.add(price);
        }
        assertEquals(expectedTotal, total);
        System.out.println("Suma wynosi: " + total);

    }


    @Test
    void mathstream() {
        List<Produkt> lista = IntStream.range(0, 100)
                .mapToObj(operand -> {
                    int id = 10;
                    String tytul = "maslo";
                    BigDecimal price = new BigDecimal(operand);
                    return new Produkt(id, tytul, price);
                })
                .collect(Collectors.toList());
        for (int i = 0; i < 100; i++) {
            assertEquals(lista.get(i).getPrice(), BigDecimal.valueOf(i));


            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int c = 0; c < targetStringLength; c++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            String generatedString = buffer.toString();

            System.out.println(generatedString);
        }


    }

    @Test
    void getPricesSum() {
        int id = 10;
        String tytul = "maslo";
        BigDecimal price = new BigDecimal(100);
        Produkt zmienna = new Produkt(id, tytul, price);

        List<BigDecimal> bigDecimals = Arrays.asList(price, price);

        assertEquals(Produkt.getPricesSum(bigDecimals), BigDecimal.valueOf(200));
    }

    @Test
    void generateProducts() {
        List<Produkt> productsList = Produkt.generateProducts(50);

        assertFalse(productsList.isEmpty());
        assertEquals(productsList.size(),50);
    }


    //  @Test
    //void getPrices(){
    //  getPrices();
    //getProdukt();
    //this.lista.size() = 100;
    //List<BigDecimal> prices = new ArrayList<>();
    //for (int i = 0; i < 100; i++){
    //  Produkt produkt = lista.getClass(i);
    //BigDecimal price1 = produkt.getPrice();
    //prices.add(price1);
    //}
    //return prices;
    //}
    //private void getProdukt() {
    //}

}



