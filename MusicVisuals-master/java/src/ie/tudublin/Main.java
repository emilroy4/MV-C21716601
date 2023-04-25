package ie.tudublin;

import c21716601.*;
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new rockstar());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}