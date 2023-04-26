package c21716601;

import ie.tudublin.*;
import ie.tudublin.Visual;

public class rockstar extends Visual {

    
    emil er;
    bakht bakht;
    nico nico;
    us us;
    us1 us1;
    int v;

    public void settings()
    {
        size(1000, 800, P3D);

    }


    public void setup()
    {
        startMinim();

        loadAudio("immortal.mp3");

        er = new emil(this);
        bakht = new bakht(this);
        nico = new nico(this);
        us = new us(this);
        us1 = new us1(this);

        colorMode(RGB);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }

        if (keyCode >= '0' && keyCode <= '7') 
        {
            v = keyCode - '0';
        }
    }

    public void draw()
    {
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        } 
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();

        switch(v)
        {
            case 1:
            {
                er.render();
                break;
            }

            case 2:
            {
                bakht.render();
                break;
            }

            case 3:
            {
                
                nico.render();
                break;
            }

            case 4:
            {
                er.render(); 
                nico.render();

                break;
            }

            case 5:
            {
                nico.render();
                us1.render();
                us.render();
                break;
            }

        }
    }

}
