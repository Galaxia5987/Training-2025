package frc.robot

import com.pathplanner.lib.auto.AutoBuilder
import com.pathplanner.lib.auto.NamedCommands
import com.pathplanner.lib.path.PathPlannerPath
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.Commands
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import frc.robot.ControllerInputs.driverController
import frc.robot.commandGroups.IntakeCommands
import frc.robot.commandGroups.ShootingCommands
import frc.robot.commandGroups.WarmupCommands
import frc.robot.scoreState.AmpState
import frc.robot.scoreState.ClimbState
import frc.robot.scoreState.ScoreState
import frc.robot.scoreState.ShootState
import frc.robot.subsystems.climb.Climb
import frc.robot.subsystems.gripper.Gripper
import frc.robot.subsystems.intake.Intake
import frc.robot.subsystems.shooter.Shooter
import frc.robot.subsystems.swerve.SwerveDrive
import org.littletonrobotics.junction.AutoLogOutput


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the [Robot]
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
object RobotContainer {

    init {

    }

    private fun configureDefaultCommands() {

    }

    private fun configureButtonBindings() {
    }

    fun getAutonomousCommand(): Command = Commands.none()


    private fun registerAutoCommands() {
        fun register(name: String, command: Command) = NamedCommands.registerCommand(name, command)
    }
}
