package components.pools.concurrentQPool.client;

public class DummyProcess {
	
    private long processNo = 0;

    public DummyProcess(long processNo) {
        this.processNo = processNo;

        System.out.println("Object with process no. " + processNo + " was created");
    }

    public long getProcessNo() {
        return processNo;
    }
}