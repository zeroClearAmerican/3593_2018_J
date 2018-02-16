package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SensorSubsystem extends Subsystem {
	//SnesorSubsystem will be called purely in Auto mode. only sensor that is not is PS and Cameras
	//(camera already has its own subsystem)
	Encoder encL;
	Encoder encR;
	
	AnalogGyro gyro;

	AnalogInput PS;
	
	public SensorSubsystem() {
		encL = new Encoder(RobotMap.encoderL1, RobotMap.encoderL2);
		encR = new Encoder(RobotMap.encoderR1, RobotMap.encoderR2);
		encL.setDistancePerPulse(RobotMap.encoderDPP);
		encR.setDistancePerPulse(RobotMap.encoderDPP);
		
		gyro = new AnalogGyro(RobotMap.gryo);
		
		PS = new AnalogInput(RobotMap.pressureSensor);
	}
	
	
	public double getGyroAngle() {
		return gyro.getAngle();
	}
	
	public double[] getEncDistance() {
		return new double[] {
				encL.getDistance(),
				encR.getDistance()
		};
	}
	
	public void resetGyro() {
		gyro.reset();
	}
	
	public void resetEncoders() {
		encL.reset();
		encR.reset();
	}
	
	public double getPressure() {
		return 250 * (PS.getVoltage() / 5) - 25; 
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

