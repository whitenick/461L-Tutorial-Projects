package observer2;

import javax.swing.JPanel;


import java.awt.Color;
import java.awt.Graphics;


public class OriginalColorPanel extends JPanel {
	
	 private Color color;
	 //private JSlider hueSlider;
	 private float currentHue;
	 private float currentSaturation;
	 private float currentBrightness;

	    public OriginalColorPanel(Color initialColor){
	    	this.color = initialColor;
	    }

	    public void setColor(){
	   
		this.color = Color.getHSBColor(currentHue, currentSaturation, currentBrightness);
		repaint();
	    }

	    protected void paintComponent(Graphics g){
		this.setBackground(color);
		super.paintComponent(g);
	    }

		
		public void updateColor(float newHue, float newSaturation, float newBrightness) {
			currentBrightness = newBrightness;
			currentHue = newHue;
			currentSaturation = newSaturation;
			
			this.setColor();
			
		}

}
