package observer3;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Graphics;


public class OriginalColorPanel extends JPanel implements ChangeListener {
	
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

		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider newValue = (JSlider)e.getSource();
			
			if (newValue != null) {
				if (newValue.getName() == "Hue") {
					currentHue = (float)newValue.getValue()/100;
				} else if (newValue.getName() == "Saturation") {
					currentSaturation = (float)newValue.getValue()/100;
				} else if (newValue.getName() == "Brightness") {
					currentBrightness = (float)newValue.getValue()/100;
				} 
			}
			setColor();
			
		}
		
		public float getHue() {
			return currentHue;
		}
		
		public float getSaturation() {
			return currentSaturation;
		}
		
		public float getBrightness() {
			return currentBrightness;
		}

}
