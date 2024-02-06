package Main;

import Objects.Boots;
import Objects.Chest;
import Objects.OBJ_Key;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp)
    {
        this.gp = gp;


    }
    public void setObject()
    {
        gp.objs[0]= new OBJ_Key();
        gp.objs[0].WorldX = 30*gp.tileSize;
        gp.objs[0].WorldY = 23*gp.tileSize;

        gp.objs[1] = new Chest();
        gp.objs[1].WorldX = 25*gp.tileSize;
        gp.objs[1].WorldY = 30*gp.tileSize;

        gp.objs[2] = new Boots();
        gp.objs[2].WorldX = 15*gp.tileSize;
        gp.objs[2].WorldY = 30*gp.tileSize;
    }
}
