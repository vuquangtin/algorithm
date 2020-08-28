package algorithm.miniapp.view.manoeuvre;

import algorithm.miniapp.abstraction.ICommand;


/**
 * 环境角色
 * @author Tao
 */
public class Environment<T> {

    /**
     * 维护一个目标对象
     */
    private ICommand<T> command;

    private long start = 0;
    private long end = 0;
    public Environment(){}
    public Environment(ICommand<T> command){
        this.command = command;
    }

    public ICommand getCommand() {
        return command;
    }

    public void setCommand(ICommand<T> command) {
        this.command = command;
    }

    private void init(){
        start = 0;
        end = 0;
    }

    /**
     * 执行排序方法
     */
    public T invoke(){
        // 初始化
        init();
        start = System.currentTimeMillis();
        T execute = command.Execute();
        end = System.currentTimeMillis();
        return execute;
    }

    /**
     * 获取执行时间 ms
     *
     * @return
     */
    private long getTime() {
        return System.currentTimeMillis() - start;
    }

    /**
     * 获取总共执行时间 ms
     *
     * @return
     */
    public long costTime() {
        if (end == 0){
//            throw new RuntimeException("this algorithms is Running!");
            return getTime();
        }
        return end - start;
    }
}
