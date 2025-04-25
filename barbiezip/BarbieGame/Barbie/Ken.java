import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * A personagem principal Ken usada pelo player a esquerda do computador
 * 
 * @Leandro Gonçalves - 2123522
 */
public class Ken extends Players
{
    private GreenfootImage ken = getImage();
    private GreenfootImage ken1, ken2;

    public Ken(){
        ken1 = new GreenfootImage("ken1.png");
        ken2 = new GreenfootImage("ken2.png");
    }

    public void act()
    {
        movementManager("Ken", ken, ken1, ken2);
    }
}
