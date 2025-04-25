import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Imagem usada no ecra de Game Over do ultimo nivel
 * 
 * @Leandro Goncalves
 */
public class Boom extends Actor
{
    private GreenfootSound siren;
    
    public Boom(){
        getImage().setTransparency(0);
        siren = new GreenfootSound("sirene.mp3");
        siren.playLoop();
        for(int i = 0; i < 256; i++)
            getImage().setTransparency(i);
    }
}
