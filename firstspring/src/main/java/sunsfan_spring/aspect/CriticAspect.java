package sunsfan_spring.aspect;

import sunsfan_spring.dao.CriticismEngine;
import sunsfan_spring.daoImpl.CriticismEngineImpl;

public aspect CriticAspect {
	public CriticAspect() {
	}

	pointcut performance() : execution(* perform(..));

//    afterReturning() : performance() {
//    	System.out.println(criticismEngine.getCriticism());
//    }

	private CriticismEngine criticismEngine;

	public void setCriticismEngine(CriticismEngine criticismEngine) {
		this.criticismEngine = criticismEngine;
	}
}
