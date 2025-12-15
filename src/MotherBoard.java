public class MotherBoard extends ComputerComponent{

    private String chipset;          // Чипсет (B550, Z790)
    private String socket;           // Сокет (AM4, LGA1700)
    private int ramSlots;            // Количество слотов RAM
    private int maxRamCapacity;      // Макс. объем RAM (ГБ)
    private String ramType;          // Тип памяти (DDR4, DDR5)
    private int m2Slots;             // Количество M.2 слотов
    private int sataPorts;           // Количество SATA портов
    private boolean hasWiFi;         // Встроенный WiFi
    private String audioCodec;       // Аудиокодек
    private String lanSpeed;         // Скорость сетевой карты



    public MotherBoard(String id, String brand, String model, int price, String interfaceType,
                       String chipset, String socket, int ramSlots, int maxRamCapacity, String ramType,
                       int m2Slots, int sataPorts, boolean hasWiFi, String audioCodec, String lanSpeed,
                       int powerConsumption, double voltage, String dimensions, int weight,
                       String countryProduction, int productionDate,String category,
                       String description,
                       int warrantyMoths) {



        super(id, brand, model, price, interfaceType, powerConsumption, voltage, dimensions,
                weight, countryProduction, productionDate, category,
                description, warrantyMoths);

        this.chipset = chipset;
        this.socket = socket;
        this.ramSlots = ramSlots;
        this.maxRamCapacity = maxRamCapacity;
        this.ramType = ramType;
        this.m2Slots = m2Slots;
        this.sataPorts = sataPorts;
        this.hasWiFi = hasWiFi;
        this.audioCodec = audioCodec;
        this.lanSpeed = lanSpeed;
    }


    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getRamSlots() {
        return ramSlots;
    }

    public void setRamSlots(int ramSlots) {
        this.ramSlots = ramSlots;
    }

    public int getMaxRamCapacity() {
        return maxRamCapacity;
    }

    public void setMaxRamCapacity(int maxRamCapacity) {
        this.maxRamCapacity = maxRamCapacity;
    }

    public String getRamType() {
        return ramType;
    }

    public void setRamType(String ramType) {
        this.ramType = ramType;
    }

    public int getM2Slots() {
        return m2Slots;
    }

    public void setM2Slots(int m2Slots) {
        this.m2Slots = m2Slots;
    }

    public int getSataPorts() {
        return sataPorts;
    }

    public void setSataPorts(int sataPorts) {
        this.sataPorts = sataPorts;
    }

    public boolean isHasWiFi() {
        return hasWiFi;
    }

    public void setHasWiFi(boolean hasWiFi) {
        this.hasWiFi = hasWiFi;
    }

    public String getAudioCodec() {
        return audioCodec;
    }

    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }

    public String getLanSpeed() {
        return lanSpeed;
    }

    public void setLanSpeed(String lanSpeed) {
        this.lanSpeed = lanSpeed;
    }


    @Override
    public void getFullInfoForClient() {

        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice() + " рублей");
        System.out.println("Интерфейс подключения: " + getInterfaceType());
        System.out.println("Чипсет: " + getChipset());
        System.out.println("Сокет: " + getSocket());
        System.out.println("Поддерживаемые типы памяти: " + getRamType());
        System.out.println("Количество слотов RAM: " + getRamSlots());
        System.out.println("Максимальный объём RAM: " + getMaxRamCapacity() + "Гб");
        System.out.println("Количество M.2-портов: " + getM2Slots());
        System.out.println("Количество SATA-портов: " + getSataPorts());
        System.out.println("Аудиокодек: " + getAudioCodec());
        System.out.println("Скорость сетевой карты: " + getLanSpeed() + "Мбит/с");
        System.out.println("Наличие встроенного WI-FI модуля: " + (hasWiFi ? "Да" : "Нет"));
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
