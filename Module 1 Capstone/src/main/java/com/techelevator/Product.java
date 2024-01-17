package com.techelevator;

import com.sun.jdi.connect.Connector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product {

    private String slotIdentifier;
    private String productName;
    private BigDecimal price;
    private String snackType;

    private double quantity;


    public static List<Product> productList = new ArrayList<>();


    public Product (){

    }



    public Product (String slotIdentifier, String productName, BigDecimal price, String snackType) {

        this.slotIdentifier = slotIdentifier;
        this.productName = productName;
        this.price = price;
        this.snackType = snackType;
        this.quantity = 5;

    }


    public List<Product> getProductList() {
        return productList;
    }

    public List <Product> updatingProductList(){


        try {

             final int quantityRemaining = 5;

            Scanner scanner = new Scanner(new File("main.csv"));

            String text;

            while(scanner.hasNextLine()){
                text = scanner.nextLine();

                //String[] tempString = text.split(", ");

                String[] tempString = text.split(",");

               String priceAsString = tempString [2];
               Double priceAsDouble = Double.parseDouble(priceAsString);

               BigDecimal vendingMachinePrice = new BigDecimal(priceAsDouble).setScale(2, RoundingMode.HALF_EVEN);

                Product newProduct = new Product(tempString[0],tempString[1], vendingMachinePrice, tempString [3]);
                 productList.add(newProduct);



            }


            } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        return productList;

    }

    public String getSlotIdentifier() {
        return slotIdentifier;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSnackType() {
        return snackType;
    }

    public double getQuantity() {

        return quantity;
    }

    public void setQuantity(double quantity) {


        this.quantity = quantity;
    }




    public static Product getBySlot(String slot){

        for(Product product : productList){
            if(product.getSlotIdentifier().equals(slot)){
                return product;
            }
        }
        return null;
    }

    public void displayProducts (){

        List <Product> updatedList = updatingProductList();

        for (Product eachProduct:updatedList) {

            System.out.println(eachProduct.slotIdentifier + " " + eachProduct.productName);
            System.out.println("Price: " + eachProduct.price.toString() + " " + "Qty: " + eachProduct.quantity);

           
        }




    }







}




