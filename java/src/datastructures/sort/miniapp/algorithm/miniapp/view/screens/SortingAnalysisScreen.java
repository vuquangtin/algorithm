package algorithm.miniapp.view.screens;


/**
 * 绘图
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import algorithm.miniapp.MiniApp;
import algorithm.miniapp.Enum.LineColorEnum;
import algorithm.miniapp.view.Screen;
import algorithm.miniapp.view.analysis.ButtonPanel;
import algorithm.miniapp.view.analysis.LinePanel;
import algorithm.miniapp.view.analysis.MyCanvas;
import algorithm.miniapp.view.analysis.ProgressBarPanel;

/**
 *    选择具体的排序方法
 *    计算排序的时间
 * @author Tao
 */
public class SortingAnalysisScreen extends Screen {

    /**
     * /主坐标图
     */
    private MyCanvas trendChartCanvas;

    private JPanel centerPanel;
    /**
     * 辅助栏面板
     */
    private LinePanel line;
    private ButtonPanel button;
    private JPanel ButtonAndLine;
    private JPanel backPanel;
    private JButton back;
    private JButton about;
    private ProgressBarPanel progrees;

    private MiniApp miniApp;

    public static final int DEFAULT_WIDTH = 1400;
    public static final int DEFAULT_HEIGHT = 700;
    public static final String BACK = "back";
    public static final String ABOUT = "about";

    /**
     * /排序线的颜色
     */
    private static final LineColorEnum[] lineColor = LineColorEnum.values();

    public SortingAnalysisScreen(MiniApp miniApp) {
        super(miniApp);
        this.setLayout(new BorderLayout());
        this.miniApp = miniApp;

        centerPanel = new JPanel();
        backPanel = new JPanel();
        //添加主画布到中心
        trendChartCanvas = new MyCanvas(this);
        ButtonAndLine = new JPanel();
        progrees = new ProgressBarPanel();
        button = new ButtonPanel();
        line = new LinePanel(this);
        back = new JButton(BACK);
        about = new JButton(ABOUT);
        backPanel.setLayout(new GridLayout(2,1,0,10));
        backPanel.add(about);
        backPanel.add(back);
        backPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        centerPanel.setLayout(new BorderLayout(0, 10));
        centerPanel.add(trendChartCanvas, BorderLayout.CENTER);
        centerPanel.add(progrees, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);

        //边侧辅助面板
        ButtonAndLine.setBorder(BorderFactory.createLineBorder(Color.RED));
        ButtonAndLine.setLayout(new BorderLayout(0, 5));
        ButtonAndLine.add(button, BorderLayout.NORTH);
        ButtonAndLine.add(line, BorderLayout.CENTER);
        ButtonAndLine.add(backPanel,BorderLayout.SOUTH);
        this.add(ButtonAndLine, BorderLayout.EAST);
        about.addActionListener(e->
            JOptionPane.showMessageDialog(null,
                    "left mouse button click sort execution, right click cancel display .",
                    "about", JOptionPane.INFORMATION_MESSAGE)
        );
        back.addActionListener(e->app.popScreen());
        this.setVisible(true);
    }

    public ProgressBarPanel getProgrees() {
        return progrees;
    }

    public MyCanvas getTrendChartCanvas() {
        return trendChartCanvas;
    }

    /**
     * /获取线的颜色
     */
    public static LineColorEnum[] getLineColor() {
        return lineColor;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }

    @Override
    public void onOpen() {

    }
}
