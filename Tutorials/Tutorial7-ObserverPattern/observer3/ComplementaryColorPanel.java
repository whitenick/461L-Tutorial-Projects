package observer3;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ComplementaryColorPanel extends JPanel implements PropertyChangeListener{
	 private Color color;
	 private float currentHue;
	 private float currentSaturation;
	 private float currentBrightness;
	 private Color complementaryColor;

	 public ComplementaryColorPanel(Color initialColor){
		 color = initialColor;
	 }

	 public void setColor(){
		 color = Color.getHSBColor(currentHue, currentSaturation, currentBrightness);
		 
		 
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

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		OriginalColorPanel colorPanel = (OriginalColorPanel)e.getSource();
		currentHue = colorPanel.getHue();
		currentSaturation = colorPanel.getSaturation();
		currentBrightness = colorPanel.getBrightness();
		
		setColor();
		
	}
}
