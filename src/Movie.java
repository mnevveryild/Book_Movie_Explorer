import java.util.ArrayList;
public class Movie extends Material{
    private ArrayList<Person> actors;
    private Person director;

    public Movie(int id, String name, int release_year,  Category category,int price, String type, ArrayList<Person> actors, Person director){
        super(id,name,release_year, category, price,type);
        this.actors=actors;
        this.director=director;
    }
    public ArrayList<Person> getActors(){

        return actors;
    }

    // append String ya da StringBuilder ile metinleri birleştiriir.Diğer türlü + ile birleştirmek hata verdi.
    //Döngü vs. için daha kullnışlı ve mantıklı
    public String toString() {
        StringBuilder actorsList = new StringBuilder();
        for (Person p : actors) {
            actorsList.append("   - ").append(p.getFirstName()).append(" ").append(p.getLastName()).append("\n");
        }

        return String.format(
                """
                ╔══════════════════════════╗
                ║      Movie Details       ║
                ╚══════════════════════════╝
                Movie Name     : %s
                Release Year   : %d
                Price          : %d ₺
                Category       : %s
                Type           : %s
                Director       : %s %s
                Actors         :
                %s
                """,
                getName(),
                getReleaseYear(),
                getPrice(),
                getCategory().getCategoryName(),
                getType(),
                director.getFirstName(),
                director.getLastName(),
                actorsList.toString()
        );
    }
    @Override
    public void showDetail() {

        System.out.println(this);
    }
}
