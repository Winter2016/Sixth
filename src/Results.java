import java.io.Serializable;

/**
 * Created by Ксения on 4/1/2016.
 */
public class Results implements Serializable{
    private double sum;
    private double difference;
    private double product;
    private double quotient;

    public Results(double sum, double difference, double product, double quotient) {
        this.sum = sum;
        this.difference = difference;
        this.product = product;
        this.quotient = quotient;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }

    public double getProduct() {
        return product;
    }

    public void setProduct(double product) {
        this.product = product;
    }

    public double getQuotient() {
        return quotient;
    }

    public void setQuotient(double quotient) {
        this.quotient = quotient;
    }

    @Override
    public String toString() {
        return "Results{" + "sum = " + sum + ", difference = " + difference + ", product = " + product + ", quotient = " + quotient + '}';
    }
}
