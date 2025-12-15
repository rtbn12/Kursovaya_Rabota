public class GPU extends ComputerComponent{

    private int vramSize;           // Объем видеопамяти (ГБ)
    private String memoryType;      // Тип памяти (GDDR6, GDDR6X)
    private int cudaCores;          // Количество CUDA ядер
    private double baseFrequency;   // Базовая частота (МГц)
    private double boostFrequency;  // Турбо частота (МГц)
    private int memoryBusWidth;     // Ширина шины памяти (бит)
    private String coolingType;     // Тип охлаждения
    private int powerConnectors;    // Количество разъемов питания
    private String typePCIe;         // тип PCIe
    private String videoOutput;     // типы видеовыходов


    public GPU(String id, String brand, String model, int price,String interfaceType, int vramSize,
               String memoryType,int cudaCores,double baseFrequency,double boostFrequency,
               int memoryBusWidth,String coolingType,int powerConnectors,String typePCIe,String videoOutput,
               int powerConsumption, double voltage, String dimensions, int weight,
               String countryProduction, int productionDate, String category, String description, int warrantyMoths) {


        super(id, brand, model, price,  interfaceType, powerConsumption, voltage, dimensions, weight,
                countryProduction, productionDate,  category, description, warrantyMoths);


        this.vramSize = vramSize;
        this.memoryType = memoryType;
        this.cudaCores = cudaCores;
        this.baseFrequency = baseFrequency;
        this.boostFrequency = boostFrequency;
        this.memoryBusWidth = memoryBusWidth;
        this.coolingType = coolingType;
        this.powerConnectors = powerConnectors;
        this.typePCIe = typePCIe;
        this.videoOutput = videoOutput;

    }

    public int getVramSize() {
        return vramSize;
    }

    public void setVramSize(int vramSize) {
        this.vramSize = vramSize;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public int getCudaCores() {
        return cudaCores;
    }

    public void setCudaCores(int cudaCores) {
        this.cudaCores = cudaCores;
    }

    public double getBaseFrequency() {
        return baseFrequency;
    }

    public void setBaseFrequency(double baseFrequency) {
        this.baseFrequency = baseFrequency;
    }

    public double getBoostFrequency() {
        return boostFrequency;
    }

    public void setBoostFrequency(double boostFrequency) {
        this.boostFrequency = boostFrequency;
    }

    public int getMemoryBusWidth() {
        return memoryBusWidth;
    }

    public void setMemoryBusWidth(int memoryBusWidth) {
        this.memoryBusWidth = memoryBusWidth;
    }

    public String getCoolingType() {
        return coolingType;
    }

    public void setCoolingType(String coolingType) {
        this.coolingType = coolingType;
    }

    public int getPowerConnectors() {
        return powerConnectors;
    }

    public void setPowerConnectors(int powerConnectors) {
        this.powerConnectors = powerConnectors;
    }

    public String getTypePCIe() {
        return typePCIe;
    }

    public void setTypePCIe(String typePCIe) {
        this.typePCIe = typePCIe;
    }

    public String getVideoOutput() {
        return videoOutput;
    }

    public void setVideoOutput(String videoOutput) {
        this.videoOutput = videoOutput;
    }

    @Override
    public void getFullInfoForClient() {
        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice() + " рублей");
        System.out.println("Интерфейс подключения: " + getInterfaceType());
        System.out.println("Объем видеопамяти: " + getVramSize() + " ГБ " + getMemoryType());
        System.out.println("Количество вычислительных ядер: " + getCudaCores());
        System.out.println("Базовая частота: " + getBaseFrequency() + " МГц");
        System.out.println("Турбо частота: " + getBoostFrequency() + " МГц");
        System.out.println("Ширина шины памяти: " + getMemoryBusWidth() + " бит");
        System.out.println("Тип охлаждения: " + getCoolingType());
        System.out.println("Разъемы питания: " + getPowerConnectors() + "x 8-pin");
        System.out.println("Поддерживаемые видеовыходы: " + getVideoOutput());
        System.out.println("Версия PCIe: " + getTypePCIe());
        System.out.println("Потребляемая мощность: " + getPowerConsumption() + " ВТ");
        System.out.println("Рабочее напряжение: " + getVoltage() + " V");
        System.out.println("Габариты: " + getDimensions() + " мм");
        System.out.println("Вес: " + getWeight() + " г");
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating());
        System.out.println("Описание: " + getDescription());
    }
}
