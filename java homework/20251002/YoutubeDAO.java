package ch2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class YoutubeDAO {

	public List<YoutubeDTO> selectAllYoutube() {
		List<YoutubeDTO> list = new ArrayList<>();
		String sql = "select * from youtube";

		try (Connection conn = DBUtillY.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String channelName = rs.getString("channelName");
				Date upLoadDate = rs.getDate("upLoadDate");
				int views = rs.getInt("views");
				int good = rs.getInt("good");

				YoutubeDTO dto = new YoutubeDTO(id, title, channelName, upLoadDate, views, good);
				list.add(dto);
			}

		} catch (Exception e) {
			System.out.println("오류: " + e.getMessage());

		}
		return list;
	}
}