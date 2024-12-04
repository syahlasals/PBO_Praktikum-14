class Config {
    private static Config instance;
    private String setting;

    private Config() {
        this.setting = "Default Config";
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }
}

public class Creational_Main {
    public static void main(String[] args) {
        Config config = Config.getInstance();
        System.out.println(config.getSetting());
        config.setSetting("New Config");
        System.out.println(Config.getInstance().getSetting());
    }
}
