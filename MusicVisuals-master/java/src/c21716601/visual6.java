package c21716601;

import processing.core.PApplet;

public class visual6 {

    rockstar rs;
    private float[] hoopSizes = { 5.0f, 5.0f, 5.0f, 5.0f, 5.0f }; // starting size at 5 pixels for the 5 hoops
    private float[] hoopOpacities = { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
    private float[] newHoopSizes = { 5.0f, 5.0f, 5.0f, 5.0f, 5.0f }; // starting size at 5 pixels for the 5 new hoops
    private float[] newHoopOpacities = { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
    private int lastHoopTime = 0;
    private int hoopInterval = 1000; // 1 second interval
    private int currentHoop = 0;
    private boolean shootingStarActive = false;
    private float shootingStarX = 0;
    private float shootingStarY = 0;
    private float shootingStarLength = 0;
    private float shootingStarFade = 0;

    public visual6(rockstar rs) {
        this.rs = rs;
    }

    public void render() {
        rs.background(0);

        float amplitude = rs.getSmoothedAmplitude();
        float colorVal = rs.map(amplitude, 0, 1, 0, 255);

        // Expand the current hoop
        hoopSizes[currentHoop] += amplitude * 20;
        hoopOpacities[currentHoop] = rs.map(amplitude, 0, 1, 0, 255);

        // Create and expand new hoops every 1 second interval
        int currentTime = rs.millis();
        if (currentTime - lastHoopTime > hoopInterval) {
            lastHoopTime = currentTime;
            currentHoop++;
            if (currentHoop >= hoopSizes.length) {
                currentHoop = 0;
            }
            newHoopSizes[currentHoop] = 5.0f;
            newHoopOpacities[currentHoop] = 0.0f;
        }

        // Expand the new hoops
        for (int i = 0; i < newHoopSizes.length; i++) {
            newHoopSizes[i] += amplitude * 20;
            newHoopOpacities[i] = rs.map(amplitude, 0, 1, 0, 255);
        }

        // Draw all the hoops
        for (int i = 0; i < hoopSizes.length; i++) {
            rs.strokeWeight(10);
            rs.stroke(200, 0, 0, hoopOpacities[i]); // set stroke color to a darker red for the current hoop
            rs.noFill();
            rs.ellipse(rs.width / 2, rs.height / 2, hoopSizes[i], hoopSizes[i]);

            rs.stroke(200, 0, 0, newHoopOpacities[i]); // set stroke color to a darker red for the new hoop
            rs.noFill();

            // Reset the new hoop when it goes out of camera
            if (newHoopSizes[i] >= PApplet.sqrt(PApplet.pow(rs.width, 2) + PApplet.pow(rs.height, 2)) + 200) {
                newHoopSizes[i] = 5.0f;
                newHoopOpacities[i] = 0.0f;
            }
            rs.ellipse(rs.width / 2, rs.height / 2, newHoopSizes[i], newHoopSizes[i]);
        }
        // Add shooting stars effect
        if (!shootingStarActive && rs.random(0, 1) > 0.995) {
            // Start a new shooting star
            shootingStarX = rs.random(0, rs.width);
            shootingStarY = rs.random(0, rs.height);
            shootingStarLength = rs.random(50, 200);
            shootingStarFade = 255;
            shootingStarActive = true;
        }
        if (shootingStarActive) {
            // Draw the shooting star
            rs.stroke(255, 255, 255, shootingStarFade);
            rs.strokeWeight(3);
            rs.line(shootingStarX, shootingStarY, shootingStarX + shootingStarLength,
                    shootingStarY + shootingStarLength);

            // Fade out the shooting star
            shootingStarFade -= 5;

            if (shootingStarFade <= 0) {
                // Reset the shooting star
                shootingStarActive = false;
            }
        }
    }
}
