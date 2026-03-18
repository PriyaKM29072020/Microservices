import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PredicationCode predicationCode= new PredicationCode();
        List<Integer> intList= Arrays.asList(10,20,30,15,4,5,6,7,0);
        predicationCode.filterByObjectIndexByAtomic(intList);
        predicationCode.filterByObjectIndexByIntStream(intList);
    }
}