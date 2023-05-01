package c21716601;

import processing.core.PApplet;

public class case4 {
    rockstar case4;
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

    public case4(rockstar case4) {
        this.case4 = case4;
    }

    public void render() {
        case4.pushMatrix();
        float amplitude = case4.getSmoothedAmplitude();
        // Add shooting stars effect
        for (int i = 0; i < starSizes.length; i++) {
            if (!starActive[i]) {
                // Generate a new star
                starSizes[i] = case4.random(5, 15);
                starOpacities[i] = 0;
                starFades[i] = case4.random(100, 255);
                starActive[i] = true;
            }

            // Update the star's opacity
            float amplitude1 = case4.getSmoothedAmplitude();
            float colorVal1 = case4.map(amplitude1, 0, 1, 0, 255);
            starOpacities[i] = PApplet.lerp(starOpacities[i], colorVal1, 0.2f); //
            // Interpolate between the current
            // opacity and the new opacity based on
            // the audio amplitude

            // Draw the star
            case4.noStroke();
            case4.fill(255, 255, 255, starOpacities[i]);
            case4.ellipse(case4.random(0, case4.width), case4.random(0, case4.height), starSizes[i],
                    starSizes[i]);

            // Fade out the star
            if (starOpacities[i] >= starFades[i]) {
                starOpacities[i] = starFades[i];
                starActive[i] = false;
            }
        }

        // Draw the shooting stars
        case4.strokeWeight(100);
        for (int j = 0; j < shootingStarActive.length; j++) {
            if (shootingStarActive[j]) {
                for (int i = 0; i < shootingStarLength[j]; i++) {
                    float fade = case4.map(i, 0, shootingStarLength[j], 255, 0);
                    case4.stroke(255, 255, 255, fade);
                    float x = shootingStarX[j] + i * PApplet.cos(shootingStarAngle[j]);
                    float y = shootingStarY[j] + i * PApplet.sin(shootingStarAngle[j]);
                    case4.line(x, y, x - PApplet.cos(shootingStarAngle[j] - PApplet.PI / 2),
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
        case4.popMatrix();

    }

}
