import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import com.amazon.kindle.kindlet.AbstractKindlet;
import com.amazon.kindle.kindlet.KindletContext;
import com.amazon.kindle.kindlet.ui.KButton;
import com.amazon.kindle.kindlet.ui.KImage;
import com.amazon.kindle.kindlet.ui.KLabel;
import com.amazon.kindle.kindlet.ui.KOptionPane;
import com.amazon.kindle.kindlet.ui.KTextComponent;
import com.amazon.kindle.kindlet.ui.KindleOrientation;
import com.amazon.kindle.kindlet.ui.OrientationController;

/**
 * This is the main Kindlet class
 */
public class PTKindlet extends AbstractKindlet {
	PeriodicTableUI ptUI;
	//private int screenW, screenH;
	private KindletContext kContext;
	private OrientationController orientCntl;
	
    public void create(final KindletContext context) {
    	kContext = context;
        orientCntl = kContext.getOrientationController();
        orientCntl.lockOrientation(KindleOrientation.LANDSCAPE);
        //screenH = kContext.getRootContainer().getHeight();
        //screenW = kContext.getRootContainer().getWidth();
        //GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
        ptUI = new PeriodicTableUI(context);
    }
    
    public void start() {
        // TODO Auto-generated method stub
    }    

    public void stop() {
        // TODO Auto-generated method stub
    }    

    public void destroy() {
        // TODO Auto-generated method stub
    }
}
