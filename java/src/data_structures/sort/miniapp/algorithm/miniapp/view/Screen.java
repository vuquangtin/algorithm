package algorithm.miniapp.view;


import java.awt.Dimension;

import javax.swing.JPanel;

import algorithm.miniapp.MiniApp;

/**
 * @author Tao
 */
public abstract class Screen extends JPanel {
    protected MiniApp app;
    
    public Screen(MiniApp app) {
        this.app = app;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MiniApp.WIN_WIDTH, MiniApp.WIN_HEIGHT);
    }
    
    public abstract void onOpen();
}
