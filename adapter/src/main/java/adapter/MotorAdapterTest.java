package adapter;

public class MotorAdapterTest {
    public static void main(String[] args) {
        Motor motor = new ElectricAdapter();
        motor.drive();
    }
}

interface Motor {
    void drive();
}

class ElectricMotor {
    public void electricDrive() {
        System.out.println("电能驱动");
    }
}

class ElectricAdapter implements Motor {

    private ElectricMotor electricMotor;

    public ElectricAdapter() {
        this.electricMotor = new ElectricMotor();
    }

    @Override
    public void drive() {
        electricMotor.electricDrive();
    }
}

class OpticalMotor {
    public void opticalDrive() {
        System.out.println("光能驱动");
    }
}

class OpticalAdapter implements Motor {

    private OpticalMotor opticalMotor;

    public OpticalAdapter() {
        this.opticalMotor = new OpticalMotor();
    }

    @Override
    public void drive() {
        opticalMotor.opticalDrive();
    }
}










