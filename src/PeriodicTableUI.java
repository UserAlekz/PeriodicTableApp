import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;

import com.amazon.kindle.kindlet.KindletContext;
import com.amazon.kindle.kindlet.event.KindleKeyCodes;
import com.amazon.kindle.kindlet.ui.KBoxLayout;
import com.amazon.kindle.kindlet.ui.KMenu;
import com.amazon.kindle.kindlet.ui.KMenuEvent;
import com.amazon.kindle.kindlet.ui.KMenuItem;
import com.amazon.kindle.kindlet.ui.KMenuListener;
import com.amazon.kindle.kindlet.ui.KPanel;
import com.amazon.kindle.kindlet.ui.KRepaintManager;
import com.amazon.kindle.kindlet.ui.KTextArea;
import com.amazon.kindle.kindlet.ui.image.ImageUtil;

/**
 * User Interface main class:
 * a) it paints/draws the periodic table
 * b) handles key events and menu
 */
public class PeriodicTableUI
implements KMenuListener, ActionListener, KeyListener {
	KindletContext kContext;
	KMenu kMenu;
	String[] sMenu = {"Non-metals", "Metals", "Alkali", "Halogen", "Nobel gas", "Lanthanide", "Actinides", "All/Unselect", /*"Quiz",*/ "History", "About"};
	private PeriodicTableData ptData;
	private PeriodicTableCanvas ptCanvas;
	private int currElementPtr, prevElementPtr, subRowsPtr;
	public KPanel textPanel;
	public KTextArea kText;
	public CardLayout ptPanelsLayout;
	public KPanel ptPanels;
	int UI_ELEMENT_SIZE = 41; // for Kindle DX larger
	
	/**
	 * This is the constructor method, it creates menu, UI panels and graphics canvas.
	 * @param context
	 */
	public PeriodicTableUI(KindletContext context)
	{
		kContext = context;

		kMenu = new KMenu();
		for(int i = 0; i < sMenu.length; i++)
		{
			KMenuItem kMenuItem = new KMenuItem();
			kMenuItem.setLabel(sMenu[i]);
			kMenuItem.setActionCommand(sMenu[i]);
			kMenuItem.addActionListener(this);
			kMenu.add(kMenuItem);
		}
		kMenu.insertSeparator(8);
		kMenu.addMenuListener(this);
		kContext.setMenu(kMenu);
		
		currElementPtr = 0; prevElementPtr = 0;
		ptData = new PeriodicTableData();
		ptCanvas = new PeriodicTableCanvas(this);
		ptCanvas.ptImages[0] = makePTImage(0);
		ptCanvas.ptImages[1] = makePTImage(PeriodicTableData.CATEGORY_NONMETAL);
		ptCanvas.ptImages[2] = makePTImage(PeriodicTableData.CATEGORY_METAL|PeriodicTableData.CATGEORY_TRANSITION_METAL|PeriodicTableData.CATEGORY_METALLOID);
		ptCanvas.ptImages[3] = makePTImage(PeriodicTableData.CATEGORY_ALKALI_METAL|PeriodicTableData.CATEGORY_ALKALINE_EARTH_METAL);
		ptCanvas.ptImages[4] = makePTImage(PeriodicTableData.CATEGORY_HALOGEN);
		ptCanvas.ptImages[5] = makePTImage(PeriodicTableData.CATEGORY_NOBEL_GAS);
		ptCanvas.ptImages[6] = makePTImage(PeriodicTableData.CATEGORY_LANTHANIDE);
		ptCanvas.ptImages[7] = makePTImage(PeriodicTableData.CATEGORY_ACTINIDE);
		ptCanvas.ptImage = ptCanvas.ptImages[0];
		ptCanvas.setFocusable(true);
		ptCanvas.setFocusTraversalKeysEnabled(false);
		ptCanvas.addKeyListener(this);
		ptPanelsLayout = new CardLayout();
		ptPanels = new KPanel(ptPanelsLayout);
		ptPanels.add(ptCanvas, BorderLayout.CENTER);
		//kContext.getRootContainer().add(ptCanvas);
		kText = new KTextArea("Kindle Periodic Table App", "Hint", 300, 20);
		textPanel = new KPanel(new GridLayout(1, 1));
		kText.setEditable(false);
		kText.setFocusable(false);
		textPanel.add(kText);
		textPanel.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KindleKeyCodes.VK_BACK)
				{
					ptPanelsLayout.first(ptPanels);
					ptCanvas.requestFocus();
					kContext.setSubTitle("");
					e.consume();
				}
			}
			public void keyReleased(KeyEvent e) { }
			public void keyTyped(KeyEvent e) { }
		});
		ptPanels.add(textPanel, BorderLayout.CENTER); // NOTE!
		kContext.getRootContainer().add(ptPanels);
		ptPanelsLayout.first(ptPanels);
	}
	
	/**
	 * This method actually displays detailed data about a particular chemical element.
	 * @param elementID
	 */
	void paintData(int elementID)
	{
		kContext.setSubTitle(ptData.Name[elementID]);
		String newLine = "\n";
		StringBuffer str = new StringBuffer();
		str.append("Periodic element: " + ptData.Name[elementID] + " (atomic number: " + (elementID + 1) + ", symbol: " + ptData.Symbol[elementID] + ")");
		str.append(newLine + newLine);
		str.append("Group: " + ptData.Group[elementID] + ", period: " + ptData.Period[elementID]/* + ", block: " + ptData.Props*/);
		str.append(newLine);
		str.append("Element category: " + PeriodicTableData.GetElementCategoryData(ptData.Props[elementID])
				+ newLine + "Atomic weight: " + ptData.Weight[elementID]
				//+ newLine + "electron configuration; electrons per shell"
				+ newLine + "Phase at STP: " + PeriodicTableData.GetElementPhaseData(ptData.Props[elementID])
				+ newLine + "Density: " + ptData.Density[elementID] + " g/L"
				+ newLine + "Melting point: " + ptData.Melt[elementID] + " °K, "
									+ PeriodicTableUtils.K2C(ptData.Melt[elementID]) + " °C, "
									+ PeriodicTableUtils.K2F(ptData.Melt[elementID]) + " °F"
				+ newLine + "Boiling point: " + ptData.Boil[elementID] + " °K, "
									+ PeriodicTableUtils.K2C(ptData.Boil[elementID]) + " °C, "
									+ PeriodicTableUtils.K2F(ptData.Boil[elementID]) + " °F");
		kText.setText(str.toString());
		ptPanelsLayout.next(ptPanels);
		textPanel.requestFocus();
		/*wolfram
		 * basic elemental properties: symbol, atomic number&weight
		 * thermodynamic props: phase at STP, boiling point
		 * material props: density, sound speed, thermal conductivity
		 * electromagnetic: magnetic type, color, refractive index
		 * reactivity: valence, electron affinity, ionization energy
		 * atomic props: term symbol, atomic radius
		 * abundances: universtiy abundance, crust abundance
		 *wikipedia
		 * general props
		 * 	name, symbol, number
		 *  element category
		 *  group, period, block
		 *  atomic weight
		 *  electron configuration
		 *  electrons per shell
		 * physical pros
		 *  phase
		 *  density, liquid density
		 *  melting, boiling, critical point
		 *  heat of fusion, vaporization, heat capacity
		 * atomic props & misc props
		 */
	}
	
	private	int getElementPaintX(int elementID)
	{
		if(ptData.Group[elementID] == 1000 || ptData.Group[elementID] == 2000)
			return 99+subRowsPtr*UI_ELEMENT_SIZE;
		else
			return 17+(ptData.Group[elementID]-1)*UI_ELEMENT_SIZE;
	}
	
	private int getElementPaintY(int elementID)
	{
		if(ptData.Group[elementID] == 1000)
			return 320;
		else if(ptData.Group[elementID] == 2000)
			return 360;
		else
			return 20+(ptData.Period[elementID]-1)*UI_ELEMENT_SIZE;
	}
	
	void paintElement(int elementID, int elementCategory, Graphics grafx, int x, int y)
	{
		grafx.drawRoundRect(x, y, 35, 35, 5, 5);
		if(elementCategory != 0 && (elementCategory & ptData.Props[elementID]) != 0)
			grafx.drawRoundRect(x+1, y+1, 33, 33, 5, 5);
		grafx.drawString(ptData.Symbol[elementID], 5+x, 15+y);
		grafx.drawString(ptData.Z[elementID]+"", 15+x, 30+y);
	}
	
	void paintSelection()
	{
		Graphics grafx = ptCanvas.ptImage.getGraphics();
		int x, y;
		grafx.setColor(Color.WHITE);
		y = getElementPaintY(prevElementPtr);
		x = getElementPaintX(prevElementPtr);
		grafx.fillOval(x+4, y+21, 9, 9);
		ptCanvas.kRepaintManager.addDirtyRegion(ptCanvas, x+4, y+21, 10, 10);
		grafx.setColor(Color.BLACK);
		y = getElementPaintY(currElementPtr);
		x = getElementPaintX(currElementPtr);
		grafx.fillOval(x+4, y+21, 9, 9);
		ptCanvas.kRepaintManager.addDirtyRegion(ptCanvas, x+4, y+21, 10, 10);
		//try {
			//KRepaintManager.paintImmediately(ptCanvas, false);
			ptCanvas.kRepaintManager.paintDirtyRegions(false);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//} catch (InvocationTargetException e) {
		//	e.printStackTrace();
		//}
		prevElementPtr = currElementPtr;
	}

    private Image makePTImage(int elementCategory)
    {
    	Image img = kContext.getRootContainer().createImage(760, 500);
    	Graphics grafx = img.getGraphics();
    	int ptPtr = 0;
		grafx.fillOval(21, 41, 9, 9);	
    	for(int y = 0; y < 7; y++) // period loop
    	{
    		for(int x = 0; x < 18; x++) // group loop
    		{
    			/*if(elementCategory != 0)
    				if((ptData.Props[ptPtr] & elementCategory) != 0)
    					grafx.setColor(Color.BLACK);
    				else
    					grafx.setColor(Color.GRAY);*/
    			if(ptData.Group[ptPtr] == 1000 || ptData.Group[ptPtr] == 2000)
    			{
    				subRowsPtr = 0;
	    			while(ptData.Group[ptPtr] == 1000 || ptData.Group[ptPtr] == 2000)
	    			{
	    				paintElement(ptPtr, elementCategory, grafx, getElementPaintX(ptPtr), getElementPaintY(ptPtr));
	    				ptPtr++;
	    				subRowsPtr++;
	    			}
    			}    			
    			
    			if(ptData.Group[ptPtr] == x+1 && ptData.Period[ptPtr] == y+1)
    			{
    				paintElement(ptPtr, elementCategory, grafx, getElementPaintX(ptPtr), getElementPaintY(ptPtr));
    				ptPtr++;
    			}
    		}
    	}
    	grafx.drawString("Lanthanides", 19, 338);
    	grafx.drawString("Actinides", 19, 375);
    	return img;
    }	

	public void menuCanceled(KMenuEvent e) {
		// TODO Auto-generated method stub

	}

	public void menuDeselected(KMenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void menuSelected(KMenuEvent e) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * This method handles menu commands.
	 */
	public void actionPerformed(ActionEvent e) {
		String cmdStr = e.getActionCommand();
		if(cmdStr.equalsIgnoreCase("History"))
		{
			kContext.setSubTitle("History");
			kText.setText(PeriodicTableData.textHistory);
			ptPanelsLayout.last(ptPanels);
			textPanel.requestFocus();
			return;
		}
		else if(cmdStr.equalsIgnoreCase("About"))
		{
			kContext.setSubTitle("About");
			kText.setText(PeriodicTableData.textAbout);
			ptPanelsLayout.last(ptPanels);
			textPanel.requestFocus();
			return;
		}
		else if(cmdStr.equalsIgnoreCase("Quiz"))
		{
			kContext.setSubTitle("Quiz");
			kText.setText(PeriodicTableData.textQuiz);
			ptPanelsLayout.last(ptPanels);
			textPanel.requestFocus();
			return;
		}
		
		currElementPtr = 0;
		paintSelection();
		if(cmdStr.equalsIgnoreCase(sMenu[0]))
			ptCanvas.ptImage = ptCanvas.ptImages[1];
		else if(cmdStr.equalsIgnoreCase(sMenu[1]))
			ptCanvas.ptImage = ptCanvas.ptImages[2];
		else if(cmdStr.equalsIgnoreCase(sMenu[2]))
			ptCanvas.ptImage = ptCanvas.ptImages[3];
		else if(cmdStr.equalsIgnoreCase(sMenu[3]))
			ptCanvas.ptImage = ptCanvas.ptImages[4];
		else if(cmdStr.equalsIgnoreCase(sMenu[4]))
			ptCanvas.ptImage = ptCanvas.ptImages[5];
		else if(cmdStr.equalsIgnoreCase(sMenu[5]))
			ptCanvas.ptImage = ptCanvas.ptImages[6];
		else if(cmdStr.equalsIgnoreCase(sMenu[6]))
			ptCanvas.ptImage = ptCanvas.ptImages[7];
		else
			ptCanvas.ptImage = ptCanvas.ptImages[0];
		/*if(!ptCanvas.isVisible())
		{
			ptPanelsLayout.first(ptPanels);
			ptCanvas.requestFocus();
		}
		else*/
		kContext.setSubTitle(cmdStr);
		ptCanvas.requestFocus();
		ptPanelsLayout.first(ptPanels);
		ptCanvas.requestFocus();
		paintSelection();
	}

	/**
	 * This method handles Kindle keypad typing.
	 */
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode())
		{
		case KindleKeyCodes.VK_FIVE_WAY_UP : {
			if(ptData.Group[currElementPtr] == 1000)
				currElementPtr = currElementPtr + 46;
			else if(ptData.Group[currElementPtr] == 2000)
				currElementPtr = currElementPtr - 32;
			else if(ptData.Period[currElementPtr] > 1)
			{
				int srchElementPtr = currElementPtr;
				while(srchElementPtr > 0 && ptData.Period[srchElementPtr] > ptData.Period[currElementPtr] - 2)
				{
					srchElementPtr--;
					if(ptData.Group[srchElementPtr] == ptData.Group[currElementPtr]
							&& ptData.Period[srchElementPtr] == ptData.Period[currElementPtr] - 1)
					{
						currElementPtr = srchElementPtr;
						break;
					}
				}
			}
			break; }
		case KindleKeyCodes.VK_FIVE_WAY_DOWN : {
			if(ptData.Group[currElementPtr] == 1000)
				currElementPtr = currElementPtr + 32;
			else if(ptData.Period[currElementPtr] < 7)
			{
				int srchElementPtr = currElementPtr;
				while(srchElementPtr < 118 && ptData.Period[srchElementPtr] < ptData.Period[currElementPtr] + 2)
				{
					srchElementPtr++;
					if(ptData.Group[srchElementPtr] == ptData.Group[currElementPtr]
							&& ptData.Period[srchElementPtr] == ptData.Period[currElementPtr] + 1)
					{
						currElementPtr = srchElementPtr;
						break;
					}
				}
			}
			else if(ptData.Period[currElementPtr] == 7
					&& ptData.Group[currElementPtr] > 2
					&& ptData.Group[currElementPtr] < 17)
			{
				subRowsPtr = ptData.Group[currElementPtr] - 3;
				currElementPtr = currElementPtr - 46;
			}
			break; }
		case KindleKeyCodes.VK_FIVE_WAY_RIGHT : {
			if(ptData.Group[currElementPtr] >= 1000)
			{
				if(subRowsPtr <= 12)
				{
					Graphics grafx = ptCanvas.ptImage.getGraphics();
					grafx.setColor(Color.WHITE);
					int y = getElementPaintY(currElementPtr);
					int x = getElementPaintX(currElementPtr);
					grafx.fillOval(x+4, y+21, 9, 9);
					ptCanvas.kRepaintManager.addDirtyRegion(ptCanvas, x+4, y+21, 10, 10);
					subRowsPtr++;
					currElementPtr++;
				}
			}
			else if(currElementPtr < 117)
				do
					currElementPtr++;
				while(ptData.Group[currElementPtr] >= 1000);
			break; }
		case KindleKeyCodes.VK_FIVE_WAY_LEFT : { 
			if(ptData.Group[currElementPtr] >= 1000)
			{
				if(subRowsPtr > 0)
				{
					Graphics grafx = ptCanvas.ptImage.getGraphics();
					grafx.setColor(Color.WHITE);
					int y = getElementPaintY(currElementPtr);
					int x = getElementPaintX(currElementPtr);
					grafx.fillOval(x+4, y+21, 9, 9);
					ptCanvas.kRepaintManager.addDirtyRegion(ptCanvas, x+4, y+21, 10, 10);
					subRowsPtr--;
					currElementPtr--;
				}
			}
			else if(currElementPtr > 0)
				do
					currElementPtr--;
				while(ptData.Group[currElementPtr] >= 1000);
			break; }
		case KindleKeyCodes.VK_FIVE_WAY_SELECT : {
			paintData(currElementPtr);
			break; }
		case KindleKeyCodes.VK_BACK : {
			//ptPanelsLayout.next(ptPanels);
			break; }
		}
		paintSelection();	
	}

	public void keyReleased(KeyEvent e) {
		//kContext.setSubTitle("KEYreleased");
	}

	public void keyTyped(KeyEvent e) {
		// NOTE: keyTyped is not invoked by Kindle
	}
}
