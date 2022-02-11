/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jam;

/**
 *
 * @author ASUS
 */
public class Clock {
    private int hour;
    private int minute;
    private int second;
    
//    public Clock(int hour, int minute, int second){
//        this.hour = hour;
//        this.minute = minute;
//        this.second = second;
//    }
    public Clock(int hour){
        this.hour = hour;
    }
    //setter getter
    public void setHour(int hour){
        if(hour >= 0 && hour <= 23){
            this.hour = hour;
        }
        
    }
    public int getHour(){
        return hour;
    }
    public void setMinute(int minute){
        if(minute >= 0 && minute <= 59){
            this.minute = minute;
        }
    }
    public int getMinute(){
        return minute;
    }
    public void setSecond(int second){
        if(second >= 0 && second <= 59){
            this.second = second;
        }
        
    }
    public int getSecond(){
        return second;
    }
    
    //method
    
    public Clock(Clock other){
        this.hour = other.hour;
        this.minute = other.minute;
        this.second = other.second;
    }
    public Clock(){
        
    }
    public void incHour(){
        if(hour < 23){
            hour++;
        }
        else{
            hour = 0;
        }
    }
    public void decHour(){
        if(hour > 0){
            hour--;
        }
        else{
            hour = 23;
        }
    }
    public void incMinute(){
        if(minute < 59){
            minute++;
        }
        else{
            minute = 0;
            incHour();
        }
    }
    public void decMinute(){
        if(minute > 0){
            minute--;
        }
        else{
            minute = 59;
            decHour();
        }
    }
    public void incSec(){
        if(second < 59){
            second++;
        }
        else{
            second = 0;
            incMinute();
        }
    }
    public void decSec(){
        if(second > 0){
            second--;
        }
        else{
            second = 59;
            decMinute();
        }
    }
    public Clock elapse(Clock other){
        Clock obj = new Clock();

        //obj.hour = this.hour - other.hour;
        //obj.minute = this.minute - other.minute;
        //obj.second = this.second - other.second;
        
        if(this.hour < other.hour){
            this.hour = this.hour + 23;
            obj.hour = this.hour - other.hour;
        }
        else{
            obj.hour = this.hour - other.hour;
        }
        
        if(this.minute < other.minute){
            decHour();
            this.minute = this.minute + 60;
            obj.minute = this.minute - other.minute;
        }
        else{
            obj.minute = this.minute - other.minute;
        }
        
        if(this.second < other.second){
            decMinute();
            this.second = this.second + 60;
            obj.second = this.second - other.second;
        }
        else{
            obj.second = this.second - other.second;
        }
        
        return obj;
    }
    public String getInfo(){
        return "Time{"+getHour()+":"+getMinute()+":"+getSecond()+"}";
    }
}
