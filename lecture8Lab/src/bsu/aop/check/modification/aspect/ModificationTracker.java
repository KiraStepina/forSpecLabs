package bsu.aop.check.modification.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

import bsu.aop.check.modification.IModified;
import bsu.aop.check.modification.ModifiedImpl;

@Aspect
public class ModificationTracker {

	@DeclareParents(value="bsu.aop.check.modification.*+",
            defaultImpl=ModifiedImpl.class)
	public static IModified mixin;


	@Before("bsu.aop.check.modification.*.set*() && this(entity)")
	public void recordUsage(IModified entity) {
		System.out.println("Test usega checking");
	}
}
