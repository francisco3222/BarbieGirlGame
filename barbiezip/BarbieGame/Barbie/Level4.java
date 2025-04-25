import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Nivel 2 do jogo
 * 
 * @Francisco Adelino / Lucas Waddle
 */
public class Level4 extends Level
{
    public Level4()
    {    
        super(4, "normal");
        decoracao();
        prepare();
    }
    
    public void act(){
        timer();
    }

    /**
     * controla o caso de perder uma vida reininciando o nivel
     */
    public void death(Players player){;
        hyperDeath(player, true);
        pisoDePedra();
        decoracao();
        prepare();
    }

    /**
     * coloca decoracao no nivel como as plantas e cactos
     */
    private void decoracao(){
        addObject(new Cactus(),getWidth()/2, 707);
        addObject(new Cactus(),getWidth()-100, 707);
        addObject(new Cactus(),getWidth()-1100, 707);
        addObject(new Plant(),getWidth()/3, 707);
        addObject(new Plant(),getWidth()-300, 707);
        addObject(new Plant(),getWidth()-1000, 707);
    }

    /**
     * cria as plataformas usadas pelos players, e o objeto "Special" que permite passar para o proximo nivel
     */
    private void prepare()
    {
        addObject(new Stone(),71,854);
        addObject(new Stone(),324,417);
        addObject(new Stone(),452,417);
        addObject(new Stone(),68,267);
        addObject(new Stone(),495,41);
        addObject(new Stone(),627,41);
        addObject(new Stone(),285,122);
        addObject(new Security(),467,-27);
        addObject(new Stone(),65,-190);
        addObject(new Stone(),198,-167);
        addObject(new Stone(),330,-166);
        addObject(new Security(),169,-225);
        addObject(new Stone(),643,-487);
        addObject(new Stone(),775,-487);
        addObject(new Stone(),1036,-488);
        addObject(new Oppenheimer(),880,-545);
        addObject(new Stone(),209,-374);
        addObject(new Stone(),423,-447);
        addObject(new Stone(),614,-134);
        addObject(new Stone(),911,-487);
        addObject(new Plant(),268,371);
        addObject(new Cactus(),518,377);
        addObject(new Plant(),442,-6);
        addObject(new Cactus(),688,3);
        addObject(new Plant(),144,-212);
        addObject(new Cactus(),392,-203);
        addObject(new Cactus(),150,-407);
        addObject(new Cactus(),1025,-535);
        addObject(new Plant(),605,-535);
        addObject(new Cactus(),225,93);
        addObject(new Plant(),11,1325);
        addObject(new Security(),289,350);
        addObject(new Security(),562,-198);
        addObject(new Security(),25,203);
        addObject(new Stone(),68,568);
        List<Stone> stones = getObjects(Stone.class);
        for (int i = 0; i < stones.size(); i++){
            int x = stones.get(i).getX();
            int y = stones.get(i).getY() - 16;
            addObject(new Ground(), x, y);
        }
    }
}
