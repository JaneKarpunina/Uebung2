import java.util.Arrays;

public class ThreadLister {

    static String allThreadsToString() {

        ThreadGroup root = getRoot(Thread.currentThread().getThreadGroup());
        Thread[] threadList = new Thread[root.activeCount()];
        root.enumerate(threadList);
        StringBuffer returnString = new StringBuffer();
        Arrays.stream(threadList).forEach(e -> {
            ThreadGroup threadGroup = e.getThreadGroup();
            returnString.append("ThreadGroup Name: ")
                    .append(threadGroup.getName())
                    .append(",\n maximale Priorität der Gruppe: ")
                    .append(threadGroup.getMaxPriority())
                    .append(",\n Dämon Eigenschaft der Gruppe: ")
                    .append(threadGroup.isDaemon())
                    .append(",\n Thread Name: ")
                    .append(e.getName())
                    .append(",\n Thread Prioretät: ")
                    .append(e.getPriority())
                    .append(",\n Dämon Thread: ")
                    .append(e.isDaemon())
                    .append(";\n");
        });

        return returnString.toString();
    }

    private static ThreadGroup getRoot(ThreadGroup thread) {
        ThreadGroup threadGroup = thread.getParent();
        if (threadGroup == null) return thread;
        return getRoot(threadGroup);
    }
}
