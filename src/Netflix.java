import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Netflix {
    private ArrayList<Material> materials; //film ve kitapları saklayacak olan boş liste
    private User credential;
    private boolean isLogin = false; //daha giriş yapılmadı

    public Netflix(ArrayList<Material> materials) {
        this.materials = materials;
        this.isLogin = false;  // giriş yapılamadan materyal eklenemez
    }

    public void login(User user) {
        if (user.getUserName().equals("muni") && user.getPassword().equals("1234")) {
            this.credential = user; // giriş yapıcak olan kullanıcıyı atadık
            this.isLogin = true;
            System.out.println("Login successful ...");
        }
    }

    public void addMovie(Movie m1) {
        if (isLogin) {
            materials.add(m1);
            System.out.println("Movie added.");
        } else
            System.out.println("Movie could not be added. Please log in.");
    }

    public void addBook(Book b1) {
        if (isLogin) {
            materials.add(b1);
            System.out.println("Book added.");
        } else System.out.println("Book could not be added. Please log in.");
    }

    public void addMaterials(Material m2) {
        if (isLogin) {
            materials.add(m2);
            System.out.println("Material added.");
        } else System.out.println("Material could not be added. Please log in.");
    }

    public void highestAverage() {
        if (materials.isEmpty()) {
            System.out.println("No materials.");
            return;
        }
        //foreach sadece bir listeyi dolaşmaya yarar foreach ile de yapabiliriz
        //ama Stream API collections üzerinde filtreleme, dönüştürme, sıralama, toplama gibi işlemleri basit ve okunabilir şekilde yapmamızı sağlar.

        //materials listini stream çevirdik.
        Optional<Material> highest = materials.stream().max(Comparator.comparingDouble(Material::getAvgScore));
        //en büyük ortalama değeri sahip olanı max ile buldu

        if (highest.isPresent()) {
            System.out.println("Highest average score:");
            highest.get().showDetail();
        } else {
            System.out.println("No materials available.");
        }

    }

    public void lowestAverage() {
        if (materials.isEmpty()) {
            System.out.println("No materials. ");
            return;
        }
        Optional<Material> lowest =materials.stream().min((Comparator.comparingDouble(Material::getAvgScore)));
            if (lowest.isPresent()) {
                System.out.println("Lowest average score: ");
                lowest.get().showDetail();

            }else{
                System.out.println("No materials.");
            }



    }

    public void mostExpensive() {
        Optional<Material> expensive = materials.stream()
                .max(Comparator.comparingDouble(Material::getPrice));
        // en büyük price karşılaştırma ile buldu
        if (expensive.isPresent()) {
            System.out.println("Most expensive material:");
            expensive.get().showDetail();
        } else {
            System.out.println("No materials available.");
        }
    }



    public void listActorMovies(int actorId) {
        // önce actor nesnesini bul
        Optional<Person> actor = materials.stream()
                .filter(m -> m instanceof Movie) // sadece movie olanları sçemek için kullandık
                .map(m -> (Movie) m)
                .flatMap(movie -> movie.getActors().stream()) // her aktör tek stream yani tek liste yapıyoruz
                .filter(p -> p.getId() == actorId)  // id ile eşleşen dönüyor
                .findFirst();

        if (actor.isEmpty()) {
            System.out.println("This actor has not appeared in any movies yet.");
            return;
        }

        Person act = actor.get();
        System.out.println(act.getFirstName() + " " + act.getLastName() + "'s movies:");

        // bu aktörün oynadığı tüm filmleri listeleme yapıp yazdırıyoruz
        materials.stream()
                .filter(m -> m instanceof Movie)
                .map(m -> (Movie) m)
                .filter(movie -> movie.getActors().stream().anyMatch(p -> p.getId() == actorId))
                .forEach(movie -> System.out.println(" - " + movie.getName() + " (" + movie.getReleaseYear() + ")"));

    }

    }
