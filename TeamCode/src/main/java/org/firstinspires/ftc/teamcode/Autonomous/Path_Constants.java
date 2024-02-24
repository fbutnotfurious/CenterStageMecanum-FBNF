package org.firstinspires.ftc.teamcode.Autonomous;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Declaring all of our path constant arrays:
public class Path_Constants
{
    public static List<Double> motors;
    // BSB Center Park & BSB Corner Park:
    public static double[] BSB_WP_Center = new double[10];
    public static double[] BSB_WP_Left = new double[11];
    public static double[] BSB_WP_Right = new double[11];

    // BSR Center Park & BSR Corner Park: ******
    public static double [] BSR_WP_Center = new double[15];
    public static double [] BSR_WP_Left = new double[15];
    public static double [] BSR_WP_Right = new double[15];

    // FSB Center Park & FSB Corner Park:
    public static double[] FSB_WP_Center = new double[16];
    public static double [] FSB_WP_Left = new double[12];
    public static double [] FSB_WP_Right = new double[12];


    // FBR Center Park & FBR Corner Park:

    // Setting the values to the path constants:
    public static void SetData()
    {

        //Backstage Red Center Spike:
        //Corner Park Constraints:
       // FSB_WP_Center[0]


        // Backstage Blue (BSB) Center Spike:
        // Corner Park Constants:
        BSB_WP_Center[0]=16.5; // Move Forward by 16.5
        BSB_WP_Center[1]=8.0; // Move Forward by 8.0
        BSB_WP_Center[2]=3.0; // Move Backward by 3.0
        BSB_WP_Center[3]=1.0; // Move Backward by 1.0
        BSB_WP_Center[4]=23.0; // Spin Clockwise by 23.0
        BSB_WP_Center[5]=30.0; // Move Backward by 30.0
        BSB_WP_Center[6]=22.0; // Strafe Right by 22.0
        BSB_WP_Center[7]=10.0; // Move Backward by 10.0
        // Center Park Constants: (above 0-5, rewrite 6-7)
        BSB_WP_Center[8]=24.0; // Strafe Left by 24.0
        BSB_WP_Center[9]=12.0; // Move Backward by 10.0

        // Backstage Blue (BSB) Left Spike:
        // Corner Park Constants:
        BSB_WP_Left[0] = 9.5; // Strafe Left by 9.5
        BSB_WP_Left[1] = 10.0; // Move Forward by 10.0
        BSB_WP_Left[2] = 13.0; // Move Forward by 14.0
        BSB_WP_Left[3] = 3.0; // Move Backward by 3.0
        BSB_WP_Left[4] = 1.0; // Move Backward 1.0
        BSB_WP_Left[5] = 21.5; // Spin Clockwise by 21.5
        BSB_WP_Left[6] = 21.0; // Move Backward by 21.0
        BSB_WP_Left[7] = 16.0; // Strafe Right by 16.0
        BSB_WP_Left[8] = 10.0; // Move Backward by 10.0
        // Center Park Constants: (above 0-6, rewrite 7-8)
        BSB_WP_Left[9] = 32.0; // Strafe Left by 32.0
        BSB_WP_Left[10] = 12.0; // Move Backward by 12.0

        // Backstage Blue (BSB) Right Spike:
        // Corner Park Constants:
        BSB_WP_Right[0] = 7.0; // Strafe Left by 7.0
        BSB_WP_Right[1] = 27.0; // Move Forward by 27.0
        BSB_WP_Right[2] = 22.0; // Spin Clockwise by 22.0
        BSB_WP_Right[3] = 6.5; // Move Forward by 6.5
        BSB_WP_Right[4] = 3.0; // Move Backward by 3.0
        BSB_WP_Right[5] = 27.0; // Move Backward by 27.0
        BSB_WP_Right[6] = 3.0; // Strafe Left by 2.0
        BSB_WP_Right[7] = 29.0; // Strafe Right by 29.0
        BSB_WP_Right[8] = 10.0; // Move Backward by 10.0
        // Center Park Constants: (above 0-6, rewrite 7-8)
        BSB_WP_Right[9] = 14.0; // Strafe Left by 14.0
        BSB_WP_Right[10] = 12.0; // Move Backward by 12.0

        // Frontstage Blue (FSB) Center Spike: ***************
        // Corner Park Constants:
        FSB_WP_Center[0] = 16.5; // Move Forward by 16.5
        FSB_WP_Center[1] = 8.0; // Move Forward by 8.0
        FSB_WP_Center[2] = 3.25; // Move Backward by 4.0


        FSB_WP_Center[3] = 16.0; // strafe right by 12.0
        FSB_WP_Center[4] = 30.25; // Move forward by 30.0
        FSB_WP_Center[5] = 20.0; // strafe left by 18.0
        FSB_WP_Center[6] = 21.50; // Spin Clockwise by 21.5
        // wrist down
        FSB_WP_Center[7] = 45.0; // Move Backward by 67
        FSB_WP_Center[8] = 22.0; // Move Backward by 67

        // wrist up
        FSB_WP_Center[9] = 24.0; // strafe right by 20 //28.5
        FSB_WP_Center[10] = 7.0; // Backward by 8.5 inches

        //drop pixel
        FSB_WP_Center[11] = 22.5; // Strafe left by 29.0
        FSB_WP_Center[12] = 10.0; // Move Backward by 10.0

        // Center Park Constants: (above 0-6, rewrite 7, add 9)
        FSB_WP_Center[13] = 22.5; // Strafe Left by 20.0
        FSB_WP_Center[14] = 5.0; // Move Backward by 5.0

        // Frontstage Blue (FSB) Left Spike:
        // Corner Park Constants:
        FSB_WP_Left[0] = 7.0; // Strafe Right by 5
        FSB_WP_Left[1] = 6.0; // Move Forward by 6.0
        FSB_WP_Left[2] = 22.0; // Spin Anticlockwise by 22.0
        FSB_WP_Left[3] = 24.0; // Strafe Right by 24.0
        FSB_WP_Left[4] = 5.5; // Move Forward by 4.5
        // drop wrist and open gripper
        FSB_WP_Left[5] = 3.25; // Move Backward by 3.0
        // close gripper and wrist up
        FSB_WP_Left[6] = 7.0; // Move Backward by 7.0
        FSB_WP_Left[7] = 20.0; // Strafe Right 18.0
        FSB_WP_Left[8] = 43.0; // Spin Anticlockwise by 44.0
        // wrist down
        FSB_WP_Left[9] = 52.0; // Move Backward by 50
        // Wrist up
        FSB_WP_Left[10] = 36.0; // Move Backward by 36
        FSB_WP_Left[11] = 36.0; // Move right by 36

        //Corner Park

        // Center Park Constants:



        // Frontstage Blue (FSB) Right Spike:
        // Corner Park Constants:
        FSB_WP_Right[0] = 10.25; // Strafe Right by 10.25
        FSB_WP_Right[1] = 10.0; // Move Forward by 10.0
        // drop wrist
        FSB_WP_Right[2] = 7.0; // Move Forward by 7.0
        // open gripper
        FSB_WP_Right[3] = 3.0; // Move Backward by 3.0
        // close gripper wrist up
        FSB_WP_Right[4] = 11.5; // Strafe Left by 9.5
        FSB_WP_Right[5] = 33.0; // Move Forward by 33.0
        FSB_WP_Right[6] = 22.0; // Spin Clockwise by 22.0
        // wrist down
        FSB_WP_Right[7] = 56.2; // Move Backward by 50
        // Wrist up
        FSB_WP_Right[8] = 22.0; // Move Backward by 36
        FSB_WP_Right[9] = 20.0; // Move right by 6

    }


}

