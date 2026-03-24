import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PredicationCode {
public boolean testMth(Predicate<Integer> predicate,Integer input){
    return predicate.test(input);

}
public Predicate<Integer> isEqualsMth(Integer input2){
    //isEqual static method
    return Predicate.isEqual(input2);

}
    public Predicate<Integer> oRMth(Predicate<Integer> predicate1,Predicate<Integer> predicate2){
        //isEqual static method
        //return Predicate.isEqual(input2);
        return  predicate1.or(predicate2);

    }/*
    2. Filtering by Index
    Sometimes we want to filter elements based on their position in a collection.*/
    //1: using : Using AtomicInteger
    public  <T> void filterByObjectIndexByAtomic(List<T> t){
        AtomicInteger i = new AtomicInteger(0);
        t.stream().filter(t1 -> i.getAndIncrement() % 2 == 0).
        forEach(System.out::println);
    }
    /*Approach 2: Using IntStream
    We can use Intstream and map the array elements based on the index.
    Here first we create an Intstream of a range of numbers. Check if a number is even,
    then overwrite/map the integer with the array element.*/
    public  <T> void filterByObjectIndexByIntStream(List<T> t){
        IntStream.rangeClosed(0, t.size() - 1)
                .filter(x -> x % 2 == 0)
                .mapToObj(t::get)
                .forEach(System.out::println);
    }
    //Custom Filter Functions
    public  <T> boolean filterByCustomProperties(int t)
    {
       if( t% 2==0){
           return Boolean.TRUE;
       }
       return Boolean.FALSE;
    }
}
