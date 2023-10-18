package com.techelevator.model;

public class Puppy {
    private int puppyId;
    private int shelterId;
    private String puppyName;
    private int weightLbs;
    private String gender;
    private String breed;
    private boolean isFostered;
    private String imageUrl;

    public Puppy(){}

    public int getPuppyId() {
        return puppyId;
    }

    public void setPuppyId(int puppyId) {
        this.puppyId = puppyId;
    }

    public int getShelterId() {
        return shelterId;
    }

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
    }

    public String getPuppyName() {
        return puppyName;
    }

    public void setPuppyName(String puppyName) {
        this.puppyName = puppyName;
    }

    public int getWeightLbs() {
        return weightLbs;
    }

    public void setWeightLbs(int weightLbs) {
        this.weightLbs = weightLbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isFostered() {
        return isFostered;
    }

    public void setFostered(boolean fostered) {
        isFostered = fostered;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Puppy{" +
                "puppyId=" + puppyId +
                ", puppyName='" + puppyName + '\'' +
                ", weight=" + weightLbs +
                ", gender='" + gender + '\'' +
                ", breed='" + breed + '\'' +
                ", isFostered=" + isFostered +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
