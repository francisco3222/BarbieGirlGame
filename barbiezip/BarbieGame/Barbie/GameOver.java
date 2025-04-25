import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ecra de perda nos niveis de 0-3 em que mostra a barbie a ser apanhada e a ser posta numa caixa de bonecas como no filme
 * 
 * @Lucas Waddlle
 */
public class GameOver extends World
{
    private GreenfootSound dead;
    
    public GameOver()
    {
        super(1200, 800, 1); 
        dead = new GreenfootSound("Undertale_fans.mp3");
        dead.play();
        Greenfoot.stop();
    }
}
