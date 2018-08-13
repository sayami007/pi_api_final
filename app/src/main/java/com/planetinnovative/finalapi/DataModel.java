package com.planetinnovative.finalapi;

import org.json.JSONObject;

public class DataModel {

    public String id;
    public String detail;
    public String title;
    public String priority;

    public DataModel(String json) throws Exception {
        this(new JSONObject(json));
    }

    public DataModel(JSONObject json) throws Exception {
        id = json.optString("id");
        detail = json.optString("detail");
        title = json.optString("title");
        priority = json.optString("priority");
    }
}
