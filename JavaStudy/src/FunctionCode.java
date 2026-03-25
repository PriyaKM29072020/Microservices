import java.util.function.Function;

public class FunctionCode {
    /*
    * The Function interface consists of the following 4 methods,
    * as listed, which are later discussed as follows:

apply()
andThen()
compose()
identity()
    *
    * */

    public Integer applyMth(Integer i){
        Function <Integer,Integer> function=j->j*2;
        return function.apply(i);

    }
    //(after call )
    public Integer andThenMth(Integer i){

        Function <Integer,Integer> function=j->(int)j/3;
        Function <Integer,Integer> function1=j->j*2;
      return   function.andThen(function1).apply(i);
    }
    //(before call )
    public Integer composeMth(Integer i){
        Function <Integer,Integer> function=j->(int)j/3;
        Function <Integer,Integer> function1=j->j*2;
        return   function.compose(function1).apply(i);
    }
}
