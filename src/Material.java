import java.util.ArrayList;

public abstract class Material {
    private int id;
    private String name;
    private ArrayList<Integer> scores;
    private Category category;
    private String type; // movie ya da book
    private int release_year;
    private int price;

    public Material(int id, String name, int release_year, Category category, int price, String type) {
        this.id = id;
        this.name = name;
        this.release_year = release_year;
        this.category = category;
        this.price = price;
        this.type = type;
        this.scores = new ArrayList<>();
    }

    public void addScore(int score) {

        this.scores.add(score);
    }

    public Double getAvgScore() {
        if (scores.isEmpty()) return (double) 0;
        int total = 0;
        for (int s : scores) {
            total += s;
        }
        return (double) total / scores.size();
    }

    public abstract void showDetail();


    public String getName() {
        return name;
    }

    public int getReleaseYear() {

        return release_year;
    }

    public Category getCategory() {

        return category;
    }

    public int getPrice() {

        return price;
    }

    public String getType() {

        return type;
    }

}
