package com.example.jinyu.initPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by yyx on 2017/10/7.
 */

class DayShowHtml {
        private int year,month,day;
        private String[] urlList = null;
        private int reqCont = -1;
        protected DayShowHtml(int year,int month,int day,ArrayList<String> urlList){
            this.year = year;
            this.month = month;
            this.day = day;
            int size = urlList.size();
            this.urlList = urlList.toArray(new String[size]);
        }
        protected int getYear() {return year;}
        protected int getMonth() {return month;}
        protected int getDay() {return day;}
        protected String[] getUrlList(){
            return urlList.clone();
        }

        protected boolean sameDay(DayShowHtml another){
            if(this.day==another.getYear() && this.month==another.getMonth() && this.day==another.getDay()){
                return true;
            }
            else
                return false;
        }

        protected String getUrl(boolean right){
            if(right) reqCont++;
            else reqCont--;
            if(reqCont<0) reqCont = urlList.length-1;
            return urlList[reqCont%urlList.length];
        }

        protected String getUrl(){
            return urlList[0];
        }
}
