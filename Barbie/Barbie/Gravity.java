import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * controla funcoes relacionadas com o movimento em geral do mundo, como graivdade ou o ecra ir descendo automaticamente
 * 
 * @Leandro Goncalves
 */
public class Gravity extends Actor
{
    private boolean falling, atGround;
    private int gravitySpeed; //a velocidade da gravidade quando cai
    private int contas;
    private int desceu;

    public void atGround(){
        if(isTouching(Ground.class)){
            gravitySpeed = 0;
            falling = false;
        } 
    }
    
    public void gravity(){
        if(!isTouching(Ground.class)){
            setLocation(getX(), getY()+ gravitySpeed);
            gravitySpeed++;
            falling = true;
        }
    }

    public boolean getFalling(){
        return falling;
    }

    public void setFalling(boolean fall){
        falling = fall;
    }

    public void setGravitySpeed(int speed){
        gravitySpeed = speed;
    }

    public void descendo(){
        int downSpeed = stayInScreen();
        if(getWorld() instanceof Level4){
            if (desceu < 800){
                setLocation(getX(), getY()+downSpeed);
                desceu++;
            }
        }
        else if ( getWorld() instanceof LevelTutorial){
            
        }
        else{
            if (desceu < 1200){
                setLocation(getX(), getY()+downSpeed);
                desceu++;
            }
        }
    }
    
    public int stayInScreen(){
        List<Players> players = getWorld().getObjects(Players.class);
        for (Players player : players){
            if(player.getY() < 100){
                return 5;
            }
        }
        return 1;
    }
}
