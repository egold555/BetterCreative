package org.golde.forge.bettercreative.proxy;

import org.golde.forge.bettercreative.BetterCreative;
import org.golde.forge.bettercreative.blocks.SpecialBlocks;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void init() {
		SpecialBlocks.registerRenders();
	}
	
}
