package com.dao;

import java.sql.*;
import java.util.*;

import com.core.*;
import com.dto.*;

public class BoardDao {
	
	public ArrayList<Board> getList(int page, int limit) {
		ArrayList<Board> list = new ArrayList<>();
		
		page = (page <= 0)?1:page;
		limit = (limit <= 0)?15:limit;
		
		int offset = (page - 1) * limit;
		
		String sql = "SELECT * FROM board ORDER BY idx DESC LIMIT ?, ?";
		try(Connection conn = DB.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, offset);
			pstmt.setInt(2, limit);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Board(rs));
			}
			rs.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<Board> getList(int page) {
		return getList(page, 15);
	}
}
