package siit.homework02;

public class SalesRepresentatives {

    private final String name;
    private int numberOfSales;
    private double quota;
    private double salesValue;

    /**
     * This is a constructor of objects. In this case we create objects that will require three different
     * types of parameters to be entered: name, number of sales and quota.
     * We also set the value of sales value in dependency to the number of sales and quota values.
     * @param name is a string parameter which describes the name of the sales representative.
     * @param numberOfSales is the total number of sales he closed in a month.
     * @param quota is the average value of sales he closed in a month.
     */
    public SalesRepresentatives(String name, int numberOfSales, double quota) {
        this.name = name;
        this.numberOfSales = numberOfSales;
        this.quota = quota;
        this.salesValue = this.numberOfSales * this.quota;
    }

    /**
     * This code returns the name and the sales value of each object, instead of the object hash.
     * @return returns the name and the sales value of the object.
     */
    @Override
    public String toString() {
        return this.name + " (" + this.salesValue + ")";
    }

    /**
     * This code gets only the sales values from the created objects.
     * @return returns the sales values from the objects.
     */
    public double getSalesValue() {
        return salesValue;
    }
}
