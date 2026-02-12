package camera;

public class Camera {

    private final Sensor sensor;
    private final MemoryCard memoryCard;

    public Camera( Sensor sensor, MemoryCard memoryCard){
        this.sensor = sensor;
        this.memoryCard = memoryCard;
    }

    private boolean cameraSwitch = false;

    public void pressShutter() {
        if (cameraSwitch){
            byte[] data = sensor.readData();
            memoryCard.write(data);
        }
    }

    public void powerOn() {
        sensor.powerUp();
        cameraSwitch = true;
    }

    public void powerOff() {
        sensor.powerDown();
        cameraSwitch = false;
    }
}

