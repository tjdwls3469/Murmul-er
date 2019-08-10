package com.murmuler.organicstack.dao;

import com.murmuler.organicstack.mybatis.CustomerMapper;
import com.murmuler.organicstack.mybatis.RoomMapper;
import com.murmuler.organicstack.vo.FaqVO;
import com.murmuler.organicstack.vo.InquiryVO;
import com.murmuler.organicstack.vo.NoticeVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CsDAOImpl implements CsDAO {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<NoticeVO> searchNoticeList(int page) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<NoticeVO> list = mapper.selectNoticeList(page);
        return list;
    }

    @Override
    public List<FaqVO> searchFaqList(int page) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<FaqVO> list = mapper.selectFaqList(page);
        return list;
    }

    @Override
    public FaqVO searchFaqDetail(int id) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        FaqVO faq = mapper.selectFaqDetail(id);
        return faq;
    }

    @Override
    public NoticeVO searchNoticeDetail(int id) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        NoticeVO notice = mapper.selectNoticeDetail(id);
        return notice;
    }

    @Override
    public int insertInquiry(String email, String content) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("content", content);
        int cnt = mapper.insertInquiry(map);
        return cnt;
    }

    @Override
    public int insertFaq(String title, String content) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("content", content);
        int cnt = mapper.insertFaq(map);
        return cnt;
    }

    @Override
    public int insertNotice(String title, String content) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("content", content);
        int cnt = mapper.insertNotice(map);
        return cnt;
    }

    @Override
    public int updateFaq(int id, String title, String content) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("title", title);
        map.put("content", content);
        int cnt = mapper.updateFaq(map);
        return cnt;
    }

    @Override
    public int updateNotice(int id, String title, String content) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("title", title);
        map.put("content", content);
        int cnt = mapper.updateNotice(map);
        return cnt;
    }

    @Override
    public int updateInquiry(int id, int processId) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("processId", processId);
        int cnt = mapper.updateInquiry(map);
        return cnt;
    }

    @Override
    public int deleteFaq(int id) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        return mapper.deleteFaq(id);
    }

    @Override
    public int deleteNotice(int id) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        return mapper.deleteNotice(id);
    }

    @Override
    public int deleteInquiry(int id) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        return mapper.deleteInquiry(id);
    }

    @Override
    public List<InquiryVO> selectInquiryList(int page) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<InquiryVO> list = mapper.selectInquiryList(page);
        return list;
    }

    @Override
    public InquiryVO selectInquiryDetail(int id) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        InquiryVO inquiryVO = mapper.searchInquiryDetail(id);
        return inquiryVO;
    }

    @Override
    public int searchFaqButtonCnt() {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        return mapper.selectFaqButtonCnt();
    }

    @Override
    public int searchNoticeButtonCnt() {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        return mapper.selectNoticeButtonCnt();
    }
}