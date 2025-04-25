import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Um objeto que fica no topo do nivel e e usado para passar para o proximo
 * 
 * @Lucas Waddlle
 */
public class Special extends LevelObjects
{
    public void act(){
        if (!isTouching(NextLevel.class))
            descendo();
    }
}
