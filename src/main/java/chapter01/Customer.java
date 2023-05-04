package chapter01;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name){
        this.name = name;
    }
    public void addRental(Rental rental){
        this.rentals.addElement(rental);
    }
    public String getName(){
        return this.name;
    }

    public String statement(){
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String result = getName() + " 고객님의 대여 기록\n";

        while(rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            //비디오 종류별 대여료 계산
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }

            //적립 포인트 1포인트 증가
            frequentRenterPoints++;

            //최신물 이틀 이상 대여시 보너스 포인트 지급
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            //대여하는 비디오 정보 / 대여료 출력
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";

            //현재까지 누적된 총 대여료
            totalAmount += thisAmount;
        }
        //푸터 행 추가
        result += "누적 대여료 : "+String.valueOf(totalAmount) + "\n";
        result += "누적 포인트 : "+String.valueOf(frequentRenterPoints);
        return result;
    }
}
