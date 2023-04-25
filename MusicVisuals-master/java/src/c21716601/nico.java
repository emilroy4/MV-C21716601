package c21716601;

import processing.core.PApplet;

public class nico {
    

    rockstar nico;

    public nico(rockstar nico)
    {
        this.nico = nico;
    }

    public void render()
    {
        nico.noFill();
        nico.camera(0, 100, 200, 0, 0, 0, 1, 0, 0);
        nico.translate(0, 0, 0);
        nico.strokeWeight(4);

        float[] b = nico.getSmoothedBands();
        nico.stroke(150, 250, 130);
        float size = b[2];
        nico.circle(0, 0, size);


        nico.noFill();
        nico.camera(0, -100, 200, 0, 0, 0, 5, 0, 0);
        nico.translate(0, 0, 0);
        nico.strokeWeight(4);

        float[] b1 = nico.getSmoothedBands();
        nico.stroke(150, 250, 130);
        float size1 = b1[2];
        nico.circle(0, 0, size1);
        

        nico.noFill();
        nico.camera(0, 0, 200, 0, 0, 0, 5, 0, 0);
        nico.translate(0, 0, 0);
        nico.strokeWeight(2);
        
        float[] b2 = nico.getSmoothedBands();
        for(int i=0; i<b2.length ; i++)
        {
            float c = PApplet.map(i, 255, b2.length, 50, 150);
            nico.stroke(c, 0, 102);
            float s = b2[i];
            nico.pushMatrix();
            nico.circle(0, 0, s);
            nico.popMatrix();
        }
    }

}
