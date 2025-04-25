import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Nivel 2 do jogo
 * 
 * @Francisco Adelino 
 */
public class Level3 extends Level
{
    public Level3()
    {    
        super(3, "normal");
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
        addObject(new Stone(),208,557);
        addObject(new Stone(),72,527);
        addObject(new Stone(),425,400);
        addObject(new Stone(),559,400);
        addObject(new Stone(),693,400);
        addObject(new Security(),388,339);
        addObject(new Stone(),925,547);
        addObject(new Stone(),1132,409);
        addObject(new Stone(),828,371);
        addObject(new Plant(),783,327);
        addObject(new Cactus(),16,492);
        addObject(new Stone(),199,256);
        addObject(new Stone(),71,71);
        addObject(new Stone(),938,143);
        addObject(new Stone(),1070,144);
        addObject(new Stone(),1141,118);
        addObject(new Security(),892,87);
        addObject(new Plant(),1178,72);
        addObject(new Cactus(),1179,370);
        addObject(new Stone(),427,115);
        addObject(new Stone(),531,90);
        addObject(new Stone(),319,-101);
        addObject(new Stone(),453,-129);
        addObject(new Stone(),743,-60);
        addObject(new Stone(),983,-143);
        addObject(new Stone(),1119,-144);
        addObject(new Stone(),783,-310);
        addObject(new Stone(),647,-339);
        addObject(new Plant(),358,-147);
        addObject(new Cactus(),451,80);
        addObject(new Plant(),739,-352);
        addObject(new Security(),939,-205);
        addObject(new Security(),472,-400);
        addObject(new Stone(),514,-541);
        addObject(new Plant(),507,-585);
        addObject(new Cactus(),631,-575);
        addObject(new Stone(),67,-302);
        addObject(new Stone(),200,-301);
        addObject(new Security(),27,-364);
        addObject(new Stone(),128,-534);
        addObject(new Stone(),990,-409);
        addObject(new Stone(),1138,-539);
        addObject(new Cactus(),1038,-444);
        addObject(new Cactus(),76,-568);
        addObject(new Stone(),528,-339);
        addObject(new Stone(),545,-541);
        addObject(new Stone(),413,-541);
        addObject(new Stone(),659,-541);
        addObject(new Stone(),765,-541);
        addObject(new Stone(),689,204);
        addObject(new Security(),478,27);
        addObject(new Plant(),13,-346);
        addObject(new Plant(),931,-185);
        addObject(new Plant(),370,357);
        addObject(new Cactus(),1182,-180);
        addObject(new Cactus(),752,367);
        addObject(new Cactus(),261,-339);
        List<Stone> stones = getObjects(Stone.class);
        for (int i = 0; i < stones.size(); i++){
            int x = stones.get(i).getX();
            int y = stones.get(i).getY() - 16;
            addObject(new Ground(), x, y);
        }
    }
}
