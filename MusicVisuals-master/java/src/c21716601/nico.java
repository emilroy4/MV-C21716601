package c21716601;

import processing.core.PApplet;

public class nico {

    private rockstar nico;
    private PApplet parent;

    public nico(rockstar nico, PApplet parent) {
        this.nico = nico;
        this.parent = parent;
    }

    private final float TWO_PI = PApplet.TWO_PI;
    public float rotationAngle = 0.0f;

    public void render() {
        nico.noFill();
        nico.camera(0, 100, 400, 0, 0, 0, 1, 0, 0);
        nico.translate(0, 0, 0);
        nico.strokeWeight(4);

        float[] b = nico.getSmoothedBands();
        nico.stroke(0, 255, 0); // Green stroke color
        float size = b[2];

        // Apply rotation transformation
        nico.pushMatrix();
        nico.rotateZ(rotationAngle);
        nico.rect(-size / 2, -size / 2, size, size);
        nico.popMatrix();

        nico.noFill();
        nico.camera(0, -100, 400, 0, 0, 0, 5, 0, 0);
        nico.translate(0, 0, 0);
        nico.strokeWeight(4);

        float[] b1 = nico.getSmoothedBands();
        nico.stroke(0, 255, 0); // Green stroke color
        float size1 = b1[2];

        // Apply rotation transformation
        nico.pushMatrix();
        nico.rotateZ(rotationAngle);
        nico.rect(-size1 / 2, -size1 / 2, size1, size1);
        nico.popMatrix();

        nico.noFill();
        nico.camera(0, 0, 400, 0, 0, 0, 5, 0, 0);
        nico.translate(0, 0, 0);
        nico.strokeWeight(2);

        float[] b2 = nico.getSmoothedBands();
        for (int i = 0; i < b2.length; i++) {
            nico.stroke(0, 255, 0); // Green stroke color
            float s = b2[i];

            // Apply rotation transformation
            nico.pushMatrix();
            nico.rotateZ(rotationAngle);
            nico.ellipse(0, 0, s / 2, s / 2);
            nico.popMatrix();
        }

        // Draw frequency waves on the left and right side of the screen
        nico.noFill();
        nico.strokeWeight(2);

        float[] bands = nico.getSmoothedBands();
        int waveResolution = 100;
        int waveHeight = 50;
        int numWaves = 5;
        int waveSpacing = 50;

        // Draw waves on the left side of the screen
        nico.pushMatrix();
        nico.translate(-nico.width / 2, 0);
        for (int w = 0; w < numWaves; w++) {
            nico.stroke(0, 255, 0); // Green stroke color
            nico.beginShape();
            for (int i = 0; i <= waveResolution; i++) {
                float x = i * nico.width / waveResolution;
                float y = nico.height / 2 + parent.sin(x / waveResolution * TWO_PI * bands[w] * 2) * waveHeight;

                nico.vertex(x, y);
            }
            nico.endShape();
            nico.translate(0, waveSpacing);
        }
        nico.popMatrix();

        // Draw waves on the right side of the screen
        nico.pushMatrix();
        nico.translate(nico.width / 2, 0);
        for (int w = numWaves; w < 2 * numWaves; w++) {
            nico.stroke(0, 255, 0); // Green stroke color
            nico.beginShape();
            for (int i = 0; i <= waveResolution; i++) {
                float x = i * nico.width / waveResolution;
                float y = nico.height / 2 + parent.sin(x / waveResolution * TWO_PI * bands[w] * 2) * waveHeight;

                nico.vertex(x, y);
            }
            nico.endShape();
            nico.translate(0, waveSpacing);
        }
        nico.popMatrix();

        // Increment rotation angle
        rotationAngle += 0.01f;
    }

}
