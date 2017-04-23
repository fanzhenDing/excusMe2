package com.example.fanzhending.excusme;

public class LambdaRequest {
    String number;
    String delay;
    String caller;
    String excuse;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getExcuse() { return excuse; }

    public void setExcuse(String excuse) { this.excuse = excuse; }

    public LambdaRequest(String number, String delay, String caller, String excuse) {
        this.number = number;
        this.delay = delay;
        this.caller = caller;
        this.excuse = excuse;
    }

    public LambdaRequest() {
    }
}