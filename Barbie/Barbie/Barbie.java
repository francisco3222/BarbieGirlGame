import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * A personagem principal Barbie usada pelo player a direita do computador
 * 
 * @Leandro Gonçalves - 2123522
 */
public class Barbie extends Players
{
    private GreenfootImage barbie = getImage();
    private GreenfootImage barbie1, barbie2, gif;

    public Barbie(){
        barbie1 = new GreenfootImage("barbie1.png");
        barbie2 = new GreenfootImage("barbie2.png");
    }

    public void act()
    {
        movementManager("Barbie", barbie, barbie1, barbie2);
    }
}