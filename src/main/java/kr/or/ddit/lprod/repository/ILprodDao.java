package kr.or.ddit.lprod.repository;

import java.util.List;

import kr.or.ddit.lprod.model.Lprod;

public interface ILprodDao {
	public List<Lprod> selectAll();
}