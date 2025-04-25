import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Nivel 1 do jogo, contem alguns enimigos
 * 
 * @Francisco Adelino 
 */
public class Level1 extends Level
{
    public Level1()
    {     
        super(1, "normal");
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
        addObject(new Stone(),305,574);
        addObject(new Stone(),393,-634);
        addObject(new Stone(),529,-634);
        addObject(new Stone(),663,-634);
        addObject(new Stone(),799,-634);
        addObject(new Stone(),439,546);
        addObject(new Stone(),575,519);
        addObject(new Stone(),711,488);
        addObject(new Stone(),72,491);
        addObject(new Stone(),848,458);
        addObject(new Stone(),984,427);
        addObject(new Stone(),1114,559);
        addObject(new Stone(),286,349);
        addObject(new Stone(),72,163);
        addObject(new Stone(),587,248);
        addObject(new Stone(),722,244);
        addObject(new Stone(),972,199);
        addObject(new Stone(),1132,103);
        addObject(new Plant(),886,410);
        addObject(new Plant(),39,123);
        addObject(new Cactus(),656,211);
        addObject(new Stone(),400,65);
        addObject(new Stone(),230,-95);
        addObject(new Stone(),536,36);
        addObject(new Stone(),672,36);
        addObject(new Stone(),487,-165);
        addObject(new Stone(),927,-54);
        addObject(new Plant(),881,-104);
        addObject(new Stone(),429,-457);
        addObject(new Stone(),564,-457);
        addObject(new Stone(),698,-344);
        addObject(new Stone(),825,-456);
        addObject(new Plant(),555,-502);
        addObject(new Cactus(),733,-493);
        addObject(new Plant(),282,-141);
        addObject(new Stone(),71,-252);
        addObject(new Stone(),772,-261);
        addObject(new Stone(),1128,-223);
        addObject(new Stone(),972,-345);
        addObject(new Cactus(),480,-7);
        addObject(new Cactus(),1183,-264);
        addObject(new Stone(),301,-350);
        addObject(new Stone(),188,-580);
        addObject(new Stone(),995,-620);
        addObject(new Security(),914,-122);
        addObject(new Security(),513,-26);
        addObject(new Security(),257,1086);
        addObject(new Security(),988,359);
        List<Stone> stones = getObjects(Stone.class);
        for (int i = 0; i < stones.size(); i++){
            int x = stones.get(i).getX();
            int y = stones.get(i).getY() - 16;
            addObject(new Ground(), x, y);
        }
    }
}
