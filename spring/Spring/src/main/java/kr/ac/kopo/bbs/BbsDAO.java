package kr.ac.kopo.bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import aiws.web.JDBCUtil;


public class BbsDAO {
	
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

	
	  // 문의글 전체 보기
    public List<Bbs> getBoardList() {
        List<Bbs> boardList = new ArrayList<Bbs>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT *");
        sql.append("  FROM BBS");
        sql.append(" ORDER BY BBSID DESC");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());

            rs = stmt.executeQuery();

            while (rs.next()) {
                Bbs board = new Bbs();
                
            
               board.setBbsContent(rs.getString("BBSCONTENT"));
               board.setBbsDate(rs.getString("BBSDATE"));
               board.setBbsID(rs.getInt("BBSID"));
               board.setBbsTitle(rs.getString("BBSTITLE"));
               board.setUserID(rs.getString("USERID"));

               boardList.add(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return boardList;
    }

//    // 문의글 하나보기
//    public Bbs getBoard(int b_no) {
//        Bbs board = null;
//        StringBuilder sql = new StringBuilder();
//
//        sql.append("SELECT * FROM BANK_BOARD WHERE B_NO = ?");
//        try {
//            conn = JDBCUtil.getConnection();
//            stmt = conn.prepareStatement(sql.toString());
//            stmt.setInt(1, b_no);
//
//            rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                board = new Bbs();
//                board.setB_no(rs.getInt("B_NO"));
//                board.setTitle(rs.getString("TITLE"));
//                board.setContent(rs.getString("CONTENT"));
//                board.setReg_date(rs.getDate("REG_DATE"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return board;
//    }

}