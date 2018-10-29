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
public class Kompiuteris {
      int x;
      int y;
      int plotis =15;
      int aukstis= 45;
      double greitis = 2;
      boolean zaidejai2 = false;
      
      Rectangle deze;
    boolean iVirsu = false;
    boolean iApacia = false;
    
  
     public Kompiuteris(int x, int y){
        this.x = x;
        this.y = y;
        deze = new Rectangle(x, y, plotis, aukstis);
        deze.setBounds(x, y, plotis, aukstis);
        
    }
     
    public void tick(Zaidimas zaidimas){
       
          deze.setBounds(x, y, plotis, aukstis);

      if(!zaidejai2){
          
      if(zaidimas.kamuoliukas.y < y && y>= 0){
        
          y-=greitis;
      }
      if(zaidimas.kamuoliukas.y > y && aukstis <= zaidimas.getHeight()) {
     
          y+=greitis;
      }
      } else {
    if(iVirsu ) {
        
        y-=greitis;    
    } else if(iApacia){
        
        y+=greitis;
    }
    
}
    }
    public void render(Graphics g){
        g.setColor(Color.BLUE);
       
      g.fillRect(x, y, plotis, aukstis);
    }
}


