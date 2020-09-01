package algorithm.miniapp.view.analysis;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import algorithm.miniapp.Enum.SortEnum;
import algorithm.miniapp.abstraction.ICommand;
import algorithm.miniapp.abstraction.SortMethod;
import algorithm.miniapp.view.manoeuvre.Environment;
import algorithm.miniapp.view.screens.SortingAnalysisScreen;

/**
 * 右侧：画线面板
 */
public class LinePanel extends JPanel {
    private int X_Start;
    private int Y_Start;
    private int Y_HEIGHT = 8;
    private int X_WIDTH = 12;
    private static final int plies = SortEnum.values().length;
    private SortEnum[] sortType;
    private Environment<Map<String, Double[]>> environment;
    private MyCanvas myCanvas;
    private ProgressBarPanel progressPanel;

    public LinePanel(SortingAnalysisScreen frame) {
        this.myCanvas = frame.getTrendChartCanvas();
        this.progressPanel = frame.getProgrees();
        // 移除之前计算的值
        //初始化
        this.environment = new Environment<>();
        this.sortType = SortEnum.values();

        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new GridLayout(plies, 1, 0, Y_HEIGHT));

        //获取画线位置
        this.X_Start = this.getX() + X_WIDTH;
        this.Y_Start = this.getY() + Y_HEIGHT;
        final ConcurrentHashMap<String, Double[]> cacheMap = SortCommand.getCacheMap();
        for (SortEnum sortEnum : sortType) {
            SortMethod sortMethod = sortEnum.getSortMethod();
            LineButton lineButton = new LineButton(sortEnum.getCnName(),sortMethod);
            Color color = sortEnum.getSortMethod().lineColor().getColor();
            lineButton.setBackground(color);
            lineButton.setBorder(BorderFactory.createEmptyBorder());
            add(lineButton);
            add(new LineCanve(color,sortMethod.efficiency()));
            lineButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    LineButton lButton  = (LineButton)evt.getSource();
                    String name = lButton.sortMethod.methodName();
                    boolean running = progressPanel.isRunning(name);
                    if (running){
                        JOptionPane.showMessageDialog(frame, "The execution queue is running !", "warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    // 右键取消
                    if (evt.isMetaDown()){
                        cacheMap.remove(name);
                        myCanvas.paint();
                    }else{
                        try {
                            RunProgressBar addBar = progressPanel.addBar(name);
                            if (addBar == null) {
                                JOptionPane.showMessageDialog(frame, progressPanel.isFull() ?
                                        "The execution queue is full ! "
                                        : "The execution queue is running !", "warning", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            // 移除之前计算的值
                            cacheMap.remove(name);
                            doSort(new DoSortTask(name, frame), lButton);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    /**
     * 线程安全的执行方法
     * @param command
     * @param lineButton
     */
    private SwingWorker doSort(ICommand command,LineButton lineButton){
        SwingWorker<Map, Void> swingWorker = new SwingWorker<Map,Void>() {
            @Override
            protected Map doInBackground(){
                environment.setCommand(command);
                return environment.invoke();
            }

            @Override
            public void done() {
                try {
                    String name = lineButton.sortMethod.methodName();
                    Double[] times = SortCommand.getCacheMap().get(name);
                    progressPanel.updateBar(name,times);
                    progressPanel.remove(name);
                    myCanvas.paint();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        swingWorker.execute();
        return swingWorker;
    }

    /**
     * 右侧按钮控制排序启动
     */
    private class LineButton extends JButton{
        private SortMethod sortMethod;

        public LineButton(String text,SortMethod sortMethod) {
            super(text);
            this.sortMethod = sortMethod;
        }
    }

    /**
     * 线的画布
     */
    class LineCanve extends Canvas {
        private Color color;
        private String slow;

        public LineCanve(Color linecoler,String slow) {
            //获取颜色
            this.color = linecoler;
            this.slow = slow;
        }

        /**
         * /画线
         */
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            //绘图提示-消除锯齿
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // 轴线粗度
            g2D.setStroke(new BasicStroke(Float.parseFloat("2.0F")));

            //对排序绘制
            g.setColor(color);
            //绘制直线，通过循环，将所有的点连线
            g2D.drawLine(X_Start, Y_Start, X_Start + 80, Y_Start);
            // 增加提示
            //g2D.drawString(slow,X_Start + 90, Y_Start);
        }
    }
}