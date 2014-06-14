package gcNotif;

import java.lang.management.GarbageCollectorMXBean;
import java.util.List;

import javax.management.NotificationEmitter;
import javax.management.NotificationListener;

public class GCMon {
	
	private List<GarbageCollectorMXBean> getGCMBeans() {
		List<GarbageCollectorMXBean> gcMbeans = java.lang.management.ManagementFactory.getGarbageCollectorMXBeans();	
		return gcMbeans;
	}

	public void installGCMonitoring(){
		List<GarbageCollectorMXBean> gcbeans = getGCMBeans();
		for (GarbageCollectorMXBean gcbean : gcbeans) {
			NotificationListener gcNotificationListener = new GCNotificationListener();
			NotificationEmitter emitter = (NotificationEmitter) gcbean;	     
			emitter.addNotificationListener(gcNotificationListener, null, null);
		}
	}

}
