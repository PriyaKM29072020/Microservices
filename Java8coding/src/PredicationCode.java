import java.util.function.Predicate;

public class PredicationCode {
public boolean testMth(Predicate<Integer> predicate,Integer input){
    return predicate.test(input);

}
}
