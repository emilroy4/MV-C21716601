package c21716601;

//import processing.core.PApplet;

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
        nico.translate(nico.width / 2, nico.height / 2, 0); // move origin to center of screen
        nico.rotateZ(angle);

        render();

        angle += 0.01;
    }

    public void render() {
        nico.camera(-200, -200, 200, 0, 0, 0, 0, 0, 1);
        nico.translate(-50, -50, 0); // move to center of screen
        nico.strokeWeight(4);

        float[] b = nico.getSmoothedBands();
        float size = b[2];
        nico.pushMatrix();
        nico.translate(0, 0, size / 2);
        nico.box(size);
        nico.popMatrix();

        nico.camera(-100, 100, 200, 0, 0, 0, 0, 0, 1);
        nico.translate(50, -50, 0); // move to center of screen
        float[] b1 = nico.getSmoothedBands();
        float size1 = b1[4];
        nico.pushMatrix();
        nico.translate(0, 0, size1 / 2);
        nico.box(size1);
        nico.popMatrix();

        nico.camera(0, 0, 200, 0, 0, 0, 0, 1, 0);
        nico.translate(0, 50, 0); // move to center of screen
        float[] b2 = nico.getSmoothedBands();
        float size2 = b2[6];
        nico.pushMatrix();
        nico.translate(0, 0, size2 / 2);
        nico.box(size2);
        nico.popMatrix();

        nico.camera(-200, 0, 100, 0, 0, 0, 0, 1, 0);
        nico.translate(50, 0, 0); // move to center of screen
        float[] b3 = nico.getSmoothedBands();
        float size3 = b3[8];
        nico.pushMatrix();
        nico.translate(0, 0, size3 / 2);
        nico.box(size3);
        nico.popMatrix();

        nico.camera(200, 0, 100, 0, 0, 0, 0, 1, 0);
        nico.translate(-50, 0, 0); // move to center of screen
        float[] b4 = nico.getSmoothedBands();
        float size4 = b4[10];
        nico.pushMatrix();
        nico.translate(0, 0, size4 / 2);
        nico.box(size4);
        nico.popMatrix();
    }

}