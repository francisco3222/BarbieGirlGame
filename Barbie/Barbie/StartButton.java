import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Botao de iniciar jogo
 * 
 * @Leandro Gonçalves - 2123522
 */
public class StartButton extends Actor
{
    private Start start;
    
    public void act(){
        if (Greenfoot.mousePressed(this))
        {
            start = getWorldOfType(Start.class);
            start.getMenuMusic().stop();
            Greenfoot.setWorld(new LevelTutorial());
        }
    }
}
