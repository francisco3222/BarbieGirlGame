import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * um enimigo comum no jogo que apenas anda numa area podendo descer de plataformas durante o jogo
 * 
 * @Francisco Adelino - 2167322
 */
public class Security extends Enemies
{
    private GreenfootImage enemy, enemy1, enemy2;
    private int flipCounter; // contador para mudar a imagem
    private int imageFliped; //qual a imagem a ser usado
    private int direction;
    public Security(){
        style();    
        direction = 1;
    }
    
    /**
     * uma funçao que define se o enimigo vai ser um segurança ou um empresario
     */
    private void style(){
        if(Greenfoot.getRandomNumber(2) == 0){
            enemy = getImage();
            enemy1 = new GreenfootImage("secure1.png");
            enemy2 = new GreenfootImage("secure2.png");
        } else{
            enemy = new GreenfootImage("business.png");
            enemy1 = new GreenfootImage("business1.png");
            enemy2 = new GreenfootImage("business2.png");
        }
    }

    public void act()
    {
        moveImage(enemy,enemy1,enemy2);
        moving(direction);
        gravity();
        atGround();
    }
    
    /**
     * funçao que permite o movimento dentro de areas especificas com uma baixa velocidade
     */
    public void moving(int speed){
        if ((direction == 1 && isTouching(Cactus.class)) || (direction == -1 && isTouching(Plant.class)) || isAtEdge()) 
            direction = -direction;
        move(direction);
    }
}
