import java.util.*;

public class SetExamples {
    public static void main(String[] args) {

// MÉTODO HASHSET: Imprime de forma aleatória a lista e não imprime valores duplicados
        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> grades = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(grades.toString());

        System.out.println("Confira se a nota 5.0 está no conjunto: " + grades.contains(5d));

        System.out.println("Exiba a menor nota: " + Collections.min(grades));

        System.out.println("Exiba a maior nota: " + Collections.max(grades));

// EXIBIR A SOMA ATRAVÉS DO ITERATOR
        Iterator<Double> iterator = grades.iterator();
        Double sum = 0d;
        // hasNext está verificando se há um próximo elemento para fazer iteração
        while (iterator.hasNext()) {
            Double next = iterator.next();
            sum += next;
        }
        System.out.println("Exiba a soma dos valores: " + sum);

        System.out.println("Exiba a média das notas: " + (sum/ grades.size()));

        System.out.println("Removendo a nota 0");
        grades.remove(0d);
        System.out.println(grades);

        System.out.println("Removendo as notas menores que 7");
        Iterator<Double> iterator1 = grades.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }
        System.out.println(grades);

// UTILIZANDO O LINKEDHASHSET PARA IMPRIMIR A LISTA EM ORDEM DE INSERÇÃO
        System.out.println("Exiba todas as notas na ordem em que foram informadas");
        Set<Double> grades2 = new LinkedHashSet<>();
        grades2.add(7d);
        grades2.add(8.5);
        grades2.add(9.3);
        grades2.add(5d);
        grades2.add(7d);
        grades2.add(0d);
        grades2.add(3.6);

// UTILIZANDO O TREESET PARA IMPRIMIR A LISTA EM ORDEM NUMÉRICA
        System.out.println("Exiba todas as notas em ordem crescente");
        Set<Double> grades3 = new TreeSet<>(grades2);
        System.out.println(grades3);

        System.out.println("Apagando o 1 conjunto");
        grades.clear();
        System.out.println(grades);

    }
}
