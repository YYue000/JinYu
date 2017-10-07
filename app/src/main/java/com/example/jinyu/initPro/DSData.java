package com.example.jinyu.initPro;

import android.util.Log;

import com.example.jinyu.Internet.NetService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/**
 * Created by yyx on 2017/10/7.
 */

class DSData {
    private static DayShowHtml dayShowHtml = new DayShowHtml(-1,-1,-1,new ArrayList<String>(){{
        add("http://mp.weixin.qq.com/s/jlle5_4DXBKk7HtHrabhoQ");
    }});
    String serverUrl = "http://10.0.3.2:8080/server/base";//cannot work without http

    String updateHtml(){
        NetService internet = new NetService();
        return internet.get(serverUrl);
    }

    String getDSUrl(){//main view in dayshow
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DATE);

        if(year!=dayShowHtml.getYear() || month!=dayShowHtml.getMonth() || day!=dayShowHtml.getDay()){
            String html = updateHtml();
            DayShowHtml tmp = readHTML(html);
            if(tmp!=null) dayShowHtml = tmp;
        }

        return dayShowHtml.getUrl();
    }

    String getDSUrl(boolean right){
        return dayShowHtml.getUrl(right);
    }

    DayShowHtml readHTML(String html){
        String[] spList = html.split("\\r\\n");
        if(!spList[0].equals("<html>")) {
            Log.d("error", "readHtml:html syntax error");
            Log.d("syntax error","start"+spList[0].compareTo("<html>"));
            return null;
        }
        if(!spList[1].equals("<head><title>DayShow</title></head>")){
            Log.d("error","readHtml:html title error");
            return null;
        }
        int k = 3;
        if(!spList[k].equals("<h1>Date</h1>")){
            Log.d("error","readHtml:fail to read Date head");
            return null;
        }
        k +=2;
        int year,month,day;
        year = Integer.valueOf(spList[k++]);
        month = Integer.valueOf(spList[k++]);
        day = Integer.valueOf(spList[k++]);

        //spList[k]=="</p>"

        if(!spList[++k].equals("<h1>List</h1>")){
            Log.d("error","readHtml:fail to read List head");
            return null;
        }
        ArrayList<String> list = new ArrayList<String>();
        k ++;
        //spList[k]=="<p>"

        while(!spList[++k].equals("</p>")){
            list.add(spList[k]);
        }
        //spList[k]=="</p>"


        DayShowHtml res = new DayShowHtml(year,month,day,list);
        return res;
    }



}
