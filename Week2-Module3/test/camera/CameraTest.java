package camera;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class CameraTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    Sensor sensor = context.mock(Sensor.class);
    MemoryCard memoryCard = context.mock(MemoryCard.class);

    @Test
    public void switchingTheCameraOnPowersUpTheSensor() {
         Camera camera = new Camera(sensor, memoryCard);

         context.checking(new Expectations() {{
             exactly(1).of(sensor).powerUp();
         }});

         camera.powerOn();
    }

    @Test
    public void switchingTheCameraOffPowersDownTheSensor() {
        Camera camera = new Camera(sensor, memoryCard);

        context.checking(new Expectations() {{
            exactly(1).of(sensor).powerDown();
        }});

        camera.powerOff();
    }

    @Test
    public void pressingTheShutterWhenThePowerIsOffDoesNothing() {
        Camera camera = new Camera(sensor, memoryCard);

        context.checking(new Expectations() {{
            exactly(1).of(sensor).powerDown();
            exactly(0).of(sensor).powerUp();
            exactly(0).of(sensor).readData();
        }});

        camera.powerOff();
        camera.pressShutter();
    }

    @Test
    public void pressingTheShutterWhenThePowerIsOnCopiesDataFromTheSensorToTheMemoryCard() {
        Camera camera = new Camera(sensor, memoryCard);

        context.checking(new Expectations() {{
           exactly(1).of(sensor).powerUp();
           exactly(1).of(sensor).readData();
           exactly(1).of(memoryCard).write(with(any(byte[].class)));
        }});

        camera.powerOn();
        camera.pressShutter();
    }

    @Test
    public void ifDataIsCurrentlyBeingWrittenSwitchingCameraOffDoesNotPowerDownTheSensor() {
        Camera camera = new Camera(sensor, memoryCard);

        context.checking(new Expectations() {{
            exactly(1).of(sensor).powerUp();
            exactly(1).of(sensor).readData();
            exactly(1).of(memoryCard).write(with(any(byte[].class)));
            exactly(0).of(sensor).powerDown();
        }});

        camera.powerOn();
        camera.pressShutter();
        camera.powerOff();
    }
}
