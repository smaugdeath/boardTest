package kr.or.ddit.post.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.post.model.AttachedfileVo;
import kr.or.ddit.post.model.CommentsVo;
import kr.or.ddit.post.model.PostVo;

public interface IPostService {
	
	/**
	* Method : allPostList
	* 작성자 : PC-24
	* 변경이력 :
	* @param boardNum
	* @return
	* Method 설명 : boardNum을 파라미터로 보내서 일치하는 게시글 리스트를 가져온다.
	*/
	public List<PostVo> allPostList(int boardNum);
	
	/**
	* Method : getPostList
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param boardNum
	* @return
	* Method 설명 : boardNum을 파라미터로 보내 일치하는 게시판 리스트를 가져온다.
	 */
	public List<PostVo> getPostList(Map map);
	
	/**
	* Method : selectPost
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param postNum
	* @return
	* Method 설명 : postNum을 파라미터로 보내 일치하는 게시글에 출력될 정보들을 가져온다.
	 */
	public Map<String, Object> selectPost(int postNum);
	
	/**
	* Method : insertCmt
	* 작성자 : PC-24
	* 변경이력 :
	* @param cvo
	* @return
	* Method 설명 : 댓글등록
	 */
	public int insertCmt(CommentsVo cvo);
	
	/**
	* Method : insertPost
	* 작성자 : PC-24
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 게시글 등록
	*/
	public int insertPost(Map map);
	
	/**
	* Method : insertPost2
	* 작성자 : PC-24
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 답글 등록
	*/
	public int insertPost2(Map map);
	
	/**
	* Method : getPostSeq
	* 작성자 : PC-24
	* 변경이력 :
	* @return
	* Method 설명 : 
	*/
	public int getPostSeq();
	
	/**
	* Method : insertAtf
	* 작성자 : PC-24
	* 변경이력 :
	* @param atfVo
	* @return
	* Method 설명 : 첨부파일 등록
	*/
	public int insertAtf(AttachedfileVo atfVo);
	
	/**
	* Method : deletePost
	* 작성자 : PC-24
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 삭제
	*/
	public int deletePost(PostVo postVo);
	
	/**
	* Method : updatePost
	* 작성자 : PC-24
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	public int updatePost(PostVo postVo);
	
	/**
	* Method : getAttachedFile
	* 작성자 : PC-24
	* 변경이력 :
	* @param postnum
	* @return
	* Method 설명 : 첨부파일  정보 가져오기
	*/
	public List<AttachedfileVo> getAttachedFile(int postnum);
	
	/**
	* Method : deleteAtf
	* 작성자 : PC-24
	* 변경이력 :
	* @param atfnum
	* @return
	* Method 설명 : 첨부파일 삭제
	*/
	public int deleteAtf(int atfnum);
	
	/**
	* Method : deleteCmt
	* 작성자 : PC-24
	* 변경이력 :
	* @param cmtnum
	* @return
	* Method 설명 : 댓글 삭제
	*/
	public int deleteCmt(int cmtnum);
	
	/**
	* Method : selectAtf
	* 작성자 : PC-24
	* 변경이력 :
	* @param atfnum
	* @return
	* Method 설명 : 첨부파일 불러오기
	*/
	public AttachedfileVo selectAtf(int atfnum);

}
