package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleShifterCommand extends CommandBase {
	private boolean finished = false;
    public ToggleShifterCommand() {
        requires(CommandBase.theShifterSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	CommandBase.toggleShifters = !CommandBase.toggleShifters;
    	CommandBase.theShifterSubsystem.setShifters(CommandBase.toggleShifters);
    	Timer.delay(.5);
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
