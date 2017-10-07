package com.example.jinyu.Internet;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yyx on 2017/10/7.
 */

public class NetService {
    public String get(String url){

        final Request request = new Request.Builder().url(url).build();
        OkHttpClient client = new OkHttpClient();
        final ArrayList<String> resVector = new ArrayList<String>();
        client.newCall(request).enqueue(new Callback() {

            @Override

            public void onFailure(okhttp3.Call call, IOException e) {

                String error = e.getMessage();
                Log.d("error", error);


            }


            @Override

            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                if (response.isSuccessful()) {

                    String json = response.body().toString();

                    InputStream is = response.body().byteStream();

                    ByteArrayOutputStream bos = new ByteArrayOutputStream();

                    int readed = 0;

                    byte buf[] = new byte[1024];

                    while ((readed = is.read(buf, 0, buf.length)) != -1) {

                        bos.write(buf, 0, readed);

                    }

                    byte[] res = bos.toByteArray();
                    String result = new String(res);
                    resVector.add(result);

                    Log.d("result", "result:" + result);

                    is.close();

                    bos.close();

                    buf = null;

                }

            }


        });
        if(resVector.isEmpty()) return null;
        else return resVector.get(0);
    }
}
