import java.util.ArrayList;
import java.util.List;
public class Zoo {
    public static void main(String[]args){
        List<Animale> zoo=new ArrayList<>();
        Animale leone1=new Leone("Simba");
        Animale leone2=new Leone("Alex");
        Animale cavallo=new Cavallo ("Mustafa");
        Animale giraffa=new Giraffa("gian");
        zoo.add(leone1);
        zoo.add(leone2);
        zoo.add(cavallo);
        zoo.add(giraffa);
        for(Animale animale:zoo){
            System.out.println(animale.getNomeAnimale());
            animale.faiVerso();
            if(animale instanceof Predatore){
                ((Predatore)animale).vaiACaccia();
            }
            
        }
    }
}
