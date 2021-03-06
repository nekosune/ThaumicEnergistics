package thaumicenergistics.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import thaumicenergistics.registries.BlockEnum;
import thaumicenergistics.registries.Renderers;
import thaumicenergistics.texture.BlockTextureManager;
import thaumicenergistics.tileentities.TileInfusionProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockInfusionProvider
	extends AbstractBlockProviderBase
{

	public BlockInfusionProvider()
	{
		// Call super with material machine (iron) 
		super( Material.iron );

		// Basic hardness
		this.setHardness( 1.0f );

		// Sound of metal
		this.setStepSound( Block.soundTypeMetal );
	}

	@Override
	public void breakBlock( final World world, final int x, final int y, final int z, final Block block, final int metadata )
	{
		// Get our tile entity
		TileInfusionProvider tile = (TileInfusionProvider)world.getTileEntity( x, y, z );

		// Do we still have a tile?
		if( tile != null )
		{
			// Inform it that its going away
			tile.onBreakBlock();
		}

		// Pass to super
		super.breakBlock( world, x, y, z, block, metadata );
	}

	@Override
	public TileEntity createNewTileEntity( final World world, final int metaData )
	{
		// Create a new provider tile, passing the side to attach to
		TileInfusionProvider tile = new TileInfusionProvider();

		// Setup the infusion provider
		tile.setupProvider( metaData );

		// Return the tile
		return tile;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon( final int side, final int metaData )
	{
		return BlockTextureManager.INFUSION_PROVIDER.getTextures()[1];
	}

	@Override
	public int getRenderType()
	{
		// Provide our custom ID
		return Renderers.InfusionProviderRenderID;
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockEnum.INFUSION_PROVIDER.getUnlocalizedName();
	}

	@Override
	public void onNeighborBlockChange( final World world, final int x, final int y, final int z, final Block neighbor )
	{
		// Inform our tile entity a neighbor has changed
		( (TileInfusionProvider)world.getTileEntity( x, y, z ) ).checkGridConnectionColor();

	}

}
