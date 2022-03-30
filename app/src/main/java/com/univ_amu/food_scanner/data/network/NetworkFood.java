package com.univ_amu.food_scanner.data.network;

import java.util.List;

public class NetworkFood {
    String code;
    String name;
    String brands;
    String nutriscore;
    List<NetworkQuantity> quantities;
    public String toString(){
        return code+" "+name+" "+brands+" "+nutriscore+" "+quantities.toString();
    }
    public static class NetworkQuantity {
        String name;
        int rank;
        int level;
        double quantity;
        String unit;
        public String toString(){
            return name +" "+rank+" "+level+" "+quantity+" "+unit;
        }

    }
}