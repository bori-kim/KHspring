package com.spring.biz;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.biz.vo.BuyVO;
import com.spring.biz.vo.CategoryVO;
import com.spring.biz.vo.GoodsVO;
import com.spring.biz.vo.ImageVO;
import com.spring.biz.vo.SearchVO;

@Service("shopService") 
public class ShopServiceImpl implements ShopService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CategoryVO> selectCategoryList() {
		return sqlSession.selectList("selectCategoryList");
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertGoods(GoodsVO goodsVO, ImageVO imageVO) {
		sqlSession.insert("insertGoods", goodsVO);
		insertImage(imageVO);
	}

	@Override
	public int insertImage(ImageVO imageVO) {
		return sqlSession.insert("insertImage", imageVO);
	}

	@Override
	public int getMaxId() {
		return sqlSession.selectOne("getMaxId");
	}

	@Override
	public List<GoodsVO> selectGoodsList(GoodsVO goodsVO) {
		return sqlSession.selectList("selectGoodsList", goodsVO);
	}

	@Override
	public GoodsVO selectGoods(GoodsVO goodsVO) {
		return sqlSession.selectOne("selectGoods", goodsVO);
	}

	@Override
	public List<ImageVO> selectGoodsImages(int goodsId) {
		return sqlSession.selectList("selectGoodsImages", goodsId);
	}

	@Override
	public int insertBuy(BuyVO buyVO) {
		return sqlSession.insert("insertBuy", buyVO);
	}

	@Override
	public List<BuyVO> selectBuyList(SearchVO searchVO) {
		return sqlSession.selectList("selectBuyList", searchVO);
	}

	@Override
	public int updateIsConfirm(int orderNum) {
		return sqlSession.update("updateIsConfirm", orderNum);
	}

	
}











