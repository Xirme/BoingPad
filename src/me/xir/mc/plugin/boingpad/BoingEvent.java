package me.xir.mc.plugin.boingpad;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

public class BoingEvent {
	final private Block pressurePlate;
	final private Block boingBlock;
	final private Entity triggeringEntity;
	
	public BoingEvent(Block pressurePlate, Block boingBlock, Entity triggeringEntity) {
		this.pressurePlate = pressurePlate;
		this.boingBlock = boingBlock;
		this.triggeringEntity = triggeringEntity;
	}
	
	public Block getPressurePlate() {
		return pressurePlate;
	}
	
	public Block getBoingBlock() {
		return boingBlock;
	}
	
	public Entity getTriggeringEntity() {
		return triggeringEntity;
	}

}
