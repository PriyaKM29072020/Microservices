import java.util.Objects;
import java.util.function.Predicate;

public class PredicationCode {
public boolean testMth(Predicate<Integer> predicate,Integer input){
    return predicate.test(input);

}
public Predicate<Integer> isEqualsMth(Integer input2){
    //isEqual static method
    return Predicate.isEqual(input2);

}
}
