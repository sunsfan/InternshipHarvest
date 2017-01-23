package sunsfan_spring.dao;

import java.util.List;

import sunsfan_spring.daoImpl.Spittle;

public interface SpittleRepo {
	List<Spittle> findSpittles(long max, int count);

	Spittle findOne(long spittleId);
}
