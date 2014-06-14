package gcNotif;


import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;

import com.sun.management.GarbageCollectionNotificationInfo;


/**
 * 
 * The listener class that listens to GarbageCollection event 
 * 
 * @author radhakrishnan
 *
 */
public class GCNotificationListener implements NotificationListener {

	long totalGcDuration = 0;


	@Override
	public void handleNotification(Notification notification, Object handback) {

		if (isNotificationForGC(notification)) {        
			GarbageCollectionNotificationInfo info = getGarbageCollectionNotificationInfo(notification);
			
			long id = info.getGcInfo().getId();
			String gctype = info.getGcAction();
			String gcName= info.getGcName();
			long duration = info.getGcInfo().getDuration();
			String gcCause = info.getGcCause();
			long gcStartTime = info.getGcInfo().getStartTime();
			long gcEndTime = info.getGcInfo().getEndTime();
			
			StringBuilder sb = new StringBuilder(100);
			sb.append("GC_DETAILS ");
			sb.append(", ID=").append(id);
			sb.append(", GC_TYPE=").append(gctype);
			sb.append(", GC_NAME=").append(gcName);
			sb.append(", DURATION(millis)=").append(duration);
			sb.append(", GC_CAUSE=").append(gcCause);
			sb.append(", GC_START_TIME(millsAfterJVMStart)=").append(gcStartTime);
			sb.append(", GC_END_TIME(millsAfterJVMStart)=").append(gcEndTime);
			
			log(sb.toString());
		}
	}
	
	
	private boolean isNotificationForGC(Notification notification) {
		boolean isNotificationForGC = false;
		if (notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {  
			isNotificationForGC = true;
		}
		return isNotificationForGC;		
	}
	
	private GarbageCollectionNotificationInfo getGarbageCollectionNotificationInfo(Notification notification) {
		GarbageCollectionNotificationInfo info = GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());
		return info;
	}
	
	private void log(String data) {
		System.out.println(data);
	}
}

