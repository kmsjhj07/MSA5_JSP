package shop.dao;

import java.sql.SQLException;
import java.util.UUID;

import shop.dto.PersistentLogin;
import shop.dto.Product;
import shop.dto.User;

public class UserRepository extends JDBConnection {
	
	/**
	 * 회원 등록
	 * @param user
	 * @return
	 */
	public int insert(User user) {
		int result = 0;
		
		String sql = " INSERT INTO `user` VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?, SYSDATE()) ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString( 1, user.getId() );
			psmt.setString( 2, user.getPassword() );
			psmt.setString( 3, user.getName() );
			psmt.setString( 4, user.getGender() );
			psmt.setString( 5, user.getBirth() );
			psmt.setString( 6, user.getMail() );
			psmt.setString( 7, user.getPhone() );
			psmt.setString( 8, user.getAddress() );
			
			result = psmt.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
	}
	
	
	/**
	 * 로그인을 위한 사용자 조회
	 * @param id
	 * @param pw
	 * @return
	 */
	public User login(String id, String pw) {
		User user = new User();
		
		String sql = " SELECT * "
				   + " FROM `user` "
				   + " WHERE id = ? AND password = ? ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString( 1, id );
			psmt.setString( 2, pw );
			rs = psmt.executeQuery();
					
			if( rs.next() ) {
				user.setId( rs.getString("id") );
				user.setPassword( rs.getString("password") );
				return user;
			}
		} catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
	}
	
	
	
	
	/**
	 * 로그인을 위한 사용자 조회
	 * @param id
	 * @param pw
	 * @return
	 */
	public User getUserById(String id) {
		User user = new User();
		
		String sql = " SELECT * "
				   + " FROM `user` "
				   + " WHERE id = ? ";
		try {
			psmt = con.prepareStatement(sql);
	        psmt.setString(1, id);

	        rs = psmt.executeQuery();
					
			if(rs.next()) {
	        	user.setId(rs.getString("id"));
	            user.setPassword(rs.getString("password"));
	            user.setName(rs.getString("name"));
	            user.setGender(rs.getString("gender"));
	            user.setBirth(rs.getString("birth"));
	            user.setMail(rs.getString("mail"));
	            user.setPhone(rs.getString("phone"));
	            user.setAddress(rs.getString("address"));
	            user.setRegistDay(rs.getString("regist_day"));
	            
	    		return user;
	        }
		} catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
	}
	
	
	/**
	 * 회원 수정
	 * @param user
	 * @return
	 */
	public int update(User user) {
int result = 0;
		
		String sql = " UPDATE `user` " + " SET id = ?, gender = ?, birth = ? " + " , mail = ?, phone = ?, address = ? " + " WHERE id = ? AND gender = ?  AND phone = ? ";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getGender());
			psmt.setString(3, user.getBirth());
			psmt.setString(4, user.getMail());
			psmt.setString(5, user.getPhone());
			psmt.setString(6, user.getAddress());
			psmt.setString(7, user.getId());
			psmt.setString(8, user.getGender());
			psmt.setString(9, user.getPhone());
			
			result = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("에러");
			e.printStackTrace();
		}
		
		return result;
	}


	/**
	 * 회원 삭제
	 * @param id
	 * @return
	 */
	public int delete(String id) {
		int result = 0;
		String sql = " DELETE FROM `user` " + " WHERE id = ? ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			
			result = psmt.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
	}
	
	/**
	 * 토큰 리프레쉬
	 * @param userId
	 */
	public String refreshToken(String userId) {
	    PersistentLogin persistentLogin = selectToken(userId);
	    String token = null;
	    if (persistentLogin == null) {
	    	token = insertToken(userId);
	    } else {
	    	token =  updateToken(userId);
	    }
	    return token;
	}

	
	
	/**
	 * 토큰 정보 조회
	 * @param userId
	 * @return
	 */
	public PersistentLogin selectToken(String userId) {
	    String sql = "SELECT * FROM persistent_logins WHERE user_id = ?";
	    
	    PersistentLogin persistentLogin = null;
	    try {
	        psmt = con.prepareStatement(sql);
	        psmt.setString(1, userId);

	        rs = psmt.executeQuery();
	        if (rs.next()) {
	        	persistentLogin = new PersistentLogin();
	        	persistentLogin.setpNo( rs.getInt("p_no")); 
	        	persistentLogin.setUserId( rs.getString("user_id") ); 
	        	persistentLogin.setToken( rs.getString("token") ); 
	        	persistentLogin.setDate( rs.getTimestamp("token") ); 
	        }
	        rs.close();
	    } catch (SQLException e) {
	        System.err.println("에러");
	        e.printStackTrace();
	    }
	    return persistentLogin;
	}
	
	
	/**
	 * 토큰 정보 조회 - 토큰으로
	 * @param token
	 * @return
	 */
	public PersistentLogin selectTokenByToken(String token) {
	    String sql = "SELECT * FROM persistent_logins WHERE token = ?";
	    
	    PersistentLogin persistentLogin = null;
	    try {
	        psmt = con.prepareStatement(sql);
	        psmt.setString(1, token);

	        rs = psmt.executeQuery();
	        if (rs.next()) {
	            persistentLogin = new PersistentLogin();
	            persistentLogin.setpNo(rs.getInt("p_no")); 
	            persistentLogin.setUserId(rs.getString("user_id")); 
	            persistentLogin.setToken(rs.getString("token")); 
	            persistentLogin.setDate(rs.getTimestamp("date")); 
	        }
	        rs.close();
	    } catch (SQLException e) {
	        System.err.println("에러");
	        e.printStackTrace();
	    }
	    return persistentLogin;
	}


	
	
	/**
	 * 자동 로그인 토큰 생성
	 * @param userId
	 * @return
	 */
	public String insertToken(String userId) {
		 int result = 0;
	    String sql = "INSERT INTO persistent_logins (user_id, token) VALUES (?, ?)";
	    String token = UUID.randomUUID().toString();
	    try {
	        psmt = con.prepareStatement(sql);
	        psmt.setString(1, userId);
	        psmt.setString(2, token);

	        result = psmt.executeUpdate();
	    } catch (SQLException e) {
	        System.err.println("에러");
	        e.printStackTrace();
	    }
	    System.out.println("자동 로그인 정보 " + result + "개가 등록되었습니다.");
	    return token;
	}
	
	/**
	 * 자동 로그인 토큰 갱신
	 * @param userId
	 * @return
	 */
	public String updateToken(String userId) {
	    int result = 0;
	    String sql = "UPDATE persistent_logins SET token = ?, date = now() WHERE user_id = ?";
	    String token = UUID.randomUUID().toString();
	    try {
	    	psmt = con.prepareStatement(sql);
	        psmt.setString(1, token);
	        psmt.setString(2, userId);

	        result = psmt.executeUpdate();
	    } catch (SQLException e) {
	        System.err.println("에러");
	        e.printStackTrace();
	    }
	    System.out.println("자동 로그인 정보 " + result + "개의 데이터가 수정되었습니다.");
	    return token;
	}
	
	
	/**
	 * 토큰 삭제
	 * - 로그아웃 시, 자동 로그인 풀림
	 * @param userId
	 * @return
	 */
	public int deleteToken(String userId) {
	    int result = 0;
	    String sql = "DELETE FROM persistent_logins WHERE user_id = ?";
	    
	    try {
	        psmt = con.prepareStatement(sql);
	        psmt.setString(1, userId);

	        result = psmt.executeUpdate();
	    } catch (SQLException e) {
	        System.err.println("에러");
	        e.printStackTrace();
	    }
	    System.out.println("자동 로그인 정보 " + result + "개의 데이터가 삭제되었습니다.");
	    return result;
	}


}
















