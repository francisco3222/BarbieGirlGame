import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Nivel base usado na criacao de outros niveis e para coisas comuns em todos como pontos e vidas
 * 
 * @Leandro Goncalves
 */
public class Level extends World
{
    private static int pontos, vidas;
    private int time, contador;
    private GreenfootSound fundo1, fundo2;

    public Level()
    {    
        super(1200, 800, 1, false);
        setPaintOrder(NextLevel.class, GameOver.class, Vidas.class, Barbie.class, Ken.class, Special.class, Stone.class, Plant.class, Cactus.class, Ground.class);
        addObject(new Vidas(), 100, 50);
        fundo1 = new GreenfootSound("fundo1.mp3");
        fundo2 = new GreenfootSound("Undertale_menu.mp3");
        showText("Pontos: " + pontos, 600, 50);
        addObject(new Barbie(),300, 680);
        addObject(new Ken(), 200, 680);
        pisoDePedra();
        for(int i = 0; i < getWidth(); i += 96){
            addObject(new Ground(), i, 747);
        }
    }

    public Level(int level, String music)
    {    
        super(1200, 800, 1, false);
        setPaintOrder(NextLevel.class, GameOver.class, Vidas.class, Barbie.class, Ken.class, Special.class, Stone.class, Plant.class, Cactus.class, Ground.class);
        addObject(new Vidas(), 100, 50);
        fundo1 = new GreenfootSound("fundo1.mp3");
        fundo2 = new GreenfootSound("Undertale_menu.mp3");
        showText("Pontos: " + pontos, 600, 50);
        showText("Nivel " + level, 600, 50);
        addObject(new Barbie(),300, 680);
        addObject(new Ken(), 200, 680);
        setTime(120);
        jukebox("stop", "entrance");
        jukebox("stop", "normal");
        jukebox("start", music);
        pisoDePedra();
    }

    /**
     * uma funcao que vai adicionar um chao de pedra no fundo do nivel
     */
    public void pisoDePedra()
    {
        for(int i = 0; i < getWidth(); i += 96){
            addObject(new Stone(), i, 747);
        }
    }

    /**
     * uma funcao que tem o objetivo de iniciar e parar musicas de fundo em comando
     */
    public void jukebox(String state, String music){
        if(state == "start"){
            if(music == "entrance")
                fundo2.playLoop();
            if(music == "normal")
                fundo1.playLoop();
        }
        if(state == "stop"){
            if(music == "entrance")
                fundo2.stop();
            if(music == "normal")
                fundo1.stop();
        }
    }

    /**
     * um temporizador que aparece no topo do nivel que ser'a usado para os niveis
     */
    public void timer(){
        if(contador == 60){
            time--;
            contador = 0;
        }
        contador++;
        showText("" + time, 600, 80);
    }

    public void setTime(int newTime){
        time = newTime;
    }

    public int getPontos(){
        return pontos;
    }

    public int getAVida(){
        return vidas;
    }

    public void addPoints(){
        pontos += time;
    }

    /**
     * uma funcao que ira criar o efeito de perder ao piscar as suas texturas, e se ainda tiver mais que 0 vidas ira reininciar o nivel atual, senao ira saltar para o ecra de fim de jogo
     */
    public void hyperDeath(Players player, boolean last){
        for(int i = 0; i < 3; i++){
            player.getImage().setTransparency(0);
            Greenfoot.delay(10);
            player.getImage().setTransparency(255);
            Greenfoot.delay(10);
        }
        if(vidas > 0){
            vidas--;
            List<Stone> stones = getObjects(Stone.class);
            List<Ground> ground = getObjects(Ground.class);
            List<Plant> plants = getObjects(Plant.class);
            List<Cactus> cactus = getObjects(Cactus.class);
            List<Enemies> enemies = getObjects(Enemies.class);
            removeObjects(stones);
            removeObjects(ground);
            removeObjects(plants);
            removeObjects(cactus);
            removeObjects(enemies);
            if(!last)
                removeObject(getObjects(Special.class).get(0));
            Players ken = getObjects(Ken.class).get(0);
            Players barbie = getObjects(Barbie.class).get(0);
            ken.setLocation(200, 680);
            barbie.setLocation(300, 680);
        }
        if(vidas == 0){
            fundo1.stop();
            fundo2.stop();
            restartP();
            restartVidas();
            if (!last)
                Greenfoot.setWorld(new GameOver());
            else
                Greenfoot.setWorld(new City());
        }
    }

    public static void restartP(){
        pontos = 0;
    }

    public static void restartVidas(){
        vidas = 3;
    }
}
