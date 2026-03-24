import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PredicationCode predicationCode= new PredicationCode();
        List<Integer> intList= Arrays.asList(10,20,30,15,4,5,6,7,0);
        FunctionCode functionCode=new FunctionCode();
        List<Integer> newIntList=intList.stream().map(functionCode::applyMth).toList();
      // intList.stream().map(functionCode::andThenMth).forEach(System.out::println);
       // System.out.println("andThenMth");
      //  intList.stream().map(functionCode::composeMth).forEach(System.out::println);
        ConsumerCode consumerCode=new ConsumerCode();
    consumerCode.acceptWith(intList);
    }
}