import java.util.function.Supplier;

public class SupplierCode {

    static String supplierCodeMth(){

        /* It represents a function which does not take
         in any argument but produces a value of type T
         T get();
         */
        Supplier<String>supplier=()->"Priyanka";
        return supplier.get();
    }
    public static void main(String[] args) {
        System.out.println(supplierCodeMth());

    }
}
