package c21716601;

import processing.core.PConstants;
import processing.core.PApplet;

public class nico {

    rockstar nico;
    Wave wave1, wave2, wave3, wave4;

    public nico(rockstar nico) {
        this.nico = nico;
        wave1 = new Wave(nico, -200, -200);
        wave2 = new Wave(nico, -200, 200);
        wave3 = new Wave(nico, 200, -200);
        wave4 = new Wave(nico, 200, 200);
    }

    public float rotationAngle = 0.0f;

    public void render() {
        nico.noFill();
        nico.camera(0, 100, 400, 0, 0, 0, 1, 0, 0);
        nico.translate(0, 0, 0);
        nico.strokeWeight(4);

        // Draw square in the center
        float[] b = nico.getSmoothedBands();
        nico.stroke(0, 255, 0); // Green stroke color
        float size = b[2];
        nico.pushMatrix();
        nico.rotateZ(rotationAngle);
        nico.rect(-size / 2, -size / 2, size, size);
        nico.popMatrix();

        // Draw waves in each corner
        wave1.update(b[0]);
        wave2.update(b[1]);
        wave3.update(b[3]);
        wave4.update(b[4]);
        wave1.draw();
        wave2.draw();
        wave3.draw();
        wave4.draw();

        // Increment rotation angle
        rotationAngle += 0.01f;
    }
}

class Wave {
    rockstar nico;
    float x, y;
    float amplitude = 0;
    float frequency = 0.05f;
    float phase = 0;
    int numWaves = 3;
    float[] wavePositions;

    Wave(rockstar nico, float x, float y) {
        this.nico = nico;
        this.x = x;
        this.y = y;
        wavePositions = new float[numWaves];
    }

    void update(float soundInput) {
        // Set amplitude based on sound input
        amplitude = soundInput * 0.5f;

        // Update wave positions
        for (int i = 0; i < numWaves; i++) {
            wavePositions[i] = amplitude * PApplet.sin(phase + i * PConstants.TWO_PI / numWaves);
        }

        // Increment phase
        phase += frequency;
    }

    void draw() {
        nico.noFill();
        nico.stroke(255, 0, 0); // Red stroke color
        nico.strokeWeight(2);

        // Apply translation transformation
        nico.pushMatrix();
        nico.translate(x, y);

        // Draw wave using vertices
        nico.beginShape();
        for (int i = 0; i < numWaves; i++) {
            nico.vertex(i * nico.width / numWaves, wavePositions[i]);
        }
        nico.endShape();

        nico.popMatrix();
    }
}
