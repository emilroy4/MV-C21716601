package c21716601;

import processing.core.PApplet;
//import ie.tudublin.Visual;

public class us {
    
    rockstar us;

    public us(rockstar us)
    {
        this.us = us;
    }

    public void render()
    {
        us.noFill();
        us.camera(0, 100, 200, 0, 0, 0, 1, 0, 0);
        us.translate(0, 0, 0);
        us.strokeWeight(4);

        float[] b = us.getSmoothedBands();
        us.stroke(150, 250, 130);
        float size = b[2];
        us.circle(0, 0, size);


        us.noFill();
        us.camera(0, -100, 200, 0, 0, 0, 5, 0, 0);
        us.translate(0, 0, 0);
        us.strokeWeight(4);

        float[] b1 = us.getSmoothedBands();
        us.stroke(150, 250, 130);
        float size1 = b1[2];
        us.circle(0, 0, size1);
        

        us.noFill();
        us.camera(0, 0, 200, 0, 0, 0, 5, 0, 0);
        us.translate(0, 0, 0);
        us.strokeWeight(2);
        
        float[] b2 = us.getSmoothedBands();
        for(int i=0; i<b2.length ; i++)
        {
            float c = PApplet.map(i, 255, b2.length, 50, 150);
            us.stroke(c, 0, 102);
            float s = b2[i];
            us.pushMatrix();
            us.circle(0, 0, s);
            us.popMatrix();
        }
    }

}
