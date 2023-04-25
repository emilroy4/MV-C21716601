package c21716601;

import processing.core.PApplet;

public class nico {

    rockstar nico;

    public nico(rockstar nico) {
        this.nico = nico;
    }

    public float rotationAngle = 0.0f;
    public float circleRadius = 100.0f;
    public int numDots = 12;

    public void render() {
        nico.noFill();
        nico.camera(0, 100, 200, 0, 0, 0, 1, 0, 0);
        nico.translate(0, 0, 0);
        nico.strokeWeight(4);

        float[] b = nico.getSmoothedBands();
        nico.stroke(0, 255, 0); // Green stroke color
        float size = b[2];

        // Apply rotation transformation to the squares
        nico.pushMatrix();
        nico.rotateZ(rotationAngle);
        nico.rect(-size / 2, -size / 2, size, size);
        nico.popMatrix();

        // Render spinning dots around the squares
        nico.noFill();
        nico.stroke(255); // White stroke color for dots

        for (int i = 0; i < numDots; i++) {
            float angle = PApplet.radians(i * 360.0f / numDots); // Calculate angle for dot position
            float x = circleRadius * PApplet.cos(angle); // Calculate x-coordinate
            float y = circleRadius * PApplet.sin(angle); // Calculate y-coordinate

            // Apply rotation transformation to each dot
            nico.pushMatrix();
            nico.translate(x, y, 0);
            nico.rotateZ(rotationAngle);
            nico.point(0, 0); // Render dot at the transformed position
            nico.popMatrix();
        }

        // Increment rotation angle
        rotationAngle += 0.01f;
    }

}