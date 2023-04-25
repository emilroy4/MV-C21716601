package c21716601;

import processing.core.PApplet;
//import ie.tudublin.Visual;

public class emil {
    
    rockstar emil;

    public emil(rockstar emil)
    {
        this.emil = emil;
    }

    public void render()
    {
        emil.noFill();
        emil.camera(0, 100, 200, 0, 0, 0, 1, 0, 0);
        emil.translate(0, 0, 0);
        emil.strokeWeight(4);

        float[] b = emil.getSmoothedBands();
        emil.stroke(150, 250, 130);
        float size = b[2];
        emil.circle(0, 0, size);


        emil.noFill();
        emil.camera(0, -100, 200, 0, 0, 0, 5, 0, 0);
        emil.translate(0, 0, 0);
        emil.strokeWeight(4);

        float[] b1 = emil.getSmoothedBands();
        emil.stroke(150, 250, 130);
        float size1 = b1[2];
        emil.circle(0, 0, size1);
        

        emil.noFill();
        emil.camera(0, 0, 200, 0, 0, 0, 5, 0, 0);
        emil.translate(0, 0, 0);
        emil.strokeWeight(2);
        
        float[] b2 = emil.getSmoothedBands();
        for(int i=0; i<b2.length ; i++)
        {
            float c = PApplet.map(i, 255, b2.length, 50, 150);
            emil.stroke(c, 0, 102);
            float s = b2[i];
            emil.pushMatrix();
            emil.circle(0, 0, s);
            emil.popMatrix();
        }
    }

}
