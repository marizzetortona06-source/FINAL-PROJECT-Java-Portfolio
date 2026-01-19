import java.util.*;

public class Main {
    public static void main(String[] args) {
        AirConditioner AirConditioner1 = new AirConditioner("Living Room AC", 5, 22);
        LampShade Lamp1 = new LampShade("Desk Lamp", 80, "White");
        LampShade Lamp2 = new LampShade(Lamp1);
        Television TV1 = new Television("Samsung Smart TV", 5, 15);
        MicrowaveOven Microwave1 = new MicrowaveOven("Kitchen Microwave", 3, 180);

        List<Device> devices = Arrays.asList(AirConditioner1, Lamp1, Lamp2, TV1, Microwave1);

        System.out.println("=== Turning all devices ON ===");
        DeviceHelper.toggleDevices(devices, true);
        
        System.out.println("\n=== Turning all devices OFF ===");
        DeviceHelper.toggleDevices(devices, false);
        
        System.out.println("\n=== Counting devices ===");
        DeviceHelper.countOnDevices(devices);
    }
}

abstract class Device {
    private String name;
    private boolean isOn;

    public Device(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " has been powered ON.");
        details();
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " has been powered OFF.");
    }

    public boolean isOn() {
        return isOn;
    }

    public String getName() {
        return name;
    }

    public abstract void details();
}

class AirConditioner extends Device {
    private int fanSpeed;
    private int temperature;

    public AirConditioner(String name, int fanSpeed, int temperature) {
        super(name);
        this.fanSpeed = fanSpeed;
        this.temperature = temperature;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
        System.out.println("Fan speed adjusted to level " + fanSpeed);
        details();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Temperature adjusted to " + temperature + " degrees");
        details();
    }

    public void details() {
        System.out.println("AirConditioner Settings [Speed=" + fanSpeed + ", Temperature=" + temperature + " degrees]");
    }
}

class LampShade extends Device {
    private int brightness;
    private String color;

    public LampShade(String name, int brightness, String color) {
        super(name);
        this.brightness = brightness;
        this.color = color;
    }

    public LampShade(LampShade other) {
        super(other.getName());
        this.brightness = other.brightness;
        this.color = other.color;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
        System.out.println("Brightness adjusted to " + brightness + "%");
        details();
    }

    public void setColor(String color) {
        this.color = color;
        System.out.println("Light color switched to " + color);
        details();
    }

    public void details() {
        System.out.println("LampShade Configuration [Brightness=" + brightness + "%, Light Color=" + color + "]");
    }
}

class Television extends Device {
    private int channel;
    private int volume;

    public Television(String name, int channel, int volume) {
        super(name);
        this.channel = channel;
        this.volume = volume;
    }

    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("Channel changed to " + channel);
        details();
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Volume adjusted to level " + volume);
        details();
    }

    public void details() {
        System.out.println("Television Status [Current Channel=" + channel + ", Volume Level=" + volume + "]");
    }
}

class MicrowaveOven extends Device {
    private int timer;
    private int temperature;

    public MicrowaveOven(String name, int timer, int temperature) {
        super(name);
        this.timer = timer;
        this.temperature = temperature;
    }

    public void setTimer(int timer) {
        this.timer = timer;
        System.out.println("Timer configured for " + timer + " minutes");
        details();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Heat level set to " + temperature + " degrees");
        details();
    }

    public void details() {
        System.out.println("MicrowaveOven Settings [Duration=" + timer + " minutes, Heat=" + temperature + " degrees]");
    }
}

class DeviceHelper {
    public static void toggleDevices(List<Device> devices, boolean powerOn) {
        for (Device d : devices) {
            if (powerOn) {
                d.turnOn();
            } else {
                d.turnOff();
            }
        }
    }

    public static void countOnDevices(List<Device> devices) {
        int count = 0;
        for (Device d : devices) {
            if (d.isOn()) {
                count++;
            }
        }
        System.out.println("Total devices currently powered ON: " + count);
    }
}
