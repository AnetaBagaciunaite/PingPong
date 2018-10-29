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
public class Paddle {
      int x;
      int y;
      int plotis =15;
      int aukstis =45;
      double greitis = 2;
      Rectangle deze;
    boolean iVirsu = false;
    boolean iApacia = false;
  
     public Paddle(int x, int y){
        this.x = x;
        this.y = y;
        deze = new Rectangle(x, y, plotis, aukstis);
        deze.setBounds(x, y, plotis, aukstis);
    }
     
    public void tick(Zaidimas zaidimas){
        deze.setBounds(x, y, plotis, aukstis);
        
      if(iVirsu && y >= 0)
      { 
          y-= greitis;
      }
      if(iApacia && y <= zaidimas.getHeight() - aukstis){
          y+=greitis;
    }
  
    }
    public void render(Graphics g){
        g.setColor(Color.BLUE);
       
      g.fillRect(x, y, plotis, aukstis);
    }
}
