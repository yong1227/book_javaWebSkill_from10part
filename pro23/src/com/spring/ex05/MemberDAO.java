package com.spring.ex05;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.ex01.MemberVO;

public class MemberDAO {
	public static SqlSessionFactory sqlMapper = null;

	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	public String  selectName() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		String name = session.selectOne("mapper.member.selectName");
		return name;
	} 
	
	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.selectAllMemberList");
		return memlist;
	}

	public MemberVO selectMemberById(String id){
	      sqlMapper=getInstance();
	SqlSession session=sqlMapper.openSession();
	      MemberVO memberVO=session.selectOne("mapper.member.selectMemberById",id);
	      return memberVO;		
	   }

	public List<MemberVO> selectMemberByPwd(int pwd) {
	sqlMapper = getInstance();
	SqlSession session = sqlMapper.openSession();
	List<MemberVO> membersList = null;
	membersList= session.selectList("mapper.member.selectMemberByPwd", pwd);
	return membersList;
	}

	public int insertMember(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = 0;
		// ������ id�� SQL���� memberVO���� �����Ͽ� ȸ�� ������ ���̺��� �߰��մϴ�.
		result = session.insert("mapper.member.insertMember", memberVO);
		// ���� Ŀ���̹Ƿ� �ݵ�� commit()�޼��带 ȣ���Ͽ� �����ݿ��մϴ�.
		session.commit();
		return result;
	}
	public int insertMember2(Map<String,String> memberMap){
        sqlMapper=getInstance();
        SqlSession session=sqlMapper.openSession();
        int result= result=session.insert("mapper.member.insertMember2",memberMap);
        session.commit();	
        return result;		
	}

	public int updateMember(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		// update�� ȣ�� �� SqlSession�� update()�޼��带 �̿��մϴ�.
		int result = session.update("mapper.member.updateMember", memberVO);
		session.commit();
		return result;
	}   

    public int deleteMember(String id) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = 0;
		result = session.delete("mapper.member.deleteMember", id);
		session.commit();
		return result;
    } 
    
    public List<MemberVO>  searchMember(MemberVO  memberVO){
        sqlMapper=getInstance();
        SqlSession session=sqlMapper.openSession();
        //ȸ�� �˻�â���� ���޵� �̸��� ���� ���� memberVO�� �����Ͽ� SQL������ �����մϴ�.
        List list=session.selectList("mapper.member.searchMember",memberVO);
        return list;		
    } 

    public List<MemberVO>  foreachSelect(List nameList){
        sqlMapper=getInstance();
        SqlSession session=sqlMapper.openSession();
        // �˻� �̸��� ����� nameList�� SQL������ �����մϴ�.
        List list=session.selectList("mapper.member.foreachSelect",nameList);
        return list;		
    }
    
    public int  foreachInsert(List memList){
        sqlMapper=getInstance();
        SqlSession session=sqlMapper.openSession();
        // ȸ�� ������ ����� memList�� SQL������ �����մϴ�. ���������� ����Ǹ� ����� ��ȯ�մϴ�.
        int result = session.insert("mapper.member.foreachInsert",memList);
        session.commit();
        return result ;		
     }
    
    public List<MemberVO>  selectLike(String name){
        sqlMapper=getInstance();
        SqlSession session=sqlMapper.openSession();
        List list=session.selectList("mapper.member.selectLike",name);
        return list;		
    }


}