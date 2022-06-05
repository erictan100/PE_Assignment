package com.example.pe_assignment;

public class ThingstoKnowHelperClass {

    int mainImage, logoImage;
    String author, title, description;

    public ThingstoKnowHelperClass(int mainImage, int logoImage, String author, String title, String description) {
        this.mainImage = mainImage;
        this.logoImage = logoImage;
        this.author = author;
        this.title = title;
        this.description = description;
    }

    public int getMainImage() {
        return mainImage;
    }

    public int getLogoImage() {
        return logoImage;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
