import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
PredicationCode predicationCode= new PredicationCode();
        Predicate<Integer> predicate=(i)->i<10;
        boolean b = predicationCode.testMth(predicate, 2);
        System.out.println("output of simple Predicate====>>>"+b);

    }
}