package c21716601;

import processing.core.*;

public class emil 
{
    rockstar er;
    float rotation = 0;

    public emil(rockstar er)
    {
        this.er = er;
    }

    public void render()
    {
        if (er.frameCount % 120 < 60) {
            er.background(200, 0, 0); // dark red
          } else {
            er.background(0); // black
          }
        er.noFill();
        rotation += er.getAmplitude() / 3f; 
        er.rotateX(rotation);
        er.strokeWeight(2);

        float[] b = er.getSmoothedBands();
        for(int i=0; i<b.length ; i++)
        {
            float colour = PApplet.map(i, 0, b.length, 0, 70);
            er.stroke(0, 0, 255);
            er.stroke(255, 255, 255);
            er.pushMatrix();
            
            er.box(colour);
            
            er.popMatrix();
        }
    }
}
