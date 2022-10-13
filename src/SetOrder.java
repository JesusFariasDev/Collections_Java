
import java.util.*;

public class SetOrder {
    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};
        for (Serie serie: minhasSeries) System.out.println(serie.getName() + " - "
                + serie.getGenre() + " - " + serie.getTempoEpisodio());

        System.out.println("--\tOrdem inserção\t--");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>() {{
            add(new Serie("the boys", "ação", 50));
            add(new Serie("dark", "drama", 60));
            add(new Serie("twd", "ação", 55));
        }};
        for (Serie serie: minhasSeries1) System.out.println(serie.getName() + " - "
                + serie.getGenre() + " - " + serie.getTempoEpisodio());

        System.out.println("--\tOrdem natural (TempoEpisodio)\t--");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie serie: minhasSeries2) System.out.println(serie.getName() + " - "
                + serie.getGenre() + " - " + serie.getTempoEpisodio());

        System.out.println("--\tOrdem Nome/Gênero/TempoEpisodio\t--");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNameGenreTempoEpisodio());
        minhasSeries3.addAll(minhasSeries);
        for (Serie serie: minhasSeries3) System.out.println(serie.getName() + " - "
                + serie.getGenre() + " - " + serie.getTempoEpisodio());

//Pra você
/*        System.out.println("--\tOrdem gênero\t--");
          System.out.println("--\tOrdem Tempo Episódio\t--");
 */

    }
}

class Serie implements Comparable<Serie>{
    private String name;
    private String genre;
    private Integer tempoEpisodio;

    public Serie(String name, String genre, Integer tempoEpisodio) {
        this.name = name;
        this.genre = genre;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }
// ***** Importante sobreescrever a classe quando utilizarmos implementações que em seus nomes tem "hash"
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return name.equals(serie.name) && genre.equals(serie.genre) && tempoEpisodio.equals(serie.tempoEpisodio);
    }
// ***** Importante sobreescrever a classe quando utilizarmos implementações que em seus nomes tem "hash"
    @Override
    public int hashCode() {
        return Objects.hash(name, genre, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        if (tempoEpisodio != 0) return tempoEpisodio;

        return this.getGenre().compareTo(serie.getGenre());
    }
}

class ComparatorNameGenreTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int name = s1.getName().compareTo(s2.getName());
        if (name != 0) return name;

        int genre = s1.getGenre().compareTo(s2.getGenre());
        if (genre != 0) return genre;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}