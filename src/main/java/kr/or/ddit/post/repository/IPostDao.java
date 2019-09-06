package kr.or.ddit.post.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.AttachedfileVo;
import kr.or.ddit.post.model.CommentsVo;
import kr.or.ddit.post.model.PostVo;

public interface IPostDao {
	
	/**
	* Method : allPostList
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param boardNum
	* @return
	* Method 설명 : boardNum을 파라미터로 보내서 일치하는 게시글 리스트를 가져온다.
	*/
	public List<PostVo> allPostList(SqlSession sqlSession, int boardNum); 
	
	/**
	* Method : getPostList
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param boardNum
	* @return
	* Method 설명 : boardNum을 파라미터로 보내서 일치하는 게시판 리스트를 가져온다.
	 */
	public List<PostVo> getPostList(SqlSession sqlSession, Map map);
	
	/**
	* Method : selectPost
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param postNum
	* @return
	* Method 설명 : postNum을 파라미터로 보내서 일치하는 게시글 정보를 가져온다.
	 */
	public PostVo selectPost(SqlSession sqlSession, int postNum);
	
	/**
	* Method : getCmtList
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param postNum
	* @return
	* Method 설명 : postNum을 파라미터로 보내서 일치하는 덧글 리스트를 가져온다.
	 */
	public List<CommentsVo> getCmtList(SqlSession sqlSession, int postNum);
	
	/**
	* Method : insertCmt
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param cvo
	* @return
	* Method 설명 : 댓글 저장
	 */
	public int insertCmt(SqlSession sqlSession, CommentsVo cvo);
	
	/**
	* Method : getPostSeq
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 
	*/
	public int getPostSeq(SqlSession sqlSession);
	
	/**
	* Method : insertPost
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param postVo
	* @return
	* Method 설명 : 게시글 등록
	*/
	public int insertPost(SqlSession sqlSession, PostVo postVo);
	
	/**
	* Method : insertPost2
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param postVo
	* @return
	* Method 설명 : 답글 등록
	*/
	public int insertPost2(SqlSession sqlSession, PostVo postVo);
	
	/**
	* Method : insertAtf
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param atfVo
	* @return
	* Method 설명 : 첨부파일 등록
	*/
	public int insertAtf(SqlSession sqlSession, AttachedfileVo atfVo);
	
	/**
	* Method : deletePost
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param postVo
	* @return
	* Method 설명 : 게시글 삭제
	*/
	public int deletePost(SqlSession sqlSession, PostVo postVo);
	
	/**
	* Method : updatePost
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param postVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	public int updatePost(SqlSession sqlSession, PostVo postVo);
	
	/**
	* Method : getAttachedFile
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param postnum
	* @return
	* Method 설명 : 첨부파일 정보 가져오기
	*/
	public List<AttachedfileVo> getAttachedFile(SqlSession sqlSession, int postnum);
	
	/**
	* Method : deleteAtf
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param atfnum
	* @return
	* Method 설명 : 첨부파일 삭제
	*/
	public int deleteAtf(SqlSession sqlSession, int atfnum);
	
	/**
	* Method : deleteCmt
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param cmtnum
	* @return
	* Method 설명 : 댓글 삭제
	*/
	public int deleteCmt(SqlSession sqlSession, int cmtnum);
	
	/**
	* Method : selectAtf
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param atfnum
	* @return
	* Method 설명 : 첨부파일 불러오기
	*/
	public AttachedfileVo selectAtf(SqlSession sqlSession, int atfnum);

}
