package c21716601;

import processing.core.PApplet;


public class bakht {
    rockstar bakht;

    public bakht(rockstar bakht)
    {
        this.bakht = bakht;
    }

    public void render() {
        
        bakht.background(0); // set the background to black
        
        // draw the circles
        bakht.noFill();
        bakht.camera(0, 100, 200, 0, 0, 0, 1, 0, 0);
        bakht.translate(0, 0, 0);
        bakht.strokeWeight(4);
    
        float[] b = bakht.getSmoothedBands();
        bakht.stroke(100, 200, 100);
        float size = b[2];
        bakht.circle(0, 0, size);
    
    
        bakht.noFill();
        bakht.camera(0, -100, 200, 0, 0, 0, 5, 0, 0);
        bakht.translate(0, 0, 0);
        bakht.strokeWeight(4);
    
        float[] b1 = bakht.getSmoothedBands();
        bakht.stroke(100, 200, 100);
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
            if(i == 2){
                bakht.stroke(0, 0, 200); // set stroke color to blue for band index 2
            }
            else{
                bakht.stroke(c, 0, 90); // set stroke color for other bands
            }
            float s = b2[i];
            bakht.pushMatrix();
            bakht.circle(0, 0, s);
            bakht.popMatrix();
        }
        if (bakht.frameCount % 60 == 0){ // every 60 frames
            bakht.stroke(255); // set stroke color to white
        }
    


 
     
// draw the circles
bakht.noFill();
bakht.camera(0, 100, 200, 0, 0, 0, 1, 0, 0);
bakht.translate(0, 0, 0);
bakht.strokeWeight(4);

// Draw the middle white circle
bakht.stroke(255);
bakht.fill(255);
bakht.circle(0, 0, 20);

bakht.stroke(255, 0, 0); // set stroke color to red
 bakht.fill(255, 0, 0); // set fill color to red
 bakht.circle(0, 0, 10);


// Calculate the position of the three circles around the center circle
float angle = bakht.radians(bakht.frameCount * 2);
float[] x = new float[4];
float[] y = new float[4];
for (int i = 0; i < 4; i++) {
    x[i] = 60 * bakht.cos(angle + i * bakht.radians(120));
    y[i] = 60 * bakht.sin(angle + i * bakht.radians(120));
}

// Draw the three white circles
for (int i = 0; i < 4; i++) {
    bakht.stroke(255);
    bakht.fill(255);
    bakht.circle(x[i], y[i], 20);

 // Draw a solid red circle inside the white circle
 bakht.stroke(255, 0, 0); // set stroke color to red
 bakht.fill(255, 0, 0); // set fill color to red
 bakht.circle(x[i], y[i], 10); // draw the red circle at the same position as the white circle



}




}




}