import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionsExamples {
    CollectionsExamples(){

    }
    public static void main(String[] args) {

        System.out.println("Crie uma lista e adicione as sete notas: ");
        List<Double> notas = new ArrayList();
        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5d);
        notas.add(7d);
        notas.add(0d);
        notas.add(3.6);

        System.out.println(notas.toString());

        System.out.println("Exiba a posição da nota 5.0: " + notas.indexOf(5.0));

        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
        notas.add(4, 8.0);
        System.out.println(notas);

        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
        notas.set(notas.indexOf(5.0), 6.0);
        System.out.println(notas);

        System.out.println("Confira se a nota 5.0 está na lista: " + notas.contains(5.0));

        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));
        System.out.println(notas.toString());
        //como não existe um método nativo é utilizada a classe "Collections"
        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));
        //
        Iterator<Double> iterator = notas.iterator();

        Double soma = 0d;

        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }

        System.out.println("Exiba a soma dos valores: " + soma);

        //size imprime a quantidade de elementos da lista
        System.out.println("Exiba a média das notas: " + soma / (double)notas.size());

        System.out.println("Remova a nota 0: ");
        notas.remove(0.0);
        System.out.println(notas);

        System.out.println("Remova a nota da posição 0");
        notas.remove(0);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();

        while(iterator1.hasNext()) {
            Double next = (Double)iterator1.next();
            if (next < 7.0) {
                iterator1.remove();
            }
        }

        /*Apagando a lista inteira
        System.out.println("Apague toda a lista");
        notas.clear();
        System.out.println(notas);*/

        System.out.println(notas);
        System.out.println("Confira se a lista está vazia: " + notas.isEmpty());
    }
}