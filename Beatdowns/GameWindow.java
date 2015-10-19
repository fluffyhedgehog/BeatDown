import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameWindow extends JPanel implements ActionListener, KeyListener
{   
    int dx = 300;
    int dy = 200;
    
    boolean down;
    boolean up;
    boolean right;
    boolean left;
    boolean punch;
    int facing = 0;
    
    public GameWindow()
    {
        setPreferredSize(new Dimension(800,600));
        setBackground(Color.WHITE);
        
        JFrame frame = new JFrame("a frame");
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(this);
        
        Timer t = new Timer(5, this);
        t.start();
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        update();
        repaint();
    }
    
    public void update()
    {
         
       
        if (up)
        {
            dy -= 1;
        }
        
        if (left)
        {
            dx -= 1;
        }
        
        if (down)
        {
            dy += 1;
        }
        
        if (right)
        {
            dx += 1;
        }
        System.out.println(facing);
        
    }
    
    public void draw(Graphics gc)
    {        
        gc.fillOval(dx,dy,10,10);
        //gc.fillRect(dx+ 3,dy,5,5);
        
        
        
       
        if (punch && facing == 0)
        {
            gc.fillRect(dx+ 3,dy - 2,5,5);
        }
        
        if (punch && facing == 3)
        {
            gc.fillRect(dx- 2,dy + 3,5,5);
        }
        
        if (punch && facing == 2)
        {
            gc.fillRect(dx+ 3,dy + 8,5,5); 
        }
        
        if (punch && facing == 1)
        {   
           gc.fillRect(dx+ 8,dy + 3,5,5);
        }
        
        
    }
    
    public void paintComponent(Graphics gc)
    {
        super.paintComponent(gc);
        draw(gc);
    }
    
    public void keyTyped(KeyEvent e)
    {
        
    }
    
    public void keyPressed(KeyEvent e){
        switch(e.getKeyChar()){
            case 'w':
                up = true;
                facing = 0;
            break;  
            
            case 'a':
                left = true;
                facing = 3;
            break;
            
            case 's':
                down = true;
                facing = 2;
            break;
            
            case 'd':
                right = true;
                facing = 1;
            break;
            
            case ' ':
                punch = true;
            break;
            
        }
    }
    
    public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyChar()){
            case 'w':
                up = false;
            break;  
            
            case 'a':
                left = false;
            break;
            
            case 's':
                down = false;
            break;
            
            case 'd':
                right = false;
            break;
            
            case ' ':
                punch = false;
            break;
        }
    }
    
    public static void main(String[] args)
    {
        new GameWindow();
    }
}