package chapter01;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public String title;
    public int priceCode;

    public Movie(String title, int priceCode){
        this.title = title;
        this.priceCode = priceCode;
    }
    public int getPriceCode(){
        return this.priceCode;
    }
    public void setPriceCode(int priceCode){
        this.priceCode = priceCode;
    }
    public String getTitle(){
        return this.title;
    }

}
