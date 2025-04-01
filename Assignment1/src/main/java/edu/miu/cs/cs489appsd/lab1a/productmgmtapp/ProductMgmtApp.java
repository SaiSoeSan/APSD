package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.time.LocalDate;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product product = new Product(3128874119L, "Banana", LocalDate.of(2024,02,20)
                , 124, 0.55);
        Product product1 = new Product(2927458265L, "Apple", LocalDate.of(2022,12,20)
                , 124, 1.09);
        Product product2 = new Product(9189927460L, "Carrot", LocalDate.of(2024,11,20)
                , 124, 2.99);

        Product[] products = new Product[]{product, product1, product2};

        printProducts(products);
    }

    public static void printProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getUnitPrice).reversed());
        System.out.println("JSON:");
        printProductsJson(products);
        System.out.println("---");
        System.out.println("XML:");
        printProductsXML(products);
        System.out.println("---");
        System.out.println("CSV:");
        printProductsCsv(products);
    }

    private static void printProductsJson(Product[] products) {
        System.out.println("[");
        for (Product p: products) {
            System.out.printf("\t{ \"productId\": \"%s\", \"name\": \"%s\", \"dateSupplied\": \"%s\", \"quantityInStock\": %s, \"unitPrice\": %s },\n",
                    p.getProductId(),
                    p.getName(),
                    p.getDateApplied(),
                    p.getQuantityInStock(),
                    p.getUnitPrice()
            );
        }
        System.out.println("]");
    }

    private static void printProductsXML(Product[] products) {
        System.out.println("<?xml version=\"1.0\"?>");
        System.out.println("<Products>");
        for (Product p: products) {
            System.out.printf("\t<product priductId=\"%s\" name=\"%s\" dateSupplied=\"%s\" quantityInStock=%s unitPrice=%s />\n",
                    p.getProductId(),
                    p.getName(),
                    p.getDateApplied(),
                    p.getQuantityInStock(),
                    p.getUnitPrice()
            );
        }
        System.out.println("</Products>");
    }

    private static void printProductsCsv(Product[] products) {
        for (Product p: products) {
            System.out.printf("%s, %s, %s, %s, %s\n", p.getProductId(), p.getName(), p.getDateApplied(), p.getQuantityInStock(), p.getUnitPrice());
        }
    }

}
