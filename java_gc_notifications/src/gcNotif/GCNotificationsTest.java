package gcNotif;

import java.util.ArrayList;
import java.util.List;



public class GCNotificationsTest {
	
	/** method to generate more garbage */
	private void generateGarbageToSeeGCLogs() {
		 List<String> data = new ArrayList<String>();
		 int i = 0;
		while(true) {
			data.addAll(new ArrayList<String>(1000));
			i++;
			while( i == 1000) {
				data.clear();
			}
		}
	}
	private void addGCMonitoring() {
		GCMon gcMon = new GCMon();
		gcMon.installGCMonitoring();
	}
	
	public static void main(String[] args) {
		GCNotificationsTest gcNotificationsTest = new GCNotificationsTest();
		gcNotificationsTest.addGCMonitoring();
		gcNotificationsTest.generateGarbageToSeeGCLogs();
	}

	
	
	/** sample output 
	 * 
	 *
	
	GC_DETAILS , ID=1, GC_TYPE=end of minor GC, GC_NAME=PS Scavenge, DURATION(micros)=3, GC_CAUSE=System.gc(), GC_START_TIME(millsAfterJVMStart)=10684, GC_END_TIME(millsAfterJVMStart)=10687
GC_DETAILS , ID=1, GC_TYPE=end of major GC, GC_NAME=PS MarkSweep, DURATION(micros)=22, GC_CAUSE=System.gc(), GC_START_TIME(millsAfterJVMStart)=10687, GC_END_TIME(millsAfterJVMStart)=10709
GC_DETAILS , ID=2, GC_TYPE=end of minor GC, GC_NAME=PS Scavenge, DURATION(micros)=1, GC_CAUSE=System.gc(), GC_START_TIME(millsAfterJVMStart)=27795, GC_END_TIME(millsAfterJVMStart)=27796
GC_DETAILS , ID=2, GC_TYPE=end of major GC, GC_NAME=PS MarkSweep, DURATION(micros)=18, GC_CAUSE=System.gc(), GC_START_TIME(millsAfterJVMStart)=27796, GC_END_TIME(millsAfterJVMStart)=27814
GC_DETAILS , ID=3, GC_TYPE=end of minor GC, GC_NAME=PS Scavenge, DURATION(micros)=1, GC_CAUSE=System.gc(), GC_START_TIME(millsAfterJVMStart)=43674, GC_END_TIME(millsAfterJVMStart)=43675
GC_DETAILS , ID=3, GC_TYPE=end of major GC, GC_NAME=PS MarkSweep, DURATION(micros)=21, GC_CAUSE=System.gc(), GC_START_TIME(millsAfterJVMStart)=43675, GC_END_TIME(millsAfterJVMStart)=43696
GC_DETAILS , ID=4, GC_TYPE=end of minor GC, GC_NAME=PS Scavenge, DURATION(micros)=1, GC_CAUSE=System.gc(), GC_START_TIME(millsAfterJVMStart)=59321, GC_END_TIME(millsAfterJVMStart)=59322
GC_DETAILS , ID=4, GC_TYPE=end of major GC, GC_NAME=PS MarkSweep, DURATION(micros)=18, GC_CAUSE=System.gc(), GC_START_TIME(millsAfterJVMStart)=59322, GC_END_TIME(millsAfterJVMStart)=59340
GC_DETAILS , ID=5, GC_TYPE=end of minor GC, GC_NAME=PS Scavenge, DURATION(micros)=1, GC_CAUSE=Allocation Failure, GC_START_TIME(millsAfterJVMStart)=850485, GC_END_TIME(millsAfterJVMStart)=850486
GC_DETAILS , ID=6, GC_TYPE=end of minor GC, GC_NAME=PS Scavenge, DURATION(micros)=2, GC_CAUSE=Allocation Failure, GC_START_TIME(millsAfterJVMStart)=1691024, GC_END_TIME(millsAfterJVMStart)=1691026

	
	
	
	 */
}
