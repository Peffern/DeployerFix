package com.peffern.deployer.asm;

import java.util.ListIterator;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodNode;

import net.minecraft.launchwrapper.IClassTransformer;

public class BPBlocksCT implements IClassTransformer
{

	@Override
	public byte[] transform(String name, String transformedName, byte[] basicClass) 
	{
		if(name.equals("com.bluepowermod.init.BPBlocks"))
		{
			return asmify(basicClass);
		}
		else
			return basicClass;
	}
	
	//find the place where its making the deployer and use the custom one
	
	private byte[] asmify(byte[] bytes)
	{
		ClassNode classNode = new ClassNode();
		ClassReader classReader = new ClassReader(bytes);
		classReader.accept(classNode, 0);
		
		for(MethodNode m : classNode.methods)
		{
			if(m.name.equals("instantiateBlocks") && m.desc.equals("()V"))
			{
				ListIterator<AbstractInsnNode> it = m.instructions.iterator();
				while(it.hasNext())
				{
					AbstractInsnNode i = it.next();
					if(i instanceof LdcInsnNode)
					{
						LdcInsnNode linsn = (LdcInsnNode)i;
						if(linsn.cst.equals(Type.getType("Lcom/bluepowermod/tile/tier1/TileDeployer;")))
						{
							LdcInsnNode newLinsn = new LdcInsnNode(Type.getType("Lcom/peffern/deployer/TileCustomDeployer;"));
							m.instructions.insert(linsn, newLinsn);
							m.instructions.remove(linsn);
						}
					}
				}
				
			}
		}
		
		ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        classNode.accept(writer);
        return writer.toByteArray();
	}

}
