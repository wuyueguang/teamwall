package rocky.teamwall.entity;

/**
 * Tag Entity
 * @author wuyg 2016-6-29
 *
 */
public class Tag {

		String uid;
		
		String tag;

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

		public String getTag() {
			return tag;
		}

		public void setTag(String tag) {
			this.tag = tag;
		}

		@Override
		public String toString() {
			return "tag [uid=" + uid + ", tag=" + tag + "]";
		}
		
}
