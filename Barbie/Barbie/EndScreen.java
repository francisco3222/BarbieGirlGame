import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ecra de vitoria que mostra um trofeu e os pontos finais
 * 
 * @Leandro Gonçalves
 */
public class EndScreen extends World
{
    private GreenfootSound endGame;
    
    public EndScreen()
    {    
        super(1200, 800, 1); 
        endGame = new GreenfootSound("barbie.mp3");
        endGame.play();
        Level level = new Level();
        showText("" + level.getPontos(), 600, 750);
    }
}
