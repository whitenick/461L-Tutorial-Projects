package observer2;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class ComplementaryColorPanel extends JPanel{
	 private Color color;
	 private float currentHue;
	 private float currentSaturation;
	 private float currentBrightness;
	 private Color complementaryColor;

	 public ComplementaryColorPanel(Color initialColor){
		 this.color = initialColor;
	 }

	 public void setColor(){
		 this.color = Color.getHSBColor(currentHue, currentSaturation, currentBrightness);
		 
		 
		 float complementaryHue = currentHue - (float)0.5;
		 if(complementaryHue < 0){
			complementaryHue = complementaryHue + 1;
		    }
		 complementaryColor = Color.getHSBColor(complementaryHue, currentSaturation, currentBrightness);
		 repaint();
	 }

	 protected void paintComponent(Graphics g){
		 this.setBackground(complementaryColor);
		 super.paintComponent(g);
	 }
	 
	 public void updateColor(float newHue, float newSaturation, float newBrightness) {
		 this.currentHue = newHue;
		 this.currentBrightness = newBrightness;
		 this.currentSaturation = newSaturation;
		 this.setColor();
		 
	 }
}
