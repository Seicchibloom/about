package com.pack.galabout;

public class AminoAcidModel {
    String aminoAcidName;
    String aminoAcidAbbreviation;
    String aminoAcidAbbreviationSmall;
    int image;
    private int imageWidth;  // Width of the image
    private int imageHeight; // Height of the image

    public AminoAcidModel(String aminoAcidName, String aminoAcidAbbreviation, String aminoAcidAbbreviationSmall, int image, int imageWidth, int imageHeight) {
        this.aminoAcidName = aminoAcidName;
        this.aminoAcidAbbreviation = aminoAcidAbbreviation;
        this.aminoAcidAbbreviationSmall = aminoAcidAbbreviationSmall;
        this.image = image;
        this.imageWidth = this.imageWidth;
        this.imageHeight = this.imageHeight;
    }

    public String getAminoAcidName() {
        return aminoAcidName;
    }

    public String getAminoAcidAbbreviation() {
        return aminoAcidAbbreviation;
    }

    public String getAminoAcidAbbreviationSmall() {
        return aminoAcidAbbreviationSmall;
    }

    public int getImage() {
        return image;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }
}
