public class RAM extends ComputerComponent{

    private int capacity;           // Объем одного модуля (ГБ)
    private int frequency;          // Частота (МГц)
    private int latency;            // Тайминги (CL16, CL18)
    private String memoryType;      // Тип памяти (DDR4, DDR5)
    private int modulesCount;       // Количество модулей в комплекте
    private boolean hasRGB;         // RGB подсветка
    private boolean hasHeatSpreader; // Радиатор охлаждения


    public RAM(String id, String brand, String model, int price, String interfaceType,int capacity,
               int frequency,int latency, String memoryType, int modulesCount,boolean hasRGB,
               boolean hasHeatSpreader,int powerConsumption, double voltage, String dimensions,
               int weight, String countryProduction, int productionDate, String category,
               String description, int warrantyMoths) {


        super(id, brand, model, price, interfaceType, powerConsumption, voltage,
                dimensions, weight, countryProduction, productionDate,
                 category, description, warrantyMoths);

        this.capacity = capacity;
        this.frequency = frequency;
        this.latency = latency;
        this.memoryType = memoryType;
        this.modulesCount = modulesCount;
        this.hasRGB = hasRGB;
        this.hasHeatSpreader = hasHeatSpreader;

    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getLatency() {
        return latency;
    }

    public void setLatency(int latency) {
        this.latency = latency;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public int getModulesCount() {
        return modulesCount;
    }

    public void setModulesCount(int modulesCount) {
        this.modulesCount = modulesCount;
    }

    public boolean isHasRGB() {
        return hasRGB;
    }

    public void setHasRGB(boolean hasRGB) {
        this.hasRGB = hasRGB;
    }

    public boolean isHasHeatSpreader() {
        return hasHeatSpreader;
    }

    public void setHasHeatSpreader(boolean hasHeatSpreader) {
        this.hasHeatSpreader = hasHeatSpreader;
    }

    @Override
    public void getFullInfoForClient() {

        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice() + " рублей");
        System.out.println("Интерфейс подключения: " + getInterfaceType());
        System.out.println("Объем одного модуля: " + getCapacity() + " ГБ");
        System.out.println("Количество модулей: " + getModulesCount());
        System.out.println("Общий объем комплекта: " + (getCapacity()*getModulesCount()) + " ГБ");
        System.out.println("Частота: " + getFrequency() + " МГц");
        System.out.println("Тайминги: CL" + getLatency());
        System.out.println("Тип памяти: " + getMemoryType());
        System.out.println("RGB подсветка: " + (hasRGB ? "Да" : "Нет"));
        System.out.println("Радиатор охлаждения: " + (hasHeatSpreader ? "Да" : "Нет"));
        System.out.println("Потребляемая мощность: " + getPowerConsumption() + " ВТ");
        System.out.println("Рабочее напряжение: " + getVoltage() + " V");
        System.out.println("Габариты: " + getDimensions() + " мм");
        System.out.println("Вес: " + getWeight() + " г");
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating() + "из 5!");
        System.out.println("Количество на складе: " + getQuantityProduct() + " шт.");
        System.out.println("Описание: " + getDescription());
    }
}
