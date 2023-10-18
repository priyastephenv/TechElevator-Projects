package com.techelevator;

public class Television {

    private boolean isOn;
    private int currentChannel = 3;
    private int currentVolume = 2;

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return this.currentChannel;
    }

    public int getCurrentVolume() {
        return this.currentVolume;
    }

    public void turnOn() {

        isOn = true;
        this.currentVolume =2;
        this.currentChannel =3;

    }

    public void turnOff(){

        isOn = false;

    }

    public void changeChannel (int newChannel) {

        if (isOn && newChannel >3 && newChannel <18){
            this.currentChannel = newChannel;


        }

    }

    public void channelUp(){
        int maxChannel = 18;
        if ( isOn)  {
            this.currentChannel ++;

        }

        if (this.currentChannel > 18) {

            this.currentChannel =3;

        }


    }

    public void channelDown(){

        if (isOn){
            this.currentChannel --;

            if (this.currentChannel < 3) {

                this.currentChannel =18;
            }

        }

    }

    public void raiseVolume(){
        int maxVolume = 10;
        if (this.currentVolume <maxVolume && isOn) {

            this.currentVolume ++;
        }

    }
    public void lowerVolume(){
        int minVolume =0;

        if (this.currentVolume > 0 && isOn) {

            this.currentVolume --;
        }


    }

}
