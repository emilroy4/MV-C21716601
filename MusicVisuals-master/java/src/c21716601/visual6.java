package c21716601;

import processing.core.PApplet;

public class visual6 {

    rockstar rs;
    private float hoopSize = 0.0f;
    private float hoopOpacity = 0.0f;
    private boolean createNewHoop = false;
    private float newHoopOpacity = 0.0f;

    public visual6(rockstar rs) {
        this.rs = rs;
    }

    public void render() {
        rs.background(0);

        float amplitude = rs.getSmoothedAmplitude();
        float colorVal = rs.map(amplitude, 0, 1, 0, 255);

        if (hoopSize >= 600 && !createNewHoop) {
            // Start creating a new hoop if the current one is half the target size
            createNewHoop = true;
            newHoopOpacity = hoopOpacity;
        }

        if (hoopSize < 1000) {
            // Expand the current hoop
            hoopSize += amplitude * 20;
            hoopOpacity = rs.map(amplitude, 0, 1, 0, 255);
        } else if (createNewHoop) {
            // Create a new hoop when the current one reaches the target size
            hoopSize = 0;
            hoopOpacity = 0;
            createNewHoop = false;
        }
            
        rs.strokeWeight(10);
        rs.stroke(colorVal, 255, 255, hoopOpacity);
        rs.noFill();
        rs.ellipse(rs.width / 2, rs.height / 2, hoopSize, hoopSize);
        if (createNewHoop) {
            // Draw the new hoop as a faint circle
            rs.stroke(colorVal, 255, 255, newHoopOpacity / 2);
            rs.ellipse(rs.width / 2, rs.height / 2, hoopSize / 2, hoopSize / 2);
        }
    }
}
