import java.util.List;
import java.util.function.Consumer;

public class ConsumerCode {
    /*
    * void accept(T t) and
    * default Consumer <T>
        andThen(Consumer<? super T> after)
    *
    * */
    static void  acceptWith(List<Integer>lst)
{
    Consumer<List<Integer>> consumer=list->{
        list.replaceAll(integer -> 2 * integer);
    };
    consumer.accept(lst);
}
    public static void main(String[] args) {

    }
}
