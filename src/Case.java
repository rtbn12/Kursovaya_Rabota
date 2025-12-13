public class Case extends ComputerComponent{


    private String caseType;        // Тип корпуса (Full-Tower, Mid-Tower, Mini-Tower)
    private String motherboardFormFactor; // Поддерживаемые форм-факторы (ATX, mATX, ITX)
    private int driveBays35;        // Отсеки для 3.5" дисков
    private int driveBays25;        // Отсеки для 2.5" дисков
    private String frontPanel;      // Разъемы на передней панели (USB, Audio)
    private boolean hasTemperedGlass; // Боковое стекло
    private boolean hasFanSupport;      // Поддержка вентиляторов
    private boolean hasRGB;         // RGB подсветка
    private boolean hasDustFilters; // Пылевые фильтры


    public Case(String id, String brand, String model, int price,String caseType,
                String motherboardFormFactor,int driveBays35,int driveBays25,
                String frontPanel,boolean hasTemperedGlass,boolean hasFanSupport,
                boolean hasRGB,boolean hasDustFilters,
                String dimensions, int weight,
                String countryProduction, int productionDate,
                String description, int warrantyMoths) {


        super(id, brand, model, price, "Нет", 0, 0, dimensions,
                weight, countryProduction, productionDate, "Кейс", description, warrantyMoths);


        this.caseType = caseType;
        this.motherboardFormFactor = motherboardFormFactor;
        this.driveBays35 = driveBays35;
        this.driveBays25 = driveBays25;
        this.frontPanel = frontPanel;
        this.hasTemperedGlass = hasTemperedGlass;
        this.hasRGB = hasRGB;
        this.hasDustFilters = hasDustFilters;
        this.hasFanSupport = hasFanSupport;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getMotherboardFormFactor() {
        return motherboardFormFactor;
    }

    public void setMotherboardFormFactor(String motherboardFormFactor) {
        this.motherboardFormFactor = motherboardFormFactor;
    }

    public int getDriveBays35() {
        return driveBays35;
    }

    public void setDriveBays35(int driveBays35) {
        this.driveBays35 = driveBays35;
    }

    public int getDriveBays25() {
        return driveBays25;
    }

    public void setDriveBays25(int driveBays25) {
        this.driveBays25 = driveBays25;
    }

    public String getFrontPanel() {
        return frontPanel;
    }

    public void setFrontPanel(String frontPanel) {
        this.frontPanel = frontPanel;
    }

    public boolean isHasTemperedGlass() {
        return hasTemperedGlass;
    }

    public void setHasTemperedGlass(boolean hasTemperedGlass) {
        this.hasTemperedGlass = hasTemperedGlass;
    }

    public boolean isHasFanSupport() {
        return hasFanSupport;
    }

    public void setHasFanSupport(boolean hasFanSupport) {
        this.hasFanSupport = hasFanSupport;
    }

    public boolean isHasRGB() {
        return hasRGB;
    }

    public void setHasRGB(boolean hasRGB) {
        this.hasRGB = hasRGB;
    }

    public boolean isHasDustFilters() {
        return hasDustFilters;
    }

    public void setHasDustFilters(boolean hasDustFilters) {
        this.hasDustFilters = hasDustFilters;
    }

    @Override
    public void getFullInfoForClient() {
        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice() + " рублей");
        System.out.println("Тип корпуса: " + getCaseType());
        System.out.println("Поддерживаемые платы: " + getMotherboardFormFactor());
        System.out.println("Отсеки 3.5 : " + getDriveBays35());
        System.out.println("Отсеки 2.5 : " + getDriveBays25());
        System.out.println("Разъёмы передней панели: " + getFrontPanel());
        System.out.println("Боковое стекло: " + (isHasTemperedGlass() ? "Закаленное стекло" : "Металл"));
        System.out.println("Поддержка вентиляторов: " + (isHasFanSupport()? "Да" : "Нет"));
        System.out.println("RGB подсветка: " + (isHasRGB() ? "Да" : "Нет"));
        System.out.println("Пылевые фильтры: " + (isHasDustFilters() ? "Да" : "Нет"));
        System.out.println("Габариты: " + getDimensions() + " мм");
        System.out.println("Вес: " + getWeight() + " г");
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating());
        System.out.println("Описание: " + getDescription());
    }
}
