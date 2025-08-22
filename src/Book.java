import java.util.ArrayList;

public class Book extends Material{
    private Person writer;
    private int numberOfPages;

    public Book(int id, String name, int release_year, int price, Category category, String type, Person writer, int numberOfPages){
        super(id, name, release_year, category,price, type);
        this.writer=writer;
        this.numberOfPages=numberOfPages;
    }

    public int getNumberOfPages(){
        return numberOfPages;
    }

    @Override
    public String toString() {
        return String.format(
                """
                ╔══════════════════════════╗
                ║      Kitap Bilgileri     ║
                ╚══════════════════════════╝
                Adı          : %s
                Yayın Yılı   : %d
                Fiyat        : %d ₺
                Kategori     : %s
                Tür          : %s
                Yazar        : %s %s
                Sayfa Sayısı : %d
                """,
                getName(),
                getReleaseYear(),
                getPrice(),
                getCategory().getCategoryName(),
                getType(),
                writer.getFirstName(),
                writer.getLastName(),
                getNumberOfPages()
        );
    }

    @Override
    public void showDetail() {
        System.out.println(this);
    }
}


