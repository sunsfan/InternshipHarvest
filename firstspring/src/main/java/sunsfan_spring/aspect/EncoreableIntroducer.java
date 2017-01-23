package sunsfan_spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

import sunsfan_spring.dao.Encoreable;
import sunsfan_spring.daoImpl.DefaultEncoreable;

@Aspect
public class EncoreableIntroducer {
	@DeclareParents(value = "sunsfan_spring.dao.Performance+", defaultImpl = DefaultEncoreable.class)
	public static Encoreable encoreable;
}
