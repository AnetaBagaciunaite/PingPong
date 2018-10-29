/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

/**
 *
 * @author Aneta
 */
public class PagrindinisMeniu extends JFrame{
    int ekranoPlotis = 275;
    int ekranoAukstis = 200;
    int mygtukoPlotis = 100;
    int mygtukoAukstis = 40;
    
    JButton Zaisti, Iseiti;
    JCheckBox zaidejas2;
    
    
    public PagrindinisMeniu()
    {
         pridetiMygtukus();
         pridetiVeiksmus();
         getContentPane().setLayout(null);
         Zaisti.setBounds((ekranoPlotis - mygtukoPlotis)/2 ,5,  mygtukoPlotis, mygtukoAukstis);
         Iseiti.setBounds((ekranoPlotis - mygtukoPlotis)/ 2, 50, mygtukoPlotis,  mygtukoAukstis );
         zaidejas2.setBounds((ekranoPlotis - mygtukoPlotis )/2,95, mygtukoPlotis, mygtukoAukstis);
         getContentPane().add(Zaisti);
         getContentPane().add(Iseiti);
         getContentPane().add(zaidejas2);
         
         
         pack();
         setVisible(true);
         setLocationRelativeTo(null);
         setSize(ekranoPlotis, ekranoAukstis);
         setTitle("PingPong");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setResizable(false);
         
    }
    
    private void pridetiMygtukus(){
    
        Zaisti = new JButton("Zaisti");
        Iseiti = new JButton ("Iseiti");
        zaidejas2 = new JCheckBox ("Du zaidejai?");
}
    private void pridetiVeiksmus(){
        
        Zaisti.addActionListener(new ActionListener()
                
                {
           
            public void actionPerformed(ActionEvent e) {
                dispose();
                Zaidimas zaidimas = new Zaidimas();
                if(zaidejas2.isSelected())
                {
                    zaidimas.pc.zaidejai2= true;
                }
                else
                {
                    zaidimas.pc.zaidejai2 = false;
               
                    
                }
                 zaidimas.start();
            }
                });
                
             Iseiti.addActionListener(new ActionListener()
                {
          
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
                }
        ); 
      
    }

}
