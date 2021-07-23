package de.melanx.morexfood.block;

import de.melanx.morexfood.util.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class BlockCropRice extends BaseCrop {
    private static final IntegerProperty RICE_AGE = BlockStateProperties.AGE_3;

    public BlockCropRice(Properties properties) {
        super(properties);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return RICE_AGE;
    }

    @Override
    public ItemLike getBaseSeedId() {
        return Registry.rice_seed.get();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(RICE_AGE);
    }

    @Override
    public Item getDrop() {
        return Registry.rice.get();
    }
}
