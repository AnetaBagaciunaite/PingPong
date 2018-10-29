/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Aneta
 */
public class Kamuoliukas {
    int x, y;
    int dydis = 16;
    int greitis = 2;
    int greitisx, greitisy;
    Rectangle deze;
    
    
    
    public Kamuoliukas(int x, int y)
    {
        this.x = x;
        this.y = y;
        greitisx = greitis;
        greitisy = greitis;
        deze = new Rectangle(x, y, dydis, dydis);
        deze.setBounds(this.x, this.y, this.dydis, this.dydis);
    }
    public void tick (Zaidimas zaidimas){
        
        deze.setBounds(x, y, dydis, dydis);

        if(x<=0)
        {
           zaidimas.zaidejas2++;
           greitisx = greitis;
           
        } else if (x+ dydis >= zaidimas.getWidth())
        {
            zaidimas.zaidejas1++;
            greitisx = -greitis;
            
        }
        if(y <=0){
            greitisy = greitis;
        }else if (y + dydis>= zaidimas.getHeight())
        {
            greitisy = -greitis;
        }
        x += greitisx;
        
        y += greitisy;
        
         lietimasis(zaidimas);
    }
    
    private void lietimasis(Zaidimas zaidimas) {
        
        if(deze.intersects(zaidimas.zaidejas.deze))
        {
            greitisx = greitis;
            
        }else if (deze.intersects(zaidimas.pc.deze)){
            greitisx= -greitis;
            
        }
    
    
}
    public void render (Graphics g){
        g.setColor(Color.red);
        g.fillOval(x, y, dydis, dydis);
        
    }
    }
