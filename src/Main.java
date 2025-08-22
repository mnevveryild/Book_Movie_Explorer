// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,

// then press Enter. You can now see whitespace characters in your c
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
        public static void main(String[] args) {

                // oyuncular
                Person p1 = new Person(1, "Tom", "Hanks", 50);
                Person p2 = new Person(2, "Robin", "Wright", 52);
                Person p3 = new Person(3, "Ryan", "Gosling", 40);
                Person p4 = new Person(4, "Margot", "Robbie", 32);
                Person p5 = new Person(5, "Will", "Smith", 53);
                Person p6 = new Person(6, "Cara", "Delevingne", 28);
                Person p7 = new Person(7, "Munevver", "Yildirim", 23);

                // yazar ve yönetmen
                Person p1_1 = new Person(3, "Burak", "Demir", 40);
                Person p1_2 = new Person(4, "Zeynep", "Koc", 19);

                // kategori
                Category comedy = new Category(1, "COM", "Comedy");
                Category history = new Category(2, "HIS", "History");
                Category romance = new Category(3, "ROM", "Romance");
                Category fantasy = new Category(4, "FAN", "Fantasy");
                Category drama = new Category(5, "DRM", "Drama");

                // filmler
                ArrayList<Person> actors1 = new ArrayList<>();
                actors1.add(p1);
                actors1.add(p2);
                Movie movie1 = new Movie(1, "Forrest Gump", 1994, comedy, 150, "movie", actors1, p1_1);
                movie1.addScore(9);
                movie1.addScore(10);

                Movie movie2 = new Movie(2, "The Green Mile", 1999, drama, 220, "movie", actors1, p1_1);
                movie2.addScore(9);
                movie2.addScore(8);

                ArrayList<Person> actors2 = new ArrayList<>();
                actors2.add(p3);
                Movie movie3 = new Movie(3, "The Notebook", 2004, romance, 180, "movie", actors2, p1_1);
                movie3.addScore(10);
                movie3.addScore(9);

                ArrayList<Person> actors3 = new ArrayList<>();
                actors3.add(p4);
                actors3.add(p3);
                Movie movie4 = new Movie(4, "Barbie", 2023, comedy, 180, "movie", actors3, p1_1);
                movie4.addScore(8);
                movie4.addScore(5);

                ArrayList<Person> actors4 = new ArrayList<>();
                actors4.add(p4);
                actors4.add(p5);
                actors4.add(p6);
                Movie movie5 = new Movie(5, "Suicide Squad", 2020, fantasy, 210, "movie", actors4, p1_1);
                movie5.addScore(7);
                movie5.addScore(6);

                // kitaplar
                Book book1 = new Book(1, "Yellow Face", 2025, 275, fantasy, "book", p1_2, 304);
                book1.addScore(10);
                book1.addScore(9);

                Book book2 = new Book(2, "History of Empires", 1995, 600, history, "book", p1_2, 520);
                book2.addScore(7);
                book2.addScore(8);

                Book book3 = new Book(3, "Voice of the Heart", 2010, 320, romance, "book", p1_2, 250);
                book3.addScore(6);
                book3.addScore(5);

                // giriş yapıcak kullanıcı
                User user = new User(1, "Munevver", "Yildirim", 23, "muni", "1234");

                Scanner sc = new Scanner(System.in);
                System.out.print("Username: ");
                String uName = sc.nextLine();
                System.out.print("Password: ");
                String pass = sc.nextLine();

                // netflix nesne oluştur
                ArrayList<Material> materials = new ArrayList<>();
                Netflix netflix = new Netflix(materials);


                netflix.login(user);

                if (uName.equals(user.getUserName()) && pass.equals(user.getPassword())) {

                        System.out.println("\n----- Netflix Library -----");

                        netflix.addMovie(movie1);
                        netflix.addMovie(movie2);
                        netflix.addMovie(movie3);
                        netflix.addMovie(movie4);
                        netflix.addMovie(movie5);

                        netflix.addBook(book1);
                        netflix.addBook(book2);
                        netflix.addBook(book3);

                        netflix.highestAverage();
                        netflix.lowestAverage();
                        netflix.mostExpensive();
                        netflix.listActorMovies(1);
                        netflix.listActorMovies(2);
                        netflix.listActorMovies(3);
                        netflix.listActorMovies(4);
                        netflix.listActorMovies(5);
                        netflix.listActorMovies(6);
                        netflix.listActorMovies(7);

                } else {
                        System.out.println("Login failed...");
                }

                sc.close();
        }
}


