import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Vidas dos players, quando chegam a 0 terminam o jogo
 * 
 * @Leandro Gonçalves - 2123522
 */
public class Vidas extends Actor
{
    private Level level;
    private GreenfootImage coracao3, coracao2, coracao1;

    public Vidas()
    {
        coracao3 = getImage();
        coracao2 = new GreenfootImage("2coraçoes.png");
        coracao1 = new GreenfootImage("1coraçao.png");
    }
    
    public void act(){
        checkLife();
    }

    /**
     * funçao que muda a imagem dependendo da quantidade de vidas atualmente
     */
    public void checkLife(){
        level = getWorldOfType(Level.class);
        int lifeStatus = level.getAVida();
        GreenfootImage imagem = getImage();
        if (lifeStatus == 3 && imagem != coracao3){
            setImage(coracao3);
        } else if (lifeStatus == 2 && imagem != coracao2){
            setImage(coracao2);
        } else if (lifeStatus == 1 && imagem != coracao1){
            setImage(coracao1);
        }
    }
}
