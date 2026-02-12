package camera;

public class Camera implements WriteListener {

    private final Sensor sensor;
    private final MemoryCard memoryCard;
    private boolean cameraOn = false;
    private boolean writing = false;

    public Camera( Sensor sensor, MemoryCard memoryCard){
        this.sensor = sensor;
        this.memoryCard = memoryCard;
    }

    public void pressShutter() {
        if (cameraOn){
            writing = true;
            writeDataFromSensorToMemoryCard();
        }
    }

    public void powerOn() {
        sensor.powerUp();
        cameraOn = true;
    }

    public void powerOff() {
        if(!writing){
            sensor.powerDown();
            cameraOn = false;
        }
    }

    private void writeDataFromSensorToMemoryCard() {
        byte[] data = sensor.readData();
        memoryCard.write(data);
    }

    @Override
    public void writeComplete() {

    }
}

