package algorithm.miniapp.view.analysis;

import java.util.concurrent.RecursiveTask;

import algorithm.miniapp.abstraction.ICommand;

/**
 * 排序Action
 * @author Tao
 */
public class SortAnalysisTask extends RecursiveTask {

    private final ICommand command;

    public SortAnalysisTask(ICommand command){
        this.command = command;
    }

    @Override
    protected Object compute() {
        return command.Execute();
    }

}
