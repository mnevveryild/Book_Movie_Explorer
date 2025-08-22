import java.util.ArrayList;
import java.util.Arrays;
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
            System.out.println("Giriş Başarılı...");
        }
    }

    public void addMovie(Movie m1) {
        if (isLogin) {
            materials.add(m1);
            System.out.println("Film eklendi.");
        } else
            System.out.println("Film eklenemedi.Lütfen giriş yapınız.");
    }

    public void addBook(Book b1) {
        if (isLogin) {
            materials.add(b1);
            System.out.println("Kitap eklendi.");
        } else System.out.println("Kitap eklenemedi.Lütfen giriş yapınız.");
    }

    public void addMaterials(Material m2) {
        if (isLogin) {
            materials.add(m2);
            System.out.println("Materyal eklendi.");
        } else System.out.println("Materyal eklenemedi.Lütfen giriş yapınız.");
    }

    public void enYüksekOrtalama() {
        if (materials.isEmpty()) {
            System.out.println("Materyal yok");
            return;
        }
        Material yüksek = materials.get(0); //0 dan başlayarak nesneleri tarama
        for (Material m : materials) {
            if (m.getAvgScore() > yüksek.getAvgScore()) {
                yüksek = m;
            }
        }
        if (yüksek != null) {
            System.out.println("En yüksek ortalama skor: ");
            yüksek.showDetail();
        }

    }

    public void enDüşükOrtalama() {
        if (materials.isEmpty()) {
            System.out.println("Materyal yok");
            return;
        }
        Material düşük = null;
        for (Material m : materials) {
            if (m instanceof Movie) {
                if (düşük == null || m.getAvgScore() < düşük.getAvgScore()) {
                    düşük = m;
                }
            }
        }
        if (düşük != null) {
            System.out.println("En düşük ortalama skor: ");
            düşük.showDetail();
        }
    }

    public void enPahalı() {
        if (materials.isEmpty()) {
            System.out.println("Materyal  yok");
            return;
        }
        Material pahalı = materials.get(0); // ilk materyali başlangıç olarak al
        for (Material m : materials) {
            if (m.getPrice() > pahalı.getPrice()) {
                pahalı = m;
            }
        }

        System.out.println("En pahalı materyal:");
        pahalı.showDetail();
    }



    public void AktörListele(int actorId) {
        boolean bulundu = false;
        Person aktör = null;

        for (Material m : materials) {
            if (m instanceof Movie movie) {
                for (Person p : movie.getActors()) {
                    if (p.getId() == actorId) {
                        aktör = p;
                        break;
                    }
                }
            }
            if (aktör != null) break;
        }

        if (aktör == null) {
            System.out.println("Bu aktör henüz hiçbir filmde oynamamış.");
            return;
        }

        System.out.println(aktör.getFirstName() + " " + aktör.getLastName() + "’in oynadığı filmler:");

        for (Material m : materials) {
            if (m instanceof Movie movie) {
                for (Person p : movie.getActors()) {
                    if (p.getId() == actorId) {
                        System.out.println(" - " + movie.getName() + " (" + movie.getReleaseYear() + ")");
                        bulundu = true;
                    }
                }
            }
        }

    }


}