package com.xvnan.model;

import java.io.Serializable;

public class Keyword implements Serializable {
    private String name;
    private int[] keyIndex;
    private String keyIndexString;

    public static  int[] stringToArray(String str){
        String[] strings=str.split(";");
        int[] ints=new int[strings.length];
        for (int index=0;index<strings.length;index++){
            ints[index]=new Integer(strings[index]);
        }
        return ints;
    }

    public static  String arrayTOString(int[] ints){
        String string="";
        for(int i:ints){
            string=string+i+";";
        }
        return string;
    }

    public Keyword(String name,String keyIndexString){
        this.name=name;
        this.keyIndexString=keyIndexString;
    }

    public Keyword(String name, int[] keyIndex) {
        this.name = name;
        this.keyIndex = keyIndex;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getKeyIndex() {
        return keyIndex;
    }

    public void setKeyIndex(int[] keyIndex) {
        this.keyIndex = keyIndex;
    }

    public String getKeyIndexString() {
        return keyIndexString;
    }

    public void setKeyIndexString(String keyIndexString) {
        this.keyIndexString = keyIndexString;
    }


}
