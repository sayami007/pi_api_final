package com.planetinnovative.finalapi;

import org.json.JSONObject;

public class DataSetModel {

    public int code;
    public String messsage;

    public DataSetModel(String json) throws Exception {
        this(new JSONObject(json));
    }

    public DataSetModel(JSONObject json) throws Exception {
        code = json.optInt("code");
        messsage = json.optString("messsage");

    }
}
