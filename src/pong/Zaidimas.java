/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;

/**
 *
 * @author Aneta
 */
 public class Zaidimas extends Canvas implements Runnable{

 public static Paddle zaidejas;
 public static Kompiuteris pc;
 public static Kamuoliukas kamuoliukas;
 InputHandler IH;
 JFrame frame;
 public final int PLOTIS =500;
 public final int AUKSTIS =300 ;
 public final Dimension zaidimoDydis = new Dimension (PLOTIS, AUKSTIS);
 public final String PAVADINIMAS = "PingPong zaidimas";
 boolean zaidimasVeikia = false;
 int zaidejas1, zaidejas2;
 
 

 BufferedImage langas = new BufferedImage(PLOTIS, AUKSTIS, BufferedImage.TYPE_INT_RGB);
    
 Thread thread;
    public void run() {
      
        while(zaidimasVeikia)
        {
           tick();
           render();
                try{
                    Thread.sleep(3);
                }catch(Exception e)  {
                    e.printStackTrace();
                } 
        }
    }
public synchronized void start(){
    zaidimasVeikia = true;
    thread = new Thread(this);
    thread.start();
}
public synchronized void stop(){
    zaidimasVeikia = false;
    System.exit(0);
    
}

    public Zaidimas(){
            
        frame = new JFrame();
        setMinimumSize(zaidimoDydis);
        setPreferredSize(zaidimoDydis);
        setMaximumSize(zaidimoDydis);
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle(PAVADINIMAS);
        frame.setLocationRelativeTo(null);
     
        IH = new InputHandler(this);
         
        
        zaidejas = new Paddle(10,60);
        pc = new Kompiuteris(getWidth()-25 , 60);
        kamuoliukas = new Kamuoliukas(getWidth()/2, getHeight()/2);
        frame.addKeyListener(IH);
       // zaidimasVeikia = true;
        
    }
    public void tick(){
        zaidejas.tick(this);
        pc.tick(this);
        kamuoliukas.tick(this);
        
    }
    
    public void render(){
        BufferStrategy bs =  getBufferStrategy();
        if (bs ==null){
            
         createBufferStrategy(3);
        return;
        }
        Graphics g = bs.getDrawGraphics();
      
        g.drawImage (langas, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.white);
        g.drawString("Zaidejas 1: " + zaidejas1, 0, 10 );
        g.drawString("Zaidejas 2: " + zaidejas2, getWidth()-75,10 );

       zaidejas.render(g);
       pc.render(g);
       kamuoliukas.render(g);
       
       
        g.dispose();
        bs.show();
    }
    
    
    
   

   

 }