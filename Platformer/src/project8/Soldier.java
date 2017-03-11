package project8;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Soldier extends Sprite {

    private int dx;
    private int dy;
    private ArrayList<Missile> missiles;

    public Soldier(int x, int y) {
        super(x, y);

        initCraft();
    }

    private void initCraft() {
        
        missiles = new ArrayList<>();
        loadImage("Images/Soldier350.png");
        getImageDimensions();
    }

    public void move() {
    	
    	lift = Math.max(lift -1,  0);

        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }
    
    @Override
    public int getY() {
    	return super.getY() -lift;
    }

    public ArrayList getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ENTER) {
            fire();
        }
        //back/left
        if (key == KeyEvent.VK_A) {
            dx = -1;
        }
        //forward/right
        if (key == KeyEvent.VK_D) {
            dx = 1;
        }
        //up
        if (key == KeyEvent.VK_W) {
            dy = -1;
        }

        /*if (key == KeyEvent.VK_S) {
            dy = 1;
        }*/
    
        //jump
        if (key == KeyEvent.VK_SPACE){
        	jump(); 
           
        }
    }


    int lift = 0;
    static final int MAX_LIFT = 350 ; 
    
    
    private void jump() {
		// TODO Auto-generated method stub
    	
    	if(lift <= 0){
    		lift = MAX_LIFT;
    		
    		
    	}
    	
    	
		
	}

	public void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            dx = 0;
        }

        if (key == KeyEvent.VK_D) {
            dx = 0;
        }

        if (key == KeyEvent.VK_W) {
            dy = 0;
        } 

        /*if (key == KeyEvent.VK_S) {
            dy = 0;
        }*/
    }
}