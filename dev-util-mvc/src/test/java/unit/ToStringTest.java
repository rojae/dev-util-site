import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import site.devutil.MvcApplication;
import site.devutil.worker.JsonWorker;

import java.util.Arrays;
import java.util.List;

//@SpringBootTest(classes = MvcApplication.class)
public class ToStringTest {

    private JsonWorker jsonWorker = new JsonWorker();

//    public ToStringTest(JsonWorker jsonWorker) {
//        this.jsonWorker = jsonWorker;
//    }

    static class Person {
        private String name;
        private List<String> list;
        private Boolean bool;
        private Double dou;

        public Person(String name, List<String> list, Boolean bool, Double dou) {
            this.name = name;
            this.list = list;
            this.bool = bool;
            this.dou = dou;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", list=" + list +
                    ", bool=" + bool +
                    ", dou=" + dou +
                    '}';
        }
    }

    static class Persons {
        private String name;
        private List<Person> personList;

        public Persons(String name, List<Person> personList) {
            this.name = name;
            this.personList = personList;
        }

        @Override
        public String toString() {
            return "Persons{" +
                    "name='" + name + '\'' +
                    ", personList=" + personList +
                    '}';
        }
    }


    @Test
    public void test1(){
        Person p = new Person("name", Arrays.asList("item1", "item2", "item3"), false, 1.3);
        System.out.println(p.toString());
        String jsonStr = jsonWorker.toStringToJson("(name=name, list=[item1, item2, item3], bool=false, dou=1.3)");
        System.out.println(jsonStr);

        ////////
        System.out.println("----");
        ////////

        Persons ps = new Persons("name", Arrays.asList(p, p));
        System.out.println(ps.toString());
        String jsonStr2 = jsonWorker.toStringToJson("name=name, personList=[Person{name='name', list=[item1, item2, item3], bool=false, dou=1.3}, Person{name='name', list=[item1, item2, item3], bool=false, dou=1.3}]");
        System.out.println(jsonStr2);
    }


}
