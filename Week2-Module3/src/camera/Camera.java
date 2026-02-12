package camera;

public class Camera {

    private final Sensor sensor;

    public Camera( Sensor sensor){
        this.sensor = sensor;
    }

    private boolean cameraSwitch = false;

    public void pressShutter() {
        if (cameraSwitch){
            sensor.readData();
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

