package com.cit.BankApplication;



public class Items {
    private int Image;
    private String Operation;
    private String Montant;
    private String date;

    public Items(int image, String operation, String montant, String date) {
        Image = image;
        Operation = operation;
        Montant = montant;
        this.date = date;
    }


    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String operation) {
        Operation = operation;
    }

    public String getMontant() {
        return Montant;
    }

    public void setMontant(String montant) {
        Montant = montant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
