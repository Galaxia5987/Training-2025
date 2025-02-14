package frc.robot

import com.pathplanner.lib.path.PathConstraints
import edu.wpi.first.math.geometry.Pose2d
import edu.wpi.first.math.geometry.Rotation2d
import edu.wpi.first.math.geometry.Translation2d
import edu.wpi.first.units.*
import edu.wpi.first.wpilibj.DriverStation
import frc.robot.lib.getPoseByColor
import frc.robot.lib.getTranslationByColor
import frc.robot.subsystems.swerve.SwerveConstants
import org.littletonrobotics.junction.LoggedRobot
import kotlin.math.sqrt

object Constants {
    const val CONFIG_TIMEOUT: Int = 100 // [ms]
    const val LOOP_TIME = 0.02 // [s]
    const val IS_TUNING_MODE = true

    private val EFFECTIVE_ROBOT_RADIUS: Measure<Distance> = Units.Meters.of(SwerveConstants.ROBOT_LENGTH / sqrt(2.0))
    private val MAX_VELOCITY: Measure<Velocity<Distance>> = Units.MetersPerSecond.of(4.5)
    private val MAX_ACCELERATION: Measure<Velocity<Velocity<Distance>>> = Units.MetersPerSecondPerSecond.of(3.0)
    private val MAX_ANGULAR_VELOCITY: Measure<Velocity<Angle>> = Units.RotationsPerSecond.of(
        MAX_VELOCITY.`in`(Units.MetersPerSecond) / EFFECTIVE_ROBOT_RADIUS.`in`(Units.Meters)
    )
    private val MAX_ANGULAR_ACCELERATION: Measure<Velocity<Velocity<Angle>>> =
        Units.RotationsPerSecond.per(Units.Second).of(
                MAX_ACCELERATION.`in`(Units.MetersPerSecondPerSecond) / EFFECTIVE_ROBOT_RADIUS.`in`(Units.Meters)
            )

    private val SPEAKER_POSE_BLUE = Translation2d(0.0, 5.5479442)

    val SPEAKER_POSE: Translation2d
        get() = getTranslationByColor(SPEAKER_POSE_BLUE)

    val CHAIN_LOCATIONS: List<Pose2d> by lazy {
        val blueChainLocations = listOf(
            Triple(4.39, 4.67, -57.72), // Left
            Triple(5.59, 4.09, 180.00), // Center
            Triple(4.39, 3.46, 57.72) // Right
        ).map { (x, y, theta) -> Pose2d(x, y, Rotation2d.fromDegrees(theta)) }

        blueChainLocations.map { pose ->
            getPoseByColor(pose)
        }
    }

    val CURRENT_MODE: Mode
        get() =
            if (LoggedRobot.isReal()){
                Mode.REAL
            }
            else{
                if (System.getenv()["isReplay"] =="true") {
                    Mode.REPLAY
                } else Mode.SIM
            }
    const val ROBORIO_NEO_SERIAL = "030e2d4d"

    val ROBORIO_SERIAL_NUMBER: String
        get() = System.getenv("serialnum") ?: "Sim"

    val IS_RED: Boolean
        get() = DriverStation.getAlliance().isPresent && DriverStation.getAlliance().get() == DriverStation.Alliance.Red

    const val FIELD_LENGTH: Double = 16.54
    const val FIELD_WIDTH: Double = 8.23

    enum class Mode {
        REAL, SIM, REPLAY
    }
}
