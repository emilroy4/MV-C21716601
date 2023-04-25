package c21716601;

//import ie.tudublin.Visual;

public class us {
    
    rockstar us;
    float rotation = 0;

    public us(rockstar us)
    {
        this.us = us;
    }

    public void render()
    {
        float[] stars = new float[500];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = us.random(-us.width, us.width);
        }

        us.stroke(4);
        for (int i = 0; i < stars.length; i++) {
            float speed = us.map(us.getSmoothedAmplitude(), 0, 1, 1, 5);
            stars[i] += speed;
            if (stars[i] > us.width) {
                stars[i] = us.random(-us.width, 0);
            }
            us.point(stars[i], us.random(-us.height, us.height));
        }

        us.stroke(0,250,0);
        rotation += us.getAmplitude() / 10f;
        us.rotateX(rotation);
        us.lights();
        us.strokeWeight((float) 0.5);
        us.pushMatrix();
        us.sphere(80);
        us.sphere(150);
        us.popMatrix();
    }


}
