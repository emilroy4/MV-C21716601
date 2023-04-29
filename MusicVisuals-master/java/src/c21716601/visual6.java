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
    private boolean[] shootingStarActive = new boolean[15];
    private float[] shootingStarX = new float[15];
    private float[] shootingStarY = new float[15];
    private float[] shootingStarLength = new float[15];
    private float[] shootingStarFade = new float[15];
    private float[] shootingStarAngle = new float[15];
    float[] starSizes = new float[30];
    float[] starOpacities = new float[30];
    float[] starFades = new float[30];
    boolean[] starActive = new boolean[30];
    

    public visual6(rockstar rs) {
        this.rs = rs;
    }

    float angle = 0.0f;
    float width = 800f;
    float height = 800f;

    public void render() {
        rs.background(0);
         // Increment the angle by a small amount
        angle += 0.01;
        rs.camera(0, -3800, 0, 0, 0, 0, 5, 0, 20);
        rs.pushMatrix();
        rs.translate(500, 500);
        rs.rotateX(angle);
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
        rs.popMatrix();
        // Add shooting stars effect
        for (int i = 0; i < starSizes.length; i++) {
            if (!starActive[i]) {
                // Generate a new star
                starSizes[i] = rs.random(5, 15);
                starOpacities[i] = 0;
                starFades[i] = rs.random(100, 255);
                starActive[i] = true;
            }

            // Update the star's opacity
            float amplitude1 = rs.getSmoothedAmplitude();
            float colorVal1 = rs.map(amplitude1, 0, 1, 0, 255);
            starOpacities[i] = PApplet.lerp(starOpacities[i], colorVal1, 0.2f); // Interpolate between the current
                                                                                // opacity and the new opacity based on
                                                                                // the audio amplitude

            // Draw the star
            rs.noStroke();
            rs.fill(255, 255, 255, starOpacities[i]);
            rs.ellipse(rs.random(0, rs.width), rs.random(0, rs.height), starSizes[i], starSizes[i]);

            // Fade out the star
            if (starOpacities[i] >= starFades[i]) {
                starOpacities[i] = starFades[i];
                starActive[i] = false;
            }
        }

        // Draw the shooting stars
        rs.strokeWeight(3);
        for (int j = 0; j < shootingStarActive.length; j++) {
            if (shootingStarActive[j]) {
                for (int i = 0; i < shootingStarLength[j]; i++) {
                    float fade = rs.map(i, 0, shootingStarLength[j], 255, 0);
                    rs.stroke(255, 255, 255, fade);
                    float x = shootingStarX[j] + i * PApplet.cos(shootingStarAngle[j]);
                    float y = shootingStarY[j] + i * PApplet.sin(shootingStarAngle[j]);
                    rs.line(x, y, x - PApplet.cos(shootingStarAngle[j] - PApplet.PI / 2),
                            y - PApplet.sin(shootingStarAngle[j] - PApplet.PI / 2));
                }

                // Fade out the shooting star
                shootingStarFade[j] = 255 - (amplitude * 255);

                if (shootingStarFade[j] <= 0) {
                    // Reset the shooting star
                    shootingStarActive[j] = false;
                }
            }
        }
    }
}
