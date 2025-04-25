import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Nivel 2 do jogo
 * 
 * @Francisco Adelino 
 */
public class Level2 extends Level
{
    public Level2()
    {    
        super(2, "normal");
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
        hyperDeath(player, false);
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
        addObject(new Special(), 600, -675);
        addObject(new Stone(),127,596);
        addObject(new Stone(),247,596);
        addObject(new Stone(),384,569);
        addObject(new Stone(),69,372);
        addObject(new Stone(),518,542);
        addObject(new Stone(),854,473);
        addObject(new Stone(),985,446);
        addObject(new Stone(),1130,581);
        addObject(new Stone(),314,293);
        addObject(new Stone(),449,265);
        addObject(new Stone(),423,-581);
        addObject(new Stone(),555,-581);
        addObject(new Stone(),689,-581);
        addObject(new Stone(),822,-581);
        addObject(new Stone(),1129,277);
        addObject(new Stone(),639,380);
        addObject(new Stone(),740,190);
        addObject(new Stone(),875,190);
        addObject(new Stone(),78,49);
        addObject(new Stone(),177,84);
        addObject(new Stone(),437,-31);
        addObject(new Stone(),562,-31);
        addObject(new Stone(),1138,-2);
        addObject(new Stone(),1038,20);
        addObject(new Stone(),825,-129);
        addObject(new Stone(),192,-221);
        addObject(new Stone(),67,-404);
        addObject(new Stone(),502,-369);
        addObject(new Stone(),371,-369);
        addObject(new Stone(),1131,-49);
        addObject(new Stone(),966,-330);
        addObject(new Stone(),813,-582);
        addObject(new Cactus(),304,562);
        addObject(new Security(),73,532);
        addObject(new Plant(),70,550);
        addObject(new Cactus(),939,152);
        addObject(new Plant(),680,145);
        addObject(new Security(),700,127);
        addObject(new Plant(),389,-78);
        addObject(new Security(),389,-93);
        addObject(new Cactus(),561,-403);
        addObject(new Plant(),315,-410);
        addObject(new Security(),325,-430);
        addObject(new Security(),259,-556);
        addObject(new Plant(),26,4);
        addObject(new Plant(),1021,-374);
        addObject(new Plant(),571,-629);
        addObject(new Cactus(),699,-618);
        addObject(new Cactus(),1188,-525);
        addObject(new Plant(),1181,-45);
        addObject(new Cactus(),903,442);
        addObject(new Plant(),1043,397);
        addObject(new Cactus(),162,48);
        List<Stone> stones = getObjects(Stone.class);
        for (int i = 0; i < stones.size(); i++){
            int x = stones.get(i).getX();
            int y = stones.get(i).getY() - 16;
            addObject(new Ground(), x, y);
        }
    }
}
