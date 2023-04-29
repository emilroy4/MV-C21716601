package c21716601;

import processing.core.PApplet;

public class visual6 {

    private rockstar rs;
    private float[] bands;
    private float angle = 0.0f;

    public visual6(rockstar rs) {
        this.rs = rs;
    }

    public void render() {
        try {
            rs.background(0);
            bands = rs.getSmoothedBands();
            float mappedValue = rs.map(bands[2], 0, 255, 0, rs.width / 2);

            rs.pushMatrix();
            rs.translate(rs.width / 2, rs.height / 2);

            // Draw the face
            float faceSize = rs.width / 3;
            rs.stroke(255);
            rs.strokeWeight(3);
            rs.noFill();
            rs.ellipse(0, 0, faceSize, faceSize);

            // Draw the eyes
            float eyeSize = faceSize / 8;
            rs.fill(255);
            rs.noStroke();
            rs.ellipse(-faceSize / 4, -faceSize / 8, eyeSize, eyeSize);
            rs.ellipse(faceSize / 4, -faceSize / 8, eyeSize, eyeSize);

            // Draw the mouth
            float mouthSize = faceSize / 4;
            float mouthOpen = rs.map(bands[6], 0, 255, 0, 1);
            float mouthAngle = rs.map(mouthOpen, 0, 1, 0, PApplet.PI / 2);
            rs.fill(255);
            rs.noStroke();
            rs.arc(0, faceSize / 8, mouthSize, mouthSize, -mouthAngle, mouthAngle, PApplet.OPEN);

            rs.popMatrix();
            angle += 0.01f;
        } catch (Exception e) {
            System.out.println("Exception in Visual6: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
