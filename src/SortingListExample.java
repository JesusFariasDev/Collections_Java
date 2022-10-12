import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingListExample {
    public static void main(String[] args) {

        List<Cat> myCats = new ArrayList<>(){{
            add(new Cat("John", 5, "orange"));
            add(new Cat("Simba", 7, "yellow"));
            add(new Cat("John", 2, "black"));
        }};
        System.out.println("Gatos pela ordem de inserção");
        System.out.println(myCats);

        System.out.println("Gatos em ordem aleatória");
        //shuffle altera a ordem dos itens
        Collections.shuffle(myCats);
        System.out.println(myCats);

        System.out.println("Ordem natural (nomes)");
        //método sort irá ordenar os itens de acordo com o resultado do metodo (COMPARABLE)
        Collections.sort(myCats);
        System.out.println(myCats);

        //método sort irá ordenar os itens de acordo com o resultado do metodo (COMPARATOR)
        System.out.println("Ordem Idade");
        Collections.sort(myCats, new ComparatorAge());
        /*Método alternativo:
        myCats.sort(new ComparatorAge());*/
        System.out.println(myCats);


        System.out.println("Ordem Cor");
        Collections.sort(myCats, new ComparatorColor());
        System.out.println(myCats);




    }
}
//implementando a interface comparable e configurado pelo overrode compareTo
class Cat implements Comparable<Cat> {
    private String name;
    private Integer age;
    private String color;

    public Cat(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
    //Utilizados apenas getters por ser uma private class
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
// ******** MÉTODO COM STRING *******
    @Override
    public int compareTo(Cat cat) {
        // RETORNARÁ 1 PARA MAIOR, 0 PARA IGUAL E -1 PARA MENOR
        return this.getName() .compareToIgnoreCase(cat.getName());
    }
}
// ******** MÉTODO COM INTEGER *******
class ComparatorAge implements Comparator<Cat>{
    @Override
    public int compare(Cat c1, Cat c2){
        return Integer.compare(c1.getAge(), c2.getAge());
    }
}

class ComparatorColor implements Comparator<Cat> {
    @Override
    // RETORNARÁ 1 PARA MAIOR, 0 PARA IGUAL E -1 PARA MENOR
    public int compare(Cat c1, Cat c2){
        return c1.getColor().compareToIgnoreCase(c2.getColor());
    }
}

class ComparatorNameAgeColor implements Comparator<Cat> {
    @Override
    public int compare(Cat c1, Cat c2){

        int name = c1.getName().compareToIgnoreCase(c2.getName());
        // SE OS NOMES FOREM IGUAIS (0) VAI PARA A PRÓXIMA
        if(name != 0) return name;

        int color = c1.getColor().compareToIgnoreCase(c2.getColor());
        // SE AS CORES FOREM IGUAIS (0) VAI PARA A PRÓXIMA
        if(color != 0) return color;

        return Integer.compare(c1.getAge(), c2.getAge());
    }
}
