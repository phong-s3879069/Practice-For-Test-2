package TestLastSem;

public class Problem1 {
    public static void main(String[] args) throws IncompatibleAppException {
        PhongPhone phongPhone = new PhongPhone("Phong", "Tran");
        CanvasApp app1 = new CanvasApp("app1", 69);
        GameApp app2 = new GameApp("app2", 69);
        App app3 = new App("app3", 69);
        phongPhone.installApp(app1);
        phongPhone.installApp(app2);
        phongPhone.installApp(app3);
    }
}
abstract class Phone {
    String manufacturerName;
    String modelName;

    abstract public String getAppHub();

    abstract public String getOS();

    public void installApp(App app) throws IncompatibleAppException {
        if(this.getOS().equals("Apple")) {
            if ((app instanceof AppleCompatible) && (app instanceof AndroidCompatible)) {
                String message = "Visit" + this.getAppHub() + "to get more apps";
                System.out.println(message);
                String apple_interface_message = ((AppleCompatible) app).saveMoney();
                String android_interface_message = ((AndroidCompatible) app).saveTime();
                System.out.println(apple_interface_message);
                System.out.println(android_interface_message);
            }
            else if(app instanceof AppleCompatible){//apple app
                String message = "Visit" + this.getAppHub() + "to get more apps";
                System.out.println(message);
                String apple_interface_message = ((AppleCompatible) app).saveMoney();
                System.out.println(apple_interface_message);
            }
            else {
                throw new IncompatibleAppException("App is not compatible with phone");
            }
        }
        else if(this.getOS().equals("Android")) {
            if ((app instanceof AppleCompatible) && (app instanceof AndroidCompatible)) {
                String message = "Visit" + this.getAppHub() + "to get more apps";
                System.out.println(message);
                String apple_interface_message = ((AppleCompatible) app).saveMoney();
                String android_interface_message = ((AndroidCompatible) app).saveTime();
                System.out.println(apple_interface_message);
                System.out.println(android_interface_message);
            }
            else if(app instanceof AndroidCompatible){//apple app
                String message = "Visit" + this.getAppHub() + "to get more apps";
                System.out.println(message);
                String apple_interface_message = ((AndroidCompatible) app).saveTime();
                System.out.println(apple_interface_message);
            }
            else {
                throw new IncompatibleAppException("App is not compatible with phone");
            }
        }
        else{
            if ((app instanceof AppleCompatible) && (app instanceof AndroidCompatible)) {
                String message = "Visit" + this.getAppHub() + "to get more apps";
                System.out.println(message);
                String apple_interface_message = ((AppleCompatible) app).saveMoney();
                String android_interface_message = ((AndroidCompatible) app).saveTime();
                System.out.println(apple_interface_message);
                System.out.println(android_interface_message);
            }
            else if(app instanceof AppleCompatible){//apple app
                String message = "Visit" + this.getAppHub() + "to get more apps";
                System.out.println(message);
                String apple_interface_message = ((AppleCompatible) app).saveMoney();
                System.out.println(apple_interface_message);
            }
            else if(app instanceof AndroidCompatible){//apple app
                String message = "Visit" + this.getAppHub() + "to get more apps";
                System.out.println(message);
                String apple_interface_message = ((AndroidCompatible) app).saveTime();
                System.out.println(apple_interface_message);
            }
            else {
                throw new IncompatibleAppException("App is not compatible with phone");
            }
        }
    }
}

class ApplePhone extends Phone {


    public ApplePhone(String manuName, String modelName) {
        this.manufacturerName = manuName;
        this.modelName = modelName;
    }

    @Override
    public String getAppHub() {
        return "App Store";
    }

    @Override
    public String getOS() {
        return "Apple";
    }
}


class AndroidPhone extends Phone {

    public AndroidPhone(String manuName, String modelName) {
        this.manufacturerName = manuName;
        this.modelName = modelName;
    }

    @Override
    public String getAppHub() {
        return "Play Store";
    }

    @Override
    public String getOS() {
        return "Android";
    }
}

class PhongPhone extends Phone {

    public PhongPhone(String manuName, String modelName) {
        this.manufacturerName = manuName;
        this.modelName = modelName;
    }

    @Override
    public String getAppHub() {
        return "Phong";
    }

    @Override
    public String getOS() {
        return "Phong";
    }
}

class App {
    String name;
    int versionNum;

    public App(String name, int version) {
        this.name = name;
        this.versionNum = version;
    }

    @Override
    public String toString() {
        return name + " : " + versionNum;
    }
}

class CanvasApp extends App implements AppleCompatible {
    public CanvasApp(String name, int version) {
        super(name, version);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String saveMoney() {
        String toString = this.toString();
        return "Save enough money to install " + toString;
    }
}

class GameApp extends App implements AndroidCompatible {
    public GameApp(String name, int version) {
        super(name, version);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String saveTime() {
        String toString = this.toString();
        return "Save enough time to install " + toString;
    }
}

interface AppleCompatible {
    public String saveMoney();
}

interface AndroidCompatible {
    public String saveTime();
}

class IncompatibleAppException extends Exception {
    public IncompatibleAppException(String str) {super(str);}
}


