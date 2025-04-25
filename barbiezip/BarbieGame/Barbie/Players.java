import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Contem todas as funçoes exclusivas aos players mas que se aplicam a ambos, estas funçoes incluem controlos e coisas como quando devem perder ou ganhar o jogo
 * 
 * @Leandro Gonçalves - 2123522
 */
public class Players extends Gravity
{
    private boolean jumping, flip;
    private int jumpHeight, flipCounter, imageFliped;
    private World theLevel;

    /**
     * Uma funçao que tem o objetivo de chamar todas as funcoes dos players dependendo de quem e, dando as indicacoes corretas de teclas
     */
    public void movementManager(String player, GreenfootImage base, GreenfootImage walk1, GreenfootImage walk2){
        String right, left, up;
        if(player == "Barbie"){
            right = "right";
            left = "left";
            up = "up";
        } else {
            right = "d";
            left = "a";
            up = "w";
        }
        move(right, left, base, walk1, walk2);
        atGroundConfirm();
        jump(up);
        atGround();
        if(!getJumping())
            gravity();
        isDead();
        descendo();
        youWon();
        theEnd();
    }

    /**
     * funçao que permite o movimento dos players se a tecla para este estiver a ser precionada
     */
    public void move(String right, String left, GreenfootImage base, GreenfootImage walk1, GreenfootImage walk2){
        if(Greenfoot.isKeyDown(right)){
            move(5);
            moveImage(left, right, base, walk1, walk2);
        }
        if(Greenfoot.isKeyDown(left)){
            move(-5);
            moveImage(left, right, base, walk1, walk2);
        }
        if(!(Greenfoot.isKeyDown(left) || Greenfoot.isKeyDown(right))){
            setImage(base);
            imageFliped = 0;
        }
    }

    /**
     * funçao que cria a animacao durante o movimento dos players ao fazer um ciclo por estas enquanto o player ainda estiver a andar
     */
    public void moveImage(String left, String right, GreenfootImage base, GreenfootImage walk1, GreenfootImage walk2){
        if(flipCounter == 10){
            if(imageFliped == 0){
                setImage(walk1);
                imageFliped = 1;
            } else if (imageFliped == 1){
                setImage(base);
                imageFliped = 2;
            }else if (imageFliped == 2){
                setImage(walk2);
                imageFliped = 3;
            }else{
                setImage(base);
                imageFliped = 0;
            }
            flipCounter = 0;
        }
        flipCounter++;
        flipImage(base, walk1, walk2, left, right);
    }

    /**
     * funçao que vira a imagem do player e as respetivas imagens para que este ande dependendo da direcao que andou por ultimo
     */
    private void flipImage(GreenfootImage base, GreenfootImage walk1, GreenfootImage walk2, String left, String right){
        if(Greenfoot.isKeyDown(left)){
            if(!flip){
                base.mirrorHorizontally();
                walk1.mirrorHorizontally();
                walk2.mirrorHorizontally();
                flip = true;
            }
        }
        if(Greenfoot.isKeyDown(right)){
            if(flip){
                base.mirrorHorizontally();
                walk1.mirrorHorizontally();
                walk2.mirrorHorizontally();
                flip = false;
            }
        }
    }

    /**
     * funçao que define o salto dos players ao dar uma velocidade inicial que diminui com o tempo, eventualmente sendo 0 e acabando o salto deixando a gravidade tomar conta
     */
    public void jump(String up){
        if(Greenfoot.isKeyDown(up) && getFalling() == false && jumping == false){
            jumping = true;
            jumpHeight = 20;
            setLocation(getX(), getY()-jumpHeight);
        }
        else if (jumping == true && getFalling() == false){
            jumpHeight--;
            setLocation(getX(), getY()-jumpHeight);
        }
        if (jumping == true && jumpHeight <= 0){
            jumping = false;
            setFalling(true);
        }
    }

    /**
     * funçao que verifica se o player esta a tocar em um dos enimidos do tipo seguranca, e se tiver, devera executar a funçao de morte do respetivo nivel em que se encontra
     */
    public void isDead(){
        if(isTouching(Security.class) || getY() >= 799){
            World theLevel = getWorld();
            if (theLevel instanceof Level0)
                ((Level0)theLevel).death(this);
            if (theLevel instanceof Level1)
                ((Level1)theLevel).death(this);
            if (theLevel instanceof Level2)
                ((Level2)theLevel).death(this);
            if (theLevel instanceof Level3)
                ((Level3)theLevel).death(this);
            if (theLevel instanceof Level4)
                ((Level4)theLevel).death(this);
        } 
    }

    /**
     * funçao que ira permitir a mudanca para o proximo nivel do jogo quando algum dos players tocar no objeto de classe "Special" desde que a posicao no eixo dos Y deste seja
     * superior a 200 para impedir que os players possam passar de nivel sem estarem a espera disso e que apenas passem se for o proposito
     */
    public void youWon(){
        List<Special> specials = getWorld().getObjects(Special.class);
        if(!specials.isEmpty() && specials.get(0).getY() >= 200)
            if(isTouching(Special.class)){
                getWorld().addObject(new NextLevel(), 600, 400);
                Level level = getWorldOfType(Level.class);
                level.addPoints();
                getWorld().showText("" + level.getPontos(), 825, 292);
                Greenfoot.delay(200);
                NextLevel next = getWorld().getObjects(NextLevel.class).get(0);
                getWorld().removeObject(next);
                if (getWorld() instanceof Level0){
                    level.jukebox("stop", "entrance");
                    Greenfoot.setWorld(new Level1());
                }
                if (getWorld() instanceof Level1){
                    level.jukebox("stop", "normal");
                    Greenfoot.setWorld(new Level2());
                }
                if (getWorld() instanceof Level2)
                    Greenfoot.setWorld(new Level3());
                if (getWorld() instanceof Level3)
                    Greenfoot.setWorld(new Level4());
            }
    }

    /**
     * uma pequena funçao com o opjetivo de impedir que o player fique a meio das plataformas ao puxa-lo para cima se este se encontrar a meio de uma
     */
    public void atGroundConfirm(){
        List<Ground> platforms = getObjectsInRange(getImage().getHeight()/2 + 4, Ground.class);
        if(!platforms.isEmpty() && !(platforms.get(0).getY() == getY())){
            setLocation(getX(), getY()-5);
        }
    }

    /**
     * A funçao que define se o jogo terminou ao confirmar se o player esta a tocar no enimigo "Oppenheimer"
     */
    public void theEnd(){
        if(isTouching(Oppenheimer.class)){
            Level theLevel = getWorldOfType(Level.class);
            theLevel.jukebox("stop", "normal");
            Greenfoot.setWorld(new EndScreen());
        }
    }

    public boolean getJumping(){
        return jumping;
    }
}
