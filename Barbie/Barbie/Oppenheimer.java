import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Enimigo final do Jogo, apenas e preciso tocar nele para vencer
 * 
 * @Francisco Adelino / Lucas Waddle
 */
public class Oppenheimer extends Enemies
{
    private GreenfootImage base, walk1, walk2;
    private int direction;

    public Oppenheimer(){
        base = getImage();
        walk1 = new GreenfootImage("oppenheimer1.png");
        walk2 = new GreenfootImage("oppenheimer2.png"); 
        direction = 3;
    }

    public void act()
    {
        gravity();
        atGround();
        moving(direction);
        moveImage(base,walk1,walk2);
    }
    
    /**
     * uma funçao que faz o Oppenheimer mover entro de uma area entre catos e plantas
     */
    public void moving(int speed){
        if ((direction == 3 && isTouching(Cactus.class)) || (direction == -3 && isTouching(Plant.class)) || isAtEdge()) 
            direction = -direction;
        move(direction);
    }
}
