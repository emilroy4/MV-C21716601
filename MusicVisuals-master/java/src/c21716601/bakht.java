package c21716601;

import processing.core.PApplet;

public class bakht {
    rockstar bakht;

    public bakht(rockstar bakht)
    {
        this.bakht = bakht;
    }

    public void render()
    {
        bakht.noFill();
        bakht.camera(0, 100, 200, 0, 0, 0, 1, 0, 0);
        bakht.translate(0, 0, 0);
        bakht.strokeWeight(4);

        float[] b = bakht.getSmoothedBands();
        bakht.stroke(150, 250, 130);
        float size = b[2];
        bakht.circle(0, 0, size);


        bakht.noFill();
        bakht.camera(0, -100, 200, 0, 0, 0, 5, 0, 0);
        bakht.translate(0, 0, 0);
        bakht.strokeWeight(4);

        float[] b1 = bakht.getSmoothedBands();
        bakht.stroke(150, 250, 130);
        float size1 = b1[2];
        bakht.circle(0, 0, size1);
        

        bakht.noFill();
        bakht.camera(0, 0, 200, 0, 0, 0, 5, 0, 0);
        bakht.translate(0, 0, 0);
        bakht.strokeWeight(2);
        
        float[] b2 = bakht.getSmoothedBands();
        for(int i=0; i<b2.length ; i++)
        {
            float c = PApplet.map(i, 255, b2.length, 50, 150);
            bakht.stroke(c, 0, 102);
            float s = b2[i];
            bakht.pushMatrix();
            bakht.circle(0, 0, s);
            bakht.popMatrix();
        }
    }
}
