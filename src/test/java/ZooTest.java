import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Map;


public class ZooTest {

    @Test
    public void test_class_instance_should_not_null(){
        Zoo mock = Mockito.spy(Zoo.class);
        Assert.assertNotNull(mock);
    }

    @Test
    public void test_add_unique_animal_with_zooCapacity(){
        Zoo zoo = new Zoo();
        zoo.setCapacity(1);
        zoo.addAnimal( "giraffle");
        Assert.assertTrue(zoo.getZoo().containsKey("giraffle"));
    }

    @Test
    public void test_add_unique_animal_without_zooCapacity(){
        Zoo zoo = new Zoo();
        zoo.setCapacity(0);
        zoo.addAnimal( "giraffle");
        Assert.assertFalse(zoo.getZoo().containsKey("giraffle"));
    }

    @Test
    public void test_add_duplicate_animal_with_zooCapacity(){
        Zoo zoo = new Zoo();
        zoo.setCapacity(2);
        zoo.addAnimal("giraffle");
        zoo.addAnimal("giraffle");
        Assert.assertEquals(2L,zoo.getZoo().get("giraffle").longValue());
    }

    @Test
    public void test_add_refused_animal(){
        Zoo zoo = new Zoo();
        zoo.addRefusedAnimal( "cat");
        Assert.assertTrue(zoo.getRefusedAnimals().contains("cat"));
    }

    @Test
    public void test_not_add_refused_animal_in_zoo(){
        Zoo zoo = new Zoo();
        zoo.addRefusedAnimal( "cat");
        zoo.addAnimal( "cat");
        Assert.assertFalse(zoo.getZoo().containsKey("cat"));
    }

    @Test
    public void test_remove_animal(){
        Zoo zoo = new Zoo();
        zoo.setCapacity(1);
        zoo.addAnimal("giraffle");
        zoo.removeAnimal("giraffle");
        Assert.assertFalse(zoo.getZoo().containsKey("cat"));
    }

    @Test
    public void test_has_capacity(){
        Zoo zoo = new Zoo();
        zoo.setCapacity(2);
        zoo.addAnimal("giraffle");
        Map<String,Integer> zooMap = zoo.getZoo();
        Assert.assertTrue(zoo.hasCapacity(zooMap));
    }

    @Test
    public void test_has_not_capacity(){
        Zoo zoo = new Zoo();
        zoo.setCapacity(1);
        zoo.addAnimal("giraffle");
        zoo.addAnimal("lion");
        Map<String,Integer> zooMap = zoo.getZoo();
        Assert.assertFalse(zoo.hasCapacity(zooMap));
    }

    @Test
    public void test_decrease_animal_there_is_no_exist_in_zoo(){
        Zoo zoo = new Zoo();
        zoo.decreaseAnimal("lion",1);
        Assert.assertTrue(zoo.getZoo().isEmpty());
    }

    @Test
    public void test_decrease_animal_there_is_less_quantity_in_zoo(){
        Zoo zoo = new Zoo();
        zoo.setCapacity(1);
        zoo.addAnimal("lion");
        zoo.decreaseAnimal("lion",2);
        Assert.assertTrue(zoo.getZoo().get("lion") == 1);
    }

    @Test
    public void test_decrease_animal_there_is_more_quantity_in_zoo(){
        Zoo zoo = new Zoo();
        zoo.setCapacity(2);
        zoo.addAnimal("tiger");
        zoo.addAnimal("tiger");
        zoo.decreaseAnimal("tiger",1);
        Assert.assertTrue(zoo.getZoo().get("tiger") == 1);
    }

}
