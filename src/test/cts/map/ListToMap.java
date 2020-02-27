package test.cts.map;

import java.util.*;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {
        List<ListEmp>
                list = Arrays.asList(new ListEmp("sonu", "pune", "23"), new ListEmp("joya", "jaipur", "90"), new ListEmp("alka", "pune", "98"), new ListEmp("annu", "jaipur", "26"));

        List listEmp = new ArrayList(list.stream().collect(Collectors.groupingBy(ListEmp::getCity)).values());

        Map<String, List<ListEmp>> cityMap = list.stream()
                .collect(Collectors.groupingBy(ListEmp::getCity, Collectors.toList()));

        System.out.println(listEmp);
        System.out.println("*********");
        System.out.println(cityMap);
Map<String,String> hashMap=new HashMap<>();
hashMap.put("sonu","one");
hashMap.put("Raj","two");
//List<String>list3=(List<String>)hashMap.values();
  //      System.out.println(list3);
        boolean bool=hashMap.containsValue("two");
        System.out.println("booleanFlag-->"+bool);


  /*

  new ArrayList<>(
    all.stream()
       .collect(Collectors.groupingBy(Prop::getRegion))
       .values());
   */

    }
}

class ListEmp {
    private String name;
    private String city;
    private String age;

    public ListEmp(String name, String city, String age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ListEmp{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}