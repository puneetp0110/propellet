package com.example.medicationapp.network;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.medicationapp.database.DataBaseHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class API {

    final String URL = "https://s3-us-west-2.amazonaws.com/ph-svc-mobile-interview-jyzi2gyja/propeller_mobile_assessment_data.json";

    /**
     * @param context
     * @param db
     * constructor:
     */
    public API(Context context, DataBaseHelper db) {
        getMedicationsDetails(context,db);
    }

    /**
     * @param context
     * @param db
     * getMedicationsDetails: Volley for http request.
     * after response is added it is stored in db
     */
    public void getMedicationsDetails(final Context context, final DataBaseHelper db) {

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray list = response.getJSONArray("events");

                    for (int i = 0; i < list.length(); i++){
                        db.insertNode(
                                list.getJSONObject(i).get("medication").toString(),
                                list.getJSONObject(i).get("datetime").toString(),
                                list.getJSONObject(i).get("medicationtype").toString());
                    }

                } catch(JSONException e){
                    Log.d("Err:", e.getLocalizedMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Fun", "Err:" + error.getLocalizedMessage());
            }
        });
        Volley.newRequestQueue(context).add(jsonObjectRequest);
    }
}
