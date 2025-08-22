// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,

// then press Enter. You can now see whitespace characters in your c
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

                //oyuncular
                Person p1= new Person(1,"Tom","Hanks",50);
                Person p2= new Person(2,"Robin","Wright",52);
                Person p3= new Person(3,"Ryan","Gosling",40);
                Person p4= new Person(4,"Margot","Robbie",32);
                Person p5= new Person(5,"Will","Smith",53);
                Person p6= new Person(6,"Cara","Delevingne",28);
                Person p7= new Person(7,"Münevver","Yıldırım",23);

                //yazar ya da yönetmen
                Person p1_1 = new Person(3,"Burak","Demir",40);
                Person p1_2 = new Person(4,"Zeynep","Koç",19);

                //kategoriler
                Category komedi = new Category(1,"COM","Komedi");
                Category tarih = new Category(2,"TRH","Tarih");
                Category romantik = new Category(3,"ASK","Romantik");
                Category fantastik = new Category(4,"FAN","Fantastik");
                Category dram = new Category(5,"DRM","Dram");

                //filmler
                ArrayList<Person> actors1= new ArrayList<>();
                actors1.add(p1);
                actors1.add(p2);
                Movie film1 = new Movie(1,"Forrest Gump",1994,komedi,150,"movie",actors1,p1_1);
                film1.addScore(9);
                film1.addScore(10);

                Movie film2 = new Movie(2,"Yeşil Yol",1999,dram,220,"movie",actors1,p1_1);
                film2.addScore(9);
                film2.addScore(8);

                ArrayList<Person> actors2 = new ArrayList<>();
                actors2.add(p3);
                Movie film3 = new Movie(3,"Not Defteri",2004,romantik,180,"movie",actors2,p1_1);
                film3.addScore(10);
                film3.addScore(9);

                ArrayList<Person> actors3 = new ArrayList<>();
                actors3.add(p4);
                actors3.add(p3);
                Movie film4 = new Movie(4,"Barbie",2023,komedi,180,"movie",actors3,p1_1);
                film3.addScore(8);
                film3.addScore(5);

                ArrayList<Person> actors4 = new ArrayList<>();
                actors4.add(p4);
                actors4.add(p5);
                actors4.add(p6);
                Movie film5 = new Movie(5,"Suicide Squat",2020,fantastik,210,"movie",actors4,p1_1);
                film3.addScore(7);
                film3.addScore(6);


                // kitaplar
                Book kitap1 = new Book(1,"Sarı Yüz",2025,275,fantastik,"book",p1_2,304);
                kitap1.addScore(10);
                kitap1.addScore(9);

                Book kitap2 = new Book(2,"İmparatorluklar Tarihi",1995,600,tarih,"book",p1_2,520);
                kitap2.addScore(7);
                kitap2.addScore(8);

                Book kitap3 = new Book(3,"Kalbin Sesi",2010,320,romantik,"book",p1_2,250);
                kitap3.addScore(6);
                kitap3.addScore(5);

                // netflixe giriş yapacak olan kullanıcı yani login yapma koşulu olan
                User user = new User(1, "Münevver", "Yıldırım", 23, "muni", "1234");

                Scanner sc = new Scanner(System.in);
                System.out.print("Kullanıcı adı: ");
                String uName = sc.nextLine();
                System.out.print("Şifre: ");
                String pass = sc.nextLine();

                // netflixte nesne oluştur
                ArrayList<Material> materials = new ArrayList<>();
                Netflix n1 = new Netflix(materials);

                //kullanıcıyı login et
                n1.login(user);

                if (uName.equals(user.getUserName()) && pass.equals(user.getPassword())) {

                        System.out.println("\n--- Netflix Kütüphanesi ---");

                        n1.addMovie(film1);
                        n1.addMovie(film2);
                        n1.addMovie(film3);
                        n1.addMovie(film4);
                        n1.addMovie(film5);


                        n1.addBook(kitap1);
                        n1.addBook(kitap2);
                        n1.addBook(kitap3);


                        n1.enYüksekOrtalama();
                        n1.enDüşükOrtalama();
                        n1.enPahalı();
                        n1.AktörListele(1);
                        n1.AktörListele(2);
                        n1.AktörListele(3);
                        n1.AktörListele(4);
                        n1.AktörListele(5);
                        n1.AktörListele(6);
                        n1.AktörListele(7);




                } else {
                        System.out.println("Giriş Başarısız...");
                }

                sc.close(); //sistem kapat


        }
}
