import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Zoo {

    private Map<String,Integer> zoo;
    private Set<String> refusedAnimals;
    private Integer capacity;

    public Zoo(){
        zoo = new HashMap<>();
        refusedAnimals = new HashSet<>();
    }

    public void addAnimal(String animal){
        int account = 1;
        if(!refusedAnimals.contains(animal) && hasCapacity(zoo)){
            if(zoo.containsKey(animal)) {
                account = zoo.get(animal);
                zoo.put(animal, ++account);
            } else {
                zoo.put(animal, account);
            }
        }
    }

    public Map<String,Integer> getZoo(){
        return this.zoo;
    }

    public void removeAnimal(String animal){
        zoo.remove(animal);
    }

    public void addRefusedAnimal(String animal){
        refusedAnimals.add(animal);
    }


    public Set<String> getRefusedAnimals(){
        return this.refusedAnimals;
    }

    public Integer getCapacity(){
        return this.capacity;
    }

    public void setCapacity(Integer capacity){
        this.capacity = capacity;
    }

    public boolean hasCapacity(Map<String,Integer> zoo){
        return zoo.size() < getCapacity() ? true: false;
    }

    public Map<String,Integer> decreaseAnimal(String animal, Integer quantity){
        if(zoo.containsKey(animal)){
            Integer qtdAnimal = zoo.get(animal);
            if(qtdAnimal >= quantity){
                qtdAnimal = qtdAnimal -= quantity;
                zoo.put(animal,qtdAnimal);
            } else
                System.out.println("Impossible decrease the amount of " + animal);
        }  else
            System.out.println("There is no " + animal + " in the zoo.");
        return zoo;
    }

}
