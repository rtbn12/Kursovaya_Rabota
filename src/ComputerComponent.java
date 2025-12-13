public class ComputerComponent extends Product{

    private String interfaceType;
    private int powerConsumption;
    private String dimensions;
    private double voltage;
    private int weight;


    public ComputerComponent(String id, String brand, String model, int price, String interfaceType, int powerConsumption,
                             double voltage,String dimensions,int weight,String countryProduction,
                             int productionDate, String category, String description, int warrantyMoths) {

        super(id, brand, model, countryProduction, productionDate, price, category, description, warrantyMoths);


        this.interfaceType = interfaceType;
        this.powerConsumption = powerConsumption;
        this.voltage = voltage;
        this.dimensions = dimensions;
        this.weight = weight;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public String getDimensions() {
        return dimensions;
    }

    public double getVoltage() {
        return voltage;
    }

    public int getWeight() {
        return weight;
    }


    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public void getFullInfoForClient() {

        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice());
        System.out.println("Интерфейс подключения: " + getInterfaceType());
        System.out.println("Потребляемая мощность: " + getPowerConsumption());
        System.out.println("Рабочее напряжение: " + getVoltage() + " V");
        System.out.println("Габариты: " + getDimensions() + " мм");
        System.out.println("Вес: " + getWeight() + " г");
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating());
        System.out.println("Описание: " + getDescription());

    }

    @Override
    public void getFullInfoForSeller() {

        System.out.println("\nДата добавления: " + getAddedDate());

    }
}
