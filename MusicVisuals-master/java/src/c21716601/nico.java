package c21716601;

import processing.core.PApplet;

public class nico {

    rockstar nico;

    public nico(rockstar nico) {
        this.nico = nico;
    }

    float angle = 0;

    public void setup() {
        nico.noFill();
        nico.stroke(150, 250, 130);
    }

    public void draw() {
        nico.background(0);
        nico.translate(nico.width / 2, nico.height / 2, 0);
        nico.rotateZ(angle);

        render();

        angle += 0.01;
    }

    public void render() {
        nico.camera(-200, -200, 200, 0, 0, 0, 0, 0, 1);
        nico.translate(-100, -100, 0);
        nico.strokeWeight(4);

        float[] b = nico.getSmoothedBands();
        float size = b[2];
        nico.pushMatrix();
        nico.translate(0, 0, size / 2);
        nico.box(size);
        nico.popMatrix();

        nico.camera(0, 0, 200, 0, 0, 0, 0, -1, 0);
        nico.translate(-100, -100, 0);
        nico.strokeWeight(4);

        float[] b1 = nico.getSmoothedBands();
        float size1 = b1[2];
        nico.pushMatrix();
        nico.translate(0, 0, size1 / 2);
        nico.box(size1);
        nico.popMatrix();

        nico.camera(200, -200, 200, 0, 0, 0, 0, 0, 1);
        nico.translate(-100, -100, 0);
        nico.strokeWeight(2);

        float[] b2 = nico.getSmoothedBands();
        for (int i = 0; i < b2.length; i++) {
            float c = nico.map(i, 255, b2.length, 50, 150);
            nico.stroke(c, 0, 102);
            float s = b2[i];
            nico.pushMatrix();
            nico.translate(0, 0, s / 2);
            nico.box(s);
            nico.popMatrix();
        }
    }

}