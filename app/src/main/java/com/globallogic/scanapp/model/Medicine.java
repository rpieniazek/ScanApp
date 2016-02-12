package com.globallogic.scanapp.model;

/**
 * Created by Rafal Pieniążek on 2016-02-11.
 */

public class Medicine {

    public Medicine(String type, int strong,String barcode) {
        this.type = type;
        this.strong = strong;
        this.barcode = barcode;

        packing = "2x400mg";
        producer = "zentiva";
        lozenge = "lozenge";

    }
    private String barcode;

    private String type;

    private int strong;

    private String packing;

    private String producer;

    private String lozenge;

    public String getDescription(){
        return "ibalgin|400|2x400mg|zentiva|tbl_flm";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStrong() {
        return strong;
    }

    public void setStrong(int strong) {
        this.strong = strong;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getLozenge() {
        return lozenge;
    }

    public void setLozenge(String lozenge) {
        this.lozenge = lozenge;
    }
}
