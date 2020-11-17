package mancala;
import java.util.Scanner;

public class Mancala {
    public static void main(String[] args) {
        
        byte[] array = new byte[] {4,4,4,4,4,4,4,4,4,4,4,4,0,0};
        byte field = 0, seeds = 0, limit = 0, lastPos = 0;
        boolean end = false;
        String player1 = "Me", player2 = "Oponent";
        Scanner readKeys = new Scanner(System.in);
        
        Board.ShowBoard(array, player1, player2);
        while(end == false)
        {
            //Start of P1
            System.out.println(player1 + ", Which field would you like to sow?");
            field = readKeys.nextByte();

            seeds = array[field];
            limit = (byte) (seeds + field);

            //Check if P1 overlaps.
            if(limit >= 11)
            {
                limit = 11;
            }
            
            //Not overlap loop.
            for(byte i = field; i <=limit; i++)
            {
                array[i] = (byte) (array[i] + 1);
                seeds--;
                lastPos = i;
            }
            
            //Overlap loop.
            for(byte i = 0; i <= seeds; i++)
            {
                array[i] = (byte) (array[i] + 1);
                lastPos = i;
            }

            //HARVEST
            //You can only harvest on opponents field.
            limit = (byte) (lastPos - 1);

            for(byte i = lastPos; i >= limit; i--)
            {
                if(array[i] == 2 || array[i] == 3)
                {
                    array[12] += array[i];
                    System.out.printf("%s Harvests %d from field %d!!\n",player1,array[i],i);
                    array[i] = 0;

                }
                else
                {
                    break;
                }
            }

            array[field] = 0;
            //End of P1

            Board.ShowBoard(array, player1, player2);

            //START P2
            System.out.println(player2 + ", Which field would you like to sow?");
            field = readKeys.nextByte();
            seeds = array[field];

            limit = (byte) (seeds + field);
            
            //Check if P2 Overlaps
            if(limit >= 11)
            {
                limit = 11;
            }
            
            //Not overlap loop
            for(byte i = field; i <= limit; i++)
            {
                array[i] = (byte) (array[i] + 1);
                seeds--;
                lastPos = i;
            }
            
            //Overlap loop
            for(byte i = 0; i <= seeds; i++)
            {
                array[i] = (byte) (array[i] + 1);
                lastPos = i;
            }
            
            //Harvest
            //You can only harvest on opponents field.
            limit = (byte) (lastPos - 1);
            for(byte i = lastPos; i >= limit; i--)
            {
                if(array[i] == 2 || array[i] == 3 && lastPos <=5)
                {
                    array[13] += array[i];
                    System.out.printf("%s Harvests %d from field %d!!\n",player2,array[i],i);
                    array[i] = 0;
                }
                else
                {
                    break;
                }
            }
            array[field] = 0;
            Board.ShowBoard(array, player1, player2);
        }

        //End of P2

    }
}
