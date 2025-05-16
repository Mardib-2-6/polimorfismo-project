import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Zoo {
    public static void main(String[]args){
        Set<Animale> zoo=new HashSet<>();
        Animale leone1=new Leone("Simba");
        Animale leone2=new Leone("Alex");
        Animale cavallo=new Cavallo ("Mustafa");
        Animale giraffa=new Giraffa("gian");
        zoo.add(leone1);
        zoo.add(leone2);
        zoo.add(cavallo);
        zoo.add(giraffa);
        List<String>nomi=zoo.stream()
                .map(Animale::getNomeAnimale)
                .toList();
        for(String nome:nomi){
            System.out.println(nome);
        }



        /*for(Animale animale:zoo){
            System.out.println(animale.getNomeAnimale());
            animale.faiVerso();
            if(animale instanceof Predatore){
                ((Predatore)animale).vaiACaccia();
            }
            */
        }
    }

