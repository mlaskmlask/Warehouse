package com.company;

import java.util.List;
import java.util.Scanner;

public class GUI {

    private static Scanner skaner = new Scanner(System.in);

    public static void showMainMenu() {
        System.out.println("1. Dodaj produkt");
        System.out.println("2. Wydaj produkt");
        System.out.println("3. Wyświetl produkty");
        System.out.println("4. Wyjście");

        String choose = skaner.nextLine();

        switch (choose) {
            case "1":
                addProduct();
                break;
            case "2":
                deliverProduct();
                break;
            case "3":
                showAllProducts();
                showMainMenu();
                break;
            case "4":
                System.exit(0);
            default:
                System.out.println("Nieprawidłowy wybór");
                showMainMenu();
        }

    }

    private static void showAllProducts() {
        List<Product> products = ProductRepository.getInstance().getAllProducts();
        for (Product currentProducts : products) {
            System.out.println(currentProducts);
        }
    }

    private static void deliverProduct() {
        System.out.println("Podaj produkt");
        String productToDeliver = skaner.nextLine();
        System.out.println("Podaj ilość sztuk");
        int piecesToDeliver = Integer.parseInt(skaner.nextLine());
        boolean success = ProductRepository.getInstance().deliverProduct(productToDeliver, piecesToDeliver);
        if (success) {
            System.out.println("Wydano");
        } else {
            System.out.println("Nie udalo się");
        }

    }

    private static void addProduct() {
        System.out.println("Podaj nazwę produktu");
        String productName = skaner.nextLine();
        Product productFromDataBase = ProductRepository.getInstance().findProduct(productName);
        if (productFromDataBase != null) {
            try{
                System.out.println("Podaj ilość");
                int productPieces = Integer.parseInt(skaner.nextLine());
                productFromDataBase.setPieces(productFromDataBase.getPieces() + productPieces);
                System.out.println("Dodano produkt");
                showMainMenu();
            }catch (NumberFormatException e){
                System.out.println("Nieprawidłowa liczba");
                addProduct();
            }

        } else {
            addNewProduct(productName);

        }
    }

    private static void addNewProduct(String productName) {
        System.out.println("1. Clothes");
        System.out.println("2. Jewellery");
        DataWrapper dataWrapper;

        String choose = skaner.nextLine();
        switch (choose) {
            case "1":
                dataWrapper = readCommonData();
                System.out.println("Podaj długość");
                String length = skaner.nextLine();
                Clothes clothes = new Clothes(dataWrapper.size, productName, dataWrapper.color, dataWrapper.pieces, length);
                ProductRepository.getInstance().addProductToDatabase(clothes);
                System.out.println("Produkt dodano");
                showMainMenu();
                break;
            case "2":
                dataWrapper = readCommonData();
                System.out.println("Podaj typ");
                String type = skaner.nextLine();
                Jewellery jewellery = new Jewellery(dataWrapper.size, productName, dataWrapper.color, dataWrapper.pieces, type);
                ProductRepository.getInstance().addProductToDatabase(jewellery);
                System.out.println("Produkt dodano");
                showMainMenu();
                break;
            default:
                System.out.println("Nieprawidłowy wybór");
                addNewProduct(productName);
                break;
        }
    }

    private static DataWrapper readCommonData() {
        try {
            System.out.println("Podaj wielkość");
            int size = Integer.parseInt(skaner.nextLine());
            System.out.println("Podaj kolor");
            String color = skaner.nextLine();
            System.out.println("Podaj ilość cztuk");
            int pieces = Integer.parseInt(skaner.nextLine());

            return new DataWrapper(size, color, pieces);
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawna liczba");
            return readCommonData();
        }
    }

    static class DataWrapper {
        int size;
        String color;
        int pieces;

        DataWrapper(int size, String color, int pieces) {
            this.size = size;
            this.color = color;
            this.pieces = pieces;
        }
    }
}
