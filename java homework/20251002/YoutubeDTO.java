package ch2;

import java.sql.Date;

public class YoutubeDTO {

		private int id;
		private String title;
		private String channelName;
		private Date upLoadDate;
		private int views;
		private int good;
		
		public YoutubeDTO() {}

		
		public YoutubeDTO(String title, String channelName, Date upLoadDate, int views, int good) {
			super();
			this.title = title;
			this.channelName = channelName;
			this.upLoadDate = upLoadDate;
			this.views = views;
			this.good = good;
		}

		public YoutubeDTO(int id, String title, String channelName, Date upLoadDate, int views, int good) {
	
			this.id = id;
			this.title = title;
			this.channelName = channelName;
			this.upLoadDate = upLoadDate;
			this.views = views;
			this.good = good;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getChannelName() {
			return channelName;
		}


		public void setChannelName(String channelName) {
			this.channelName = channelName;
		}


		public Date getUpLoadDate() {
			return upLoadDate;
		}


		public void setUpLoadDate(Date upLoadDate) {
			this.upLoadDate = upLoadDate;
		}


		public int getViews() {
			return views;
		}


		public void setViews(int views) {
			this.views = views;
		}


		public int getGood() {
			return good;
		}


		public void setGood(int good) {
			this.good = good;
		}


		@Override
		public String toString() {
			return String.format( "%d번 %s | 채널명: %s | 업로드 날짜: %s | 조회수: %d회 | 좋아요 %d개", id, title, channelName, upLoadDate, views, good);
		}
		
}