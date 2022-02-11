/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jam;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class ClockTest {
    
    public ClockTest() {
    }

    //test INC Hpour
    @Test
    public void testIncHour1() {
        Clock c1 = new Clock();
        c1.incHour();
        String expResult = "Time{1:0:0}";
        String result = c1.getInfo();
        assertEquals(expResult, result);
    }
    
    
    //test DEC Hour
    @Test
    public void testDecHour1(){
        Clock c1 = new Clock();
        c1.setHour(0);
        c1.decHour();
        String expResult = "Time{23:0:0}";
        String result = c1.getInfo();
        assertEquals(expResult, result);
    }
    
    //inc minute
    @Test
    public void testIncMinute1(){
        Clock c1 = new Clock();
        c1.incMinute();
        String expResult = "Time{0:1:0}";
        String result = c1.getInfo();
        assertEquals(expResult, result);
    }
    
    
    //dec minute
    @Test
    public void testDecMinute1(){
        Clock c1 = new Clock();
        c1.decMinute();
        String expResult = "Time{23:59:0}";
        String result = c1.getInfo();
        assertEquals(expResult, result);
    }
    
    
    //inc sec
    @Test
    public void testIncSecond1(){
        Clock c1 = new Clock();
        c1.incSec();
        String expResult = "Time{0:0:1}";
        String result = c1.getInfo();
        assertEquals(expResult, result);
    }
    
    
    //dec second
    @Test
    public void testDecSecond1(){
        Clock c1 = new Clock();
        c1.decSec();
        String expResult = "Time{23:59:59}";
        String result = c1.getInfo();
        assertEquals(expResult, result);
    }
    
    
    //test elapse
    @Test
    public void testElapse1(){
        Clock c1 = new Clock();
        c1.decMinute();
        c1.decSec();
        
        Clock c2 = new Clock();
        c2.decHour();
        c2.incMinute();
        c2.incSec();
        
        Clock c3 = new Clock();
        
        c3= c1.elapse(c2);
        
        String expResult = "Time{0:57:58}";
        String result = c3.getInfo();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testElapse2(){
        Clock c1 = new Clock();
        c1.decSec();
        Clock c2 = new Clock();
        c2.decSec();
        Clock c3 = new Clock();
        c3 = c2.elapse(c1);
        String expResult = "Time{0:0:0}";
        String result = c3.getInfo();
        assertEquals(expResult, result);
    }
    @Test
    public void testElapse3(){
        Clock c1 = new Clock();
        c1.decHour();    
        c1.decMinute();
        c1.incSec();
        
        Clock c2 = new Clock();
        c2.incHour();  
        c2.decMinute();
        c2.decSec();
        
        Clock c3 = new Clock();
        
        c3 = c1.elapse(c2);
        
        String expResult = "Time{22:1:2}";
        String result = c3.getInfo();
        assertEquals(expResult, result);
    }
    @Test
    public void testElapse4(){
        Clock c1 = new Clock();
        c1.decHour();    
        c1.decMinute();
        c1.incSec();
        
        Clock c2 = new Clock();
        c2.incHour();  
        c2.incMinute();
        c2.decSec();
        
        Clock c3 = new Clock();
        c3 = c1.elapse(c2);
        
        String expResult = "Time{21:59:2}";
        String result = c3.getInfo();
        assertEquals(expResult, result);
    }
    @Test
    public void testElapse5(){
        Clock c1 = new Clock();
        c1.decHour();
        c1.incMinute();
        c1.decSec();
        
        Clock c2 = new Clock();
        c1.decHour();
        c1.decMinute();
        c1.incSec();
        
        Clock c3 = new Clock();
        c3 = c1.elapse(c2);
        String expResult = "Time{22:0:0}";
        String result = c3.getInfo();
        assertEquals(expResult, result);
    }
    
    //test getinfo
    @Test
    public void testGetInfo1() {
        Clock c1 = new Clock();
        c1.decHour();
        c1.decMinute();
        c1.decSec();
        String expResult = "Time{22:58:59}";
        String result = c1.getInfo();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetInfo2() {
        Clock c1 = new Clock();
        c1.incHour();
        c1.incMinute();
        c1.incSec();
        String expResult = "Time{1:1:1}";
        String result = c1.getInfo();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetInfo3() {
        Clock c1 = new Clock();
        c1.decHour();
        c1.incMinute();
        c1.incSec();
        String expResult = "Time{23:1:1}";
        String result = c1.getInfo();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetInfo4() {
        Clock c1 = new Clock();
        c1.incHour();
        c1.decMinute();
        c1.incSec();
        String expResult = "Time{0:59:1}";
        String result = c1.getInfo();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetInfo5() {
        Clock c1 = new Clock();
        c1.incHour();
        c1.incMinute();
        c1.decSec();
        String expResult = "Time{1:0:59}";
        String result = c1.getInfo();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetInfo6() {
        Clock c1 = new Clock();
        c1.incHour();
        c1.decMinute();
        c1.decSec();
        String expResult = "Time{0:58:59}";
        String result = c1.getInfo();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetInfo7() {
        Clock c1 = new Clock();
        c1.decHour();
        c1.incMinute();
        c1.decSec();
        String expResult = "Time{23:0:59}";
        String result = c1.getInfo();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetInfo8() {
        Clock c1 = new Clock();
        c1.decHour();
        c1.decMinute();
        c1.incSec();
        String expResult = "Time{22:59:1}";
        String result = c1.getInfo();
        assertEquals(expResult, result);
    }
    @org.junit.Test
    public void testSomeMethod() {
    }
    
}
