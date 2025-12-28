public class Monitor extends Peripheral{

    private double screenSize;        // Диагональ экрана (дюймы)
    private String resolution;        // Разрешение (1920x1080, 2560x1440)
    private int refreshRate;          // Частота обновления (Гц)
    private String panelType;         // Тип матрицы (IPS, VA, TN, OLED)
    private int responseTime;         // Время отклика (мс)
    private boolean hasHDR;           // Поддержка HDR
    private boolean hasBuiltInSpeakers; // Встроенные колонки

    public Monitor(String id, String brand, String model,
                   double screenSize, String resolution,
                   int refreshRate,String panelType,
                   int responseTime,boolean hasHDR,
                   boolean hasBuiltInSpeakers,
                   String connectionType, double cableLength,
                   boolean isWireless, boolean hasRGB,
                   String color, String countryProduction,
                   int productionDate,String category, int price,
                   String description, int warrantyMoths) {


        super(id, brand, model, connectionType, cableLength, isWireless, hasRGB,
                color, countryProduction, productionDate, price,  category, description, warrantyMoths);


        this.screenSize = screenSize;
        this.resolution = resolution;
        this.refreshRate = refreshRate;
        this.panelType = panelType;
        this.responseTime = responseTime;
        this.hasHDR = hasHDR;
        this.hasBuiltInSpeakers = hasBuiltInSpeakers;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getPanelType() {
        return panelType;
    }

    public void setPanelType(String panelType) {
        this.panelType = panelType;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public boolean isHasHDR() {
        return hasHDR;
    }

    public void setHasHDR(boolean hasHDR) {
        this.hasHDR = hasHDR;
    }

    public boolean isHasBuiltInSpeakers() {
        return hasBuiltInSpeakers;
    }

    public void setHasBuiltInSpeakers(boolean hasBuiltInSpeakers) {
        this.hasBuiltInSpeakers = hasBuiltInSpeakers;
    }

    @Override
    public void getFullInfoForClient() {

        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice());
        System.out.println("Диагональ экрана: " + getScreenSize() + " дюйм(ов)");
        System.out.println("Разрешение: " + getResolution());
        System.out.println("Частота обновления: " + getRefreshRate() + " Гц");
        System.out.println("Тип матрицы: " + getPanelType());
        System.out.println("Время отклика: " + getResponseTime() + " мс");
        System.out.println("Поддержка HDR: " + (isHasHDR() ? "Да" : "Нет"));
        System.out.println("Встроенные колонки: " + (isHasBuiltInSpeakers() ? "Да" : "Нет"));
        System.out.println("Цвет устройства: " + getColor());
        System.out.println("Доступные типы подключения: " + getConnectionType());
        System.out.println("Длина кабеля: " + getCableLength() + " м");
        System.out.println("Беспроводное устройство: " + (isWireless() ? "Да" : "Нет"));
        System.out.println("Наличие RGB подсветки: " + (isHasRGB() ? "Да" : "Нет"));
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating() + "из 5!");
        System.out.println("Количество на складе: " + getQuantityProduct() + " шт.");
        System.out.println("Описание: " + getDescription());
    }
}
