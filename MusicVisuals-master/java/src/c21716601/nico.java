package c21716601;

import processing.core.PApplet;

public class nico {

    rockstar nico;

    public nico(rockstar nico) {
        this.nico = nico;
    }

    public float rotationAngle = 0.0f;

    public void render() {
        nico.noFill();
        nico.camera(0, 100, 200, 0, 0, 0, 1, 0, 0);
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
        nico.camera(0, -100, 200, 0, 0, 0, 5, 0, 0);
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
        nico.camera(0, 0, 200, 0, 0, 0, 5, 0, 0);
        nico.translate(0, 0, 0);
        nico.strokeWeight(2);

        float[] b2 = nico.getSmoothedBands();
        for (int i = 0; i < b2.length; i++) {
            float c = nico.map(i, 0, b2.length, 0, 360); // Map the index to an angle
            float r = size + (b2[i] * 0.5f); // Calculate the radius of the circle

            // Calculate the position of the dot using polar coordinates
            float x = r * nico.cos(nico.radians(c));
            float y = r * nico.sin(nico.radians(c));

            nico.stroke(0, 255, 0); // Green stroke color

            // Apply rotation transformation
            nico.pushMatrix();
            nico.rotateZ(rotationAngle);
            nico.translate(x, y);
            nico.ellipse(0, 0, 10, 10); // Draw the dot
            nico.popMatrix();
        }

        // Increment rotation angle
        rotationAngle += 0.01f;
    }

}