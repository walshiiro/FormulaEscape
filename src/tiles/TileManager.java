package tiles;

import Main.GamePanel;

import javax.imageio.IIOImage;
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
    public void getTileImage()
    {
        try
        {
            tile[0]= new Tiles();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/dirt_podzol_top.png"));
            tile[1]= new Tiles();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water1.png"));
            tile[1].collision=true;
            tile[2] = new Tiles();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water2.png"));
            tile[2].collision=true;
            tile[3] = new Tiles();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/cobblestone.png"));
            tile[3].collision=true;
            tile[4] = new Tiles();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/dirt.png"));
            tile[5] = new Tiles();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/log_oak.png"));
            tile[6] = new Tiles();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/flower_tulip_red.png"));
            tile[6].collision=true;
            tile[7] = new Tiles();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/flower_rose.png"));
            tile[7].collision=true;
            tile[8] = new Tiles();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/cobblestone_mossy.png"));
            tile[8].collision=true;

            



            



        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
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
               g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
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
