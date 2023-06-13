package job_hacker.tasks.models;

public class Stock {
    String symbol;
    String name;
    double  previousClosingPrice;
    double  currentPrice;

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
        previousClosingPrice = 0;
        currentPrice = 0;
    }

    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }
    public void setCurrentPrice(double currentPrice) {
        //this.previousClosingPrice = this.currentPrice;
        this.currentPrice = currentPrice;
    }
    public double getChangePercent(){
        double difference = currentPrice - previousClosingPrice;
        return (previousClosingPrice == 0 ? 1 : difference / previousClosingPrice) * 100;
    }
}
