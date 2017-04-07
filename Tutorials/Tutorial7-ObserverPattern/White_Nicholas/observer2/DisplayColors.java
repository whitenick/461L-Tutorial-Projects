package observer2;

import javax.swing.*;
import javax.swing.event.*;

import javafx.beans.InvalidationListener;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observer;
import java.awt.Dimension;
import java.awt.Color;
import java.util.Observable;


public class DisplayColors implements ChangeListener {

    public static void main(String[] args) {
	SwingFacade.launch(new DisplayColors().mainPanel(), "Compute Complementary Colors");
    }

    
    protected ArrayList<JPanel> observers;
    protected OriginalColorPanel originalColorPanel;
    protected ComplementaryColorPanel complementaryColorPanel;

    protected JSlider hueSlider;
    protected JSlider saturationSlider;
    protected JSlider brightnessSlider;

    protected JLabel hueValueLabel;
    protected JLabel saturationValueLabel;
    protected JLabel brightnessValueLabel;
    
    protected Color currentColor;
    
    public DisplayColors() {
    	observers = new ArrayList<JPanel>();
    }

    protected JPanel colorsPanel() {
	JPanel p = new JPanel();
	p.setLayout(new GridLayout(1,2));
	originalColorPanel = new OriginalColorPanel(Color.getHSBColor(0,(float).5,(float).5));
	originalColorPanel.setPreferredSize(new Dimension(300, 200));
	p.add(SwingFacade.createTitledPanel("Original Color", originalColorPanel));
	complementaryColorPanel = new ComplementaryColorPanel(Color.getHSBColor((float).5, (float).5, (float).5));
	complementaryColorPanel.setPreferredSize(new Dimension(300, 200));
	p.add(SwingFacade.createTitledPanel("Complementary Color", complementaryColorPanel));
	return p;
    }

    protected JPanel mainPanel() {
	JPanel p = new JPanel();
	p.setLayout(new GridLayout(2,1));
	JPanel colorsPanel = colorsPanel();
	JPanel subP = new JPanel();
	subP.setLayout(new GridLayout(3,1));
	hueSlider = slider();
	hueSlider.setValue(50);
	subP.add(sliderBox("H", hueSlider, hueValueLabel));
	saturationSlider = slider();
	saturationSlider.setValue(50);
	subP.add(sliderBox("S", saturationSlider, saturationValueLabel));
	brightnessSlider = slider();
	brightnessSlider.setValue(50);
	subP.add(sliderBox("B", brightnessSlider, brightnessValueLabel));
	p.add(subP);
	p.add(colorsPanel);
	return p;
    }

    private JSlider slider(){
    	
	JSlider slider = new JSlider();
	// WHAT GOES HERE?
	// You need to make it possible for the app to get the slider values out.
	
	
	
	//Must add new sliders to ChangeListener action. stateChanged will be called and update the remaining 
	//dependent items 
	slider.addChangeListener(this);
	slider.setMajorTickSpacing(10);
	slider.setMinorTickSpacing(1);
	slider.setPaintTicks(true);
	
	
	slider.setValue(slider.getMinimum());
	return slider;
    }

    private Box sliderBox(String sliderLabel, JSlider slider, JLabel valueLabel){
	if(valueLabel == null){
	    valueLabel = new JLabel();
	    valueLabel.setFont(SwingFacade.getStandardFont());
	    valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
	    valueLabel.setForeground(java.awt.Color.black);
	}
	Box b = Box. createHorizontalBox();
	JLabel label = new JLabel(sliderLabel);
	label.setFont(SwingFacade.getStandardFont());
	label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
	label.setForeground(java.awt.Color.black);
	b.add(label);
	b.add(valueLabel);
	b.add(slider);
	b.setPreferredSize(new Dimension(600, 50));
	return b;
    }

//    protected ColorPanel createColorPanel(Color initialColor){
//	ColorPanel colorPanel = new ColorPanel(initialColor);
//	colorPanel.setPreferredSize(new Dimension(300, 200));
//	return colorPanel;
//    }


    public void stateChanged(ChangeEvent e){
	if(hueSlider != null && saturationSlider != null && brightnessSlider != null){
	    float newHue = (float)hueSlider.getValue()/100;
	    float newSaturation = (float)saturationSlider.getValue()/100;
	    float newBrightness = (float)brightnessSlider.getValue()/100;
	    currentColor = Color.getHSBColor(newHue, newSaturation, newBrightness);
	    
	    notifyListeners(newHue, newSaturation, newBrightness);
	    
	    //float complementaryHue = newHue - (float)0.5;
//	    if(complementaryHue < 0){
//		complementaryHue = complementaryHue + 1;
//	    }
//	    Color complementaryColor = Color.getHSBColor(complementaryHue, newSaturation, newBrightness);
//	    
//	    // WHAT GOES HERE?
//	    // You need to update the two color panels with the appropriate colors
//	    originalColorPanel.setColor(newHue, newSaturation, newBrightness);
//	    complementaryColorPanel.setColor(complementaryColor);
	    

	}
    }

	
	public void addListener(JPanel arg0) {
		observers.add(arg0);
		
	}

	public void removeListener(JPanel arg0) {
		int index = observers.indexOf(arg0);
		if(index >= 0) {
			observers.remove(index);
		}
		
	}
	
	public void notifyListeners(float newHue, float newSaturation, float newBrightness) {
		originalColorPanel.updateColor(newHue, newSaturation, newBrightness);
		complementaryColorPanel.updateColor(newHue, newSaturation, newBrightness);
	}
}
    
