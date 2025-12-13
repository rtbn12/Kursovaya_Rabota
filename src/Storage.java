public class Storage extends ComputerComponent{

    private int capacity;           // Емкость (ГБ или ТБ)
    private String storageType;     // Тип (SSD, HDD, NVMe)
    private int readSpeed;          // Скорость чтения (МБ/с)
    private int writeSpeed;         // Скорость записи (МБ/с)
    private String formFactor;      // Форм-фактор (2.5", M.2, 3.5")
    private int tbw;                // Ресурс записи (TBW - терабайт записи)
    private int cacheSize;          // Размер кэша (МБ)
    private String nandType;        // Тип памяти (TLC, QLC, 3D NAND)

    public Storage(String id, String brand, String model, int price, String interfaceType,int capacity,
                   String storageType,int readSpeed,int writeSpeed,String formFactor,int tbw,int cacheSize,
                   String nandType,int powerConsumption, double voltage, String dimensions, int weight,
                   String countryProduction, int productionDate, String description, int warrantyMoths) {


        super(id, brand, model, price, interfaceType, powerConsumption, voltage, dimensions, weight, countryProduction,
                productionDate, "Постоянное запоминающее устройство", description, warrantyMoths);

        this.capacity = capacity;
        this.storageType = storageType;
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
        this.formFactor = formFactor;
        this.tbw = tbw;
        this.cacheSize = cacheSize;
        this.nandType = nandType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public int getReadSpeed() {
        return readSpeed;
    }

    public void setReadSpeed(int readSpeed) {
        this.readSpeed = readSpeed;
    }

    public int getWriteSpeed() {
        return writeSpeed;
    }

    public void setWriteSpeed(int writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public int getTbw() {
        return tbw;
    }

    public void setTbw(int tbw) {
        this.tbw = tbw;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public String getNandType() {
        return nandType;
    }

    public void setNandType(String nandType) {
        this.nandType = nandType;
    }


    @Override
    public void getFullInfoForClient() {

        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice() + " рублей");
        System.out.println("Интерфейс подключения: " + getInterfaceType());
        System.out.println("Тип: " + getStorageType());
        System.out.println("Емкость: " + getCapacity()+" ГБ ");
        System.out.println("Форм-фактор: " + getFormFactor());
        System.out.println("Скорость чтения: " + getReadSpeed() + " МБ/с");
        System.out.println("Скорость записи: " + getWriteSpeed() + " МБ/с");
        System.out.println("Тип памяти: " + getNandType());
        System.out.println("Кэш: " + getCacheSize() + " МБ");
        System.out.println("Ресурс записи: " + getTbw() + " TBW");
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
