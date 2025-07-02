package weather;

/**
 *
 * @author isaac
 */
public class WeatherData {
    private String product;
    private String init;
    private WeatherDataseries[] dataseries;

    public String getProduct() { return product; }
    public void setProduct(String value) { this.product = value; }

    public String getInit() { return init; }
    public void setInit(String value) { this.init = value; }

    public WeatherDataseries[] getDataseries() { return dataseries; }
    public void setDataseries(WeatherDataseries[] value) { this.dataseries = value; }
}
