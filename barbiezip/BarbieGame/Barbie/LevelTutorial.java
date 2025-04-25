import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Nivel tutorial com os comandos para o jogo
 * 
 * @LEandro Goncalves
 */
public class LevelTutorial extends Level
{
    public LevelTutorial(){
        addObject(new Tutorial(), 600, 400);
        addObject(new Tutorial2(), 600, 500);
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("e")){
            Greenfoot.setWorld(new Level0());
        }
    }
}
