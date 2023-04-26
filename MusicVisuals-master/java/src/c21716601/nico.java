package c21716601;

import processing.core.PApplet;

public class nico {

    rockstar nico;

    public nico(rockstar nico) {
        this.nico = nico;
    }

    public float rotationAngle = 0.0f;
    public float rotationAngle1 = 0.0f;

    public void render() {


          // set background color
  if (nico.frameCount % 120 < 60) {
    nico.background(0, 20, 0); // dark green
  } else {
    nico.background(0); // black
  }
  
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
        nico.beginShape();
        for (float angle = 0; angle < 360; angle += 10) {
            float x = PApplet.cos(PApplet.radians(angle)) * size / 2;
            float y = PApplet.sin(PApplet.radians(angle)) * size / 2;
            nico.curveVertex(x, y, 0);
        }
        nico.endShape();
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
        nico.beginShape();
            for (float angle = 0; angle < 360; angle += 10) {
                float x = PApplet.cos(PApplet.radians(angle)) * size1 / 2;
                float y = PApplet.sin(PApplet.radians(angle)) * size1 / 2;
                nico.curveVertex(x, y, 0);
            }
            nico.endShape();
        nico.popMatrix();

        nico.noFill();
        nico.camera(0, 0, 400, 0, 0, 0, 5, 0, 0);
        nico.translate(0, 0, 0);
        nico.strokeWeight(2);

        float[] b2 = nico.getSmoothedBands();
        for (int i = 0; i < b2.length; i++) {
            float c = PApplet.map(i, 255, b2.length, 50, 150);
            nico.stroke(0, 0, 255);
            float s = b2[i];

            // Apply rotation transformation
            nico.pushMatrix();
            nico.rotateZ(rotationAngle1);
            nico.beginShape();
            for (float angle = 0; angle < 360; angle += 10) {
                float x = PApplet.cos(PApplet.radians(angle)) * size1 / 2;
                float y = PApplet.sin(PApplet.radians(angle)) * size1 / 2;
                nico.curveVertex(x, y, 0);
            }
            nico.endShape();
            nico.popMatrix();

        }

        nico.stroke(153, 204, 255); // Baby blue stroke color

        float numCurves = 10; // number of curves to draw
        float curveHeight = size / numCurves; // height of each curve
        
        for (int j = 0; j < numCurves; j++) {
          float z = -size / 2 + j * curveHeight; // z position of the current curve
          
          nico.beginShape();
          for (float i = -nico.width / 2; i < nico.width / 2; i += 20) { // increase the interval between the points
              float y = nico.map(nico.sin(i * 0.005f + nico.frameCount * 0.05f), -1, 1, -nico.height / 4,
                      nico.height / 4); // reduce the frequency of the sine function
              nico.curveVertex(i, y, z); // Use curveVertex to create waves
          }
          nico.endShape();
        }
        

        nico.stroke(153, 204, 255); // Baby blue stroke color

        nico.beginShape();
        for (float i = -nico.width / 2; i < nico.width / 2; i += 20) { // increase the interval between the points
            float y = nico.map(nico.sin(i * 0.005f + nico.frameCount * 0.05f), -1, 1, -nico.height / 4,
                    nico.height / 4); // reduce the frequency of the sine function
            nico.curveVertex(i, y, -size / 2); // Use curveVertex to create waves
        }
        nico.endShape();

        // Increment rotation angle
        rotationAngle += 0.01f;
        rotationAngle1 -= 0.01f;
    }

}