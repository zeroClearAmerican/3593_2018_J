package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;




public class DriveSubsystem extends Subsystem {

	Spark driveL;
	Spark driveR;
		
	DifferentialDrive DR;
	
	
	public DriveSubsystem() {
		driveL = new Spark(RobotMap.driveLeftPWM);
		driveR = new Spark(RobotMap.driveRightPWM);
		DR = new DifferentialDrive(driveL, driveR);
		}
	
	public void driveTank(double left, double right) {
		DR.tankDrive(left, right);
	}
	
	public void driveStop() {
		DR.tankDrive(0,0);
	}
			
    public void initDefaultCommand() {	
    	setDefaultCommand(new DriveCommand());
    }
}

