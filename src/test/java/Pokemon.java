import java.util.*;

public class Pokemon {
    public static void main(String[] args) {

        List<String> listOfPokemons1 = new ArrayList<>(Arrays.asList("Charmander", "Charizard", "JigglyPuff","Snorelax","Pikachu"));
        List<String> listOfPokemons2 = new ArrayList<>(Arrays.asList( "JigglyPuff","Snorelax","Pikachu"));
        List<String> listOfPokemons3 = new ArrayList<>(Arrays.asList("JigglyPuff", "Pikachu", "Charmander","Snorelax","Charizard"));
        list(listOfPokemons1);
        System.out.println("--------");
        list(listOfPokemons2);
        System.out.println("--------");
        list(listOfPokemons3);
    }
    public static void list(List list){
        String[] orderedList =new String[5];
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Pikachu");
        map.put(1, "Charmander");
        map.put(2, "Snorelax");
        map.put(3, "JigglyPuff");
        map.put(4, "Charizard");

        for(int i=0;i<list.size();i++) {
            for (Map.Entry<Integer,String> entry : map.entrySet()) {
                if(entry.getValue().equals(list.get(i))){
                    orderedList[entry.getKey()] = (String)list.get(i);
                }
            }
        }
        for(String name:orderedList){
            if(name!=null){
                System.out.println(name);
            }
        }
    }
}

/**
 * Create a method, that takes an array of Pokemon in any order, and outputs them in this customized order
 * 1. Pikachu
 * 2. Charmander
 * 3. Snorelax
 * 4. JigglyPuff
 * 5. Charizard
 *
 * Example input - [Charmander, Snorelax, Pikachu, Charizard, JigglyPuff]
 *        output - [Pikachu, Charmander, Snorelax, JigglyPuff, Charizard]
 *
 * Example input - [Charizard, Pikachu , Charmander]
 *        output - [Pikachu, Charmander , Charizard]
 *
 */
