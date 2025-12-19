public class PowerSupply extends ComputerComponent{


    private String efficiency;      // Сертификат эффективности (80+ Bronze, Gold, Platinum)
    private String modularity;      // Модульность (Full, Semi, Non)
    private int sataConnectors;     // Количество SATA разъемов
    private int pcieConnectors;     // Количество PCI-E разъемов
    private int cpuConnectors;      // Количество CPU разъемов (4+4 pin, 8 pin)
    private String fanSize;         // Размер вентилятора (мм)
    private String protections;     // Защиты (OCP, OVP, UVP, OPP, SCP)


    public PowerSupply(String id, String brand, String model, int price,String interfaceType,
                       int powerConsumption, double voltage,String efficiency,String modularity,
                       int sataConnectors,int pcieConnectors,int cpuConnectors,String fanSize,
                       String protections, String dimensions, int weight,
                       String countryProduction, int productionDate,String category,
                       String description, int warrantyMoths) {


        super(id, brand, model, price,  interfaceType, powerConsumption, voltage, dimensions,
                weight, countryProduction, productionDate, category, description, warrantyMoths);


        this.efficiency = efficiency;
        this.modularity = modularity;
        this.sataConnectors = sataConnectors;
        this.pcieConnectors = pcieConnectors;
        this.cpuConnectors = cpuConnectors;
        this.fanSize = fanSize;
        this.protections = protections;



    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getModularity() {
        return modularity;
    }

    public void setModularity(String modularity) {
        this.modularity = modularity;
    }

    public int getSataConnectors() {
        return sataConnectors;
    }

    public void setSataConnectors(int sataConnectors) {
        this.sataConnectors = sataConnectors;
    }

    public int getPcieConnectors() {
        return pcieConnectors;
    }

    public void setPcieConnectors(int pcieConnectors) {
        this.pcieConnectors = pcieConnectors;
    }

    public int getCpuConnectors() {
        return cpuConnectors;
    }

    public void setCpuConnectors(int cpuConnectors) {
        this.cpuConnectors = cpuConnectors;
    }

    public String getFanSize() {
        return fanSize;
    }

    public void setFanSize(String fanSize) {
        this.fanSize = fanSize;
    }

    public String getProtections() {
        return protections;
    }

    public void setProtections(String protections) {
        this.protections = protections;

    }

    @Override
    public void getFullInfoForClient() {

        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice() + " рублей");
        System.out.println("Потребляемая мощность: " + getPowerConsumption() + " ВТ");
        System.out.println("Рабочее напряжение: " + getVoltage() + " V");
        System.out.println("Сертификат эффективности: " + getEfficiency());
        System.out.println("Модульность: " + getModularity());
        System.out.println("Разъемы SATA: " + getSataConnectors());
        System.out.println("Разъемы PCI-E: " + getPcieConnectors() + " (6+2 pin)");
        System.out.println("Разъемы CPU: " + getCpuConnectors() + " (4+4 pin)");
        System.out.println("Вентилятор: " + getFanSize() + " мм " );
        System.out.println("Защиты: " + getProtections());
        System.out.println("Габариты: " + getDimensions() + " мм");
        System.out.println("Вес: " + getWeight() + " г");
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating());
        System.out.println("Описание: " + getDescription());

    }
}
