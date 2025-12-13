public class CPU extends ComputerComponent{

    private String socket;          // AM4, LGA1700, AM5
    private int coreCount;          // Количество ядер (6, 8, 12)
    private int threadCount;        // Количество потоков (12, 16, 24)
    private double baseFrequency;   // Базовая частота (ГГц)
    private double maxFrequency;    // Максимальная частота (ГГц)
    private int cacheSize;          // Размер кэша (МБ)
    private String memoryType;      // Поддерживаемая память (DDR4, DDR5)
    private boolean hasIntegratedGraphics; // Встроенная графика



    public CPU(String id, String brand, String model, int price, String interfaceType, String socket,
               int coreCount, int threadCount,double baseFrequency,double maxFrequency,int cacheSize,String memoryType,
               boolean hasIntegratedGraphics,int powerConsumption, double voltage, String dimensions,
               int weight, String countryProduction, int productionDate, String description,
               int warrantyMoths) {


        super(id, brand, model, price, interfaceType, powerConsumption, voltage, dimensions, weight,
                countryProduction, productionDate, "Процессор", description, warrantyMoths);


        this.socket = socket;
        this.coreCount = coreCount;
        this.threadCount = threadCount;
        this.baseFrequency = baseFrequency;
        this.maxFrequency = maxFrequency;
        this.cacheSize = cacheSize;
        this.memoryType = memoryType;
        this.hasIntegratedGraphics = hasIntegratedGraphics;
    }


    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public double getBaseFrequency() {
        return baseFrequency;
    }

    public void setBaseFrequency(double baseFrequency) {
        this.baseFrequency = baseFrequency;
    }

    public double getMaxFrequency() {
        return maxFrequency;
    }

    public void setMaxFrequency(double maxFrequency) {
        this.maxFrequency = maxFrequency;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public boolean isHasIntegratedGraphics() {
        return hasIntegratedGraphics;
    }

    public void setHasIntegratedGraphics(boolean hasIntegratedGraphics) {
        this.hasIntegratedGraphics = hasIntegratedGraphics;
    }


    @Override
    public void getFullInfoForSeller() {
        super.getFullInfoForSeller();
    }

    @Override
    public void getFullInfoForClient() {
        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice() + " рублей");
        System.out.println("Интерфейс подключения: " + getInterfaceType());
        System.out.println("Сокет: " + getSocket());
        System.out.println("Количество ядер: " + getCoreCount());
        System.out.println("Количество потоков: " + getThreadCount());
        System.out.println("Базовая частота: " + getBaseFrequency() + " ГГц");
        System.out.println("Максимальная частота: " + getMaxFrequency()+ " ГГц");
        System.out.println("Размер кэша: " + getCacheSize() + " МБ");
        System.out.println("Поддерживаемые типы памяти: " + getMemoryType());
        System.out.println("Наличие встроенного графического ядра: " + (hasIntegratedGraphics?" Да":" Нет"));
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
