public class Cooler extends ComputerComponent{

    private String coolerType;      // Тип кулера (воздушный, жидкостный)
    private String socketCompatibility; // Совместимые сокеты
    private int fanSize;            // Размер вентилятора (мм)
    private int fanSpeed;           // Скорость вращения (об/мин)
    private int tdp;                // Рассеиваемая мощность (Вт)
    private int heatPipes;          // Количество тепловых трубок
    private boolean hasRGB;         // RGB подсветка
    private boolean hasPwm;         // PWM регулировка оборотов

    public Cooler(String id, String brand, String model, int price, String coolerType,
                  String socketCompatibility, int fanSize,int fanSpeed,int tdp,
                  int heatPipes,boolean hasRGB,boolean hasPwm,
                  int powerConsumption, double voltage, String dimensions, int weight,
                  String countryProduction, int productionDate,
                  String description, int warrantyMoths) {


        super(id, brand, model, price, "Нет", powerConsumption,
                voltage, dimensions, weight, countryProduction, productionDate,
                "Кулер", description, warrantyMoths);

        this.coolerType = coolerType;
        this.socketCompatibility = socketCompatibility;
        this.fanSize = fanSize;
        this.fanSpeed = fanSpeed;
        this.tdp = tdp;
        this.heatPipes = heatPipes;
        this.hasRGB = hasRGB;
        this.hasPwm = hasPwm;

    }

    public String getCoolerType() {
        return coolerType;
    }

    public void setCoolerType(String coolerType) {
        this.coolerType = coolerType;
    }

    public String getSocketCompatibility() {
        return socketCompatibility;
    }

    public void setSocketCompatibility(String socketCompatibility) {
        this.socketCompatibility = socketCompatibility;
    }

    public int getFanSize() {
        return fanSize;
    }

    public void setFanSize(int fanSize) {
        this.fanSize = fanSize;
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public int getTdp() {
        return tdp;
    }

    public void setTdp(int tdp) {
        this.tdp = tdp;
    }

    public int getHeatPipes() {
        return heatPipes;
    }

    public void setHeatPipes(int heatPipes) {
        this.heatPipes = heatPipes;
    }

    public boolean isHasRGB() {
        return hasRGB;
    }

    public void setHasRGB(boolean hasRGB) {
        this.hasRGB = hasRGB;
    }

    public boolean isHasPwm() {
        return hasPwm;
    }

    public void setHasPwm(boolean hasPwm) {
        this.hasPwm = hasPwm;
    }

    @Override
    public void getFullInfoForClient() {
        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice() + " рублей");
        System.out.println("Тип охлаждения: " + getCoolerType());
        System.out.println("Совместимые сокеты: " + getSocketCompatibility());
        System.out.println("Размер вентилятора: " + getFanSize() + " мм");
        System.out.println("Скорость вращения: " + getFanSpeed() + " об/мин");
        System.out.println("Рассеиваемая мощность: " + getTdp() + " Вт");
        System.out.println("Тепловые трубки: " + getHeatPipes() + " шт");
        System.out.println("PWM регулировка: " + (isHasPwm() ? "Да" : "Нет"));
        System.out.println("RGB подсветка: " + (isHasRGB() ? "Да" : "Нет"));
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
