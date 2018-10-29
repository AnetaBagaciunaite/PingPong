/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.KeyEvent;
/**
 *
 * @author Aneta
 */
public class InputHandler implements KeyListener{
  
       
    public InputHandler(Zaidimas zaidimas){
            zaidimas.addKeyListener(this);
        }
        
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        
        int keyCode = e.getKeyCode();
        //1 zaidejas
        if(keyCode == e.VK_W)
        { 
            Zaidimas.zaidejas.iVirsu = true;            
        }
        if (keyCode == e.VK_S){
            Zaidimas.zaidejas.iApacia = true;
            
        }
        // 2 zaidejai
        
               if(keyCode == KeyEvent.VK_UP)
        {
            Zaidimas.pc.iVirsu = true;
            
        }
        if(keyCode == KeyEvent.VK_DOWN)
        {
            Zaidimas.pc.iApacia = true;
        }
        
         if(keyCode==KeyEvent.VK_ESCAPE)
         {
        System.exit(0);
    }  
    }
    
    

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // 1 zaidejas
        if(keyCode == e.VK_W)
        { 
        
            Zaidimas.zaidejas.iVirsu = false;            
        }
        if (keyCode == e.VK_S){
         
            Zaidimas.zaidejas.iApacia = false;
            
        }
        // 2 zaidejai
        if(keyCode == KeyEvent.VK_UP)
        {
            Zaidimas.pc.iVirsu = false;
            
        }
        if(keyCode == KeyEvent.VK_DOWN)
            Zaidimas.pc.iApacia = false;
        
    }

    
  
}
