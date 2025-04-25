import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Nivel 0 do jogo, nao contem enimigos e apenas serve para mostrar como vai ser os proximos niveis antes de ser preciso ter cuidado com os enimigos
 * 
 * @Francisco Adelino 
 */
public class Level0 extends Level
{
    public Level0()
    {    
        super(0, "entrance");
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
        addObject(new Plant(),79,-74);
        addObject(new Plant(),844,-357);
        addObject(new Cactus(),448,-415);
        addObject(new Cactus(),521,-676);
        addObject(new Plant(),664,-684);
        addObject(new Cactus(),991,43);
        addObject(new Plant(),283,257);
        addObject(new Cactus(),694,412);
    }

    /**
     * cria as plataformas usadas pelos players, e o objeto "Special" que permite passar para o proximo nivel
     */
    private void prepare()
    {
        addObject(new Stone(),986,603);
        addObject(new Stone(),850,603);
        addObject(new Stone(),610,603);
        addObject(new Stone(),396,606);
        addObject(new Stone(),738,450);
        addObject(new Stone(),600,420);
        addObject(new Stone(),336,448);
        addObject(new Stone(),259,607);
        addObject(new Stone(),261,606);
        addObject(new Stone(),72,440);
        addObject(new Stone(),1123,494);
        addObject(new Stone(),940,376);
        addObject(new Stone(),236,309);
        addObject(new Stone(),371,279);
        addObject(new Stone(),1075,376);
        addObject(new Stone(),767,257);
        addObject(new Stone(),560,135);
        addObject(new Stone(),901,225);
        addObject(new Stone(),1130,268);
        addObject(new Stone(),696,134);
        addObject(new Stone(),693,135);
        addObject(new Stone(),324,63);
        addObject(new Stone(),130,-26);
        addObject(new Stone(),55,163);
        addObject(new Stone(),1043,83);
        addObject(new Stone(),788,-25);
        addObject(new Stone(),498,-110);
        addObject(new Stone(),362,-143);
        addObject(new Stone(),226,-177);
        addObject(new Stone(),666,-277);
        addObject(new Stone(),393,-634);
        addObject(new Stone(),529,-634);
        addObject(new Stone(),663,-634);
        addObject(new Stone(),799,-634);
        addObject(new Special(), 600, -675);
        addObject(new Stone(),1049,-162);
        addObject(new Stone(),408,-376);
        addObject(new Stone(),153,-493);
        addObject(new Stone(),801,-306);
        addObject(new Stone(),938,-355);
        addObject(new Stone(),1129,-516);
        addObject(new Stone(),674,-479);
        List<Stone> stones = getObjects(Stone.class);
        for (int i = 0; i < stones.size(); i++){
            int x = stones.get(i).getX();
            int y = stones.get(i).getY() - 16;
            addObject(new Ground(), x, y);
        }
    }
}
