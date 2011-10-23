import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Transparency;

import com.amazon.kindle.kindlet.event.KindleKeyCodes;
import com.amazon.kindle.kindlet.ui.KComponent;
import com.amazon.kindle.kindlet.ui.KRepaintManager;
import com.amazon.kindle.kindlet.ui.image.ImageUtil;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class PeriodicTableCanvas extends KComponent/*Component*/
	//implements ComponentListener
{
	//private BufferedImage ptImg;
	//private Graphics2D imgGrafx;
	public KRepaintManager kRepaintManager;
	public Image ptImage;
	public Image []ptImages;
	private PeriodicTableUI ptUI;

	public PeriodicTableCanvas(PeriodicTableUI ui)
	{	// super();
		ptImages = new Image[8];
		ptUI = ui;
		//ptImg = ImageUtil.createCompatibleImage(HEIGHT, WIDTH, Transparency.OPAQUE);
		//imgGrafx = ptImg.createGraphics();
		kRepaintManager = KRepaintManager.currentManager(this);
	}
	
	public void paint(Graphics g)
	{
		if(!ptUI.kMenu.isVisible()) //!this.hasFocus()) && getFocusUI)
		{
			this.requestFocus();
			//getFocusUI = false;
		}
		g.drawImage(ptImage, 0, 0, ptImage.getWidth(null), ptImage.getHeight(null), null);
	}

	/*public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentShown(ComponentEvent e) {
		//this.requestFocus();
		//getFocusUI = true;
		//this.validate();
	}*/
}
