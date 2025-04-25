import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Ecra de Game Over no ultimo nivel, devido a este ser o nivel onde tem o Oppenheimer e ao perder neste nivel significa que ele foi capaz de usar a bomba
 * 
 * @Leandro Gonçalves -2123522
 */
public class City extends World
{
    public City()
    {    
        super(1200, 800, 1); 
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        addObject(new Boom(), 600, 400);
    }
}
