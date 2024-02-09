package tiles;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
   public Tiles[] tile;

   public int mapTileNum[][];

    public TileManager(GamePanel gp)
    {
        this.gp = gp;
        tile = new Tiles[40]; //So luong cac loai block can dung
        getTileImage();
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        loadmap();



    }
    public void loadmap()
    {
        try
        {
            InputStream is = getClass().getResourceAsStream("/map/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int row =0;
            while (row < gp.maxWorldRow)
            {
                String line = br.readLine();

                for(int i=0;i<gp.maxWorldCol;i++)
                {
                    String line2[] = line.split(" ");
                    mapTileNum[i][row]=Integer.parseInt(line2[i]);
                }
                row++;


            }
            br.close();

        }
        catch (Exception e)
        {

        }
    }
  public void setup(int index, String path, boolean collision)
    {
        UtilityTool uTool = new UtilityTool();
        try
        {
            tile[index]= new Tiles();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/"+path+".png"));
            tile[index].image = uTool.scaleImage(tile[index].image,gp.tileSize,gp.tileSize);
            tile[index].collision = collision;
        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void getTileImage()
    {
       /*try{
           tile[0] = new Tiles();
           tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/cobblestone.png"));
           tile[0].collision = false;
           tile[1] = new Tiles();
           tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/cobblestone_mossy.png"));
           tile[1].collision = true;



       }catch(IOException e)
       {
           e.printStackTrace();
       } */
       setup(0,"cobblestone",false);
       setup(1,"cobblestone_mossy",true);
    }


    public void draw(Graphics2D g2)
    {
       int Worldrow =0,Worldcol=0,y=0,x=0;
       while(Worldcol < gp.maxWorldCol && Worldrow<gp.maxWorldRow )
       {
           int tileNum = mapTileNum[Worldcol][Worldrow];
           int WorldX = Worldcol * gp.tileSize;
           int WorldY = Worldrow * gp.tileSize;
           int screenX = WorldX - gp.player.worldX + gp.player.screenX;
           int screenY = WorldY - gp.player.worldY + gp.player.screenY;
           if(WorldX + gp.tileSize > gp.player.worldX -gp.player.screenX &&
              WorldX -gp.tileSize <gp.player.worldX + gp.player.screenX &&
           WorldY + gp.tileSize > gp.tileSize + - gp.player.screenY
           && WorldY -gp.tileSize < gp.player.worldY + gp.player.screenY) {
               g2.drawImage(tile[tileNum].image, screenX, screenY, null);
           }
           Worldcol++;

           if(Worldcol==gp.maxWorldCol)
           {
               Worldcol=0;

               Worldrow++;


           }

       }
    }
}
