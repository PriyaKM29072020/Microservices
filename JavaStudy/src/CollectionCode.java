import java.util.*;
import java.util.stream.Collectors;

public class CollectionCode {
    public static void main(String[] args) {
        //convertListIntoMap();
        groupingByMth();

    }

     static LinkedHashMap<String, Employee> convertListIntoMap() {
        LinkedHashMap<String, Employee> convertListIntoMap = Employee.employeeList().stream().collect(Collectors.toMap(Employee::getName,
                e -> e, (existing, replacement) -> replacement, // Merge function for duplicate keys
                LinkedHashMap::new));
        convertListIntoMap.entrySet().forEach(System.out::println);
        return convertListIntoMap;
    }
static void sortedMth(){
        List<Employee>employeeList=Employee.employeeList();
        //thenComparing is a chaining sorting
       // employeeList.stream().sorted(Comparator.comparing(employee -> employee).thenComparing(employee -> employee)).toList().forEach(System.out::println);
//sort  List default method ===return void
    //
    employeeList.sort(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
    employeeList.forEach(System.out::println);


    }
    static void sortedMthForMap(){
        LinkedHashMap<String, Employee> convertListIntoMap=convertListIntoMap();
    }

/*
*  Java that collects statistical summary information about integer
*  elements in a stream, providing metrics like count, sum, min, average, and max.
* */
    static void statisticsInJava8(){
        List<Employee>employeeList=Employee.employeeList();
        DoubleSummaryStatistics employeeSalaryStatistics=
                employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

      //  employeeSalaryStatistics.

    }

    /*
    * Collectors.partitioningBy() method which separates input elements based on supplied Predicate.
    *
    * */

    static void groupingByMth() {
        //1: Just Grouping on based by Key
        Map<String, List<Employee>> groupingByMth =
                Employee.employeeList().stream().collect(Collectors.groupingBy(Employee::getDepartment));
        groupingByMth.entrySet().stream().limit(10).forEach(System.out::println);
        System.out.println("change value Type===");
        //2:change value Type
        groupingByMth=Employee.employeeList().stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(e->getEmpWIthNameAge(e),Collectors.toList())));
        //groupingByMth.entrySet().forEach(System.out::println);

        //3:

        groupingByMth=Employee.employeeList().stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(e->increasingSalaryByDept(e),Collectors.toList())));
        groupingByMth.entrySet().stream().limit(10).forEach(System.out::println);

    }

static Employee getEmpWIthNameAge(Employee emp){
      Employee employee=new Employee();
      employee.setName(emp.name);
      employee.age= emp.age;
      return employee;
}
static Employee increasingSalaryByDept(Employee emp){
    Employee employee=new Employee(emp);

if (employee.department.equalsIgnoreCase("Product Development"))
    {
     employee.salary=employee.salary+0.1*employee.salary;
    }

    return employee;
}

}
