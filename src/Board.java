package mancala;

public class Board {
     public static void ShowBoard(byte[] a, String p1, String p2)
        {
            //Idx Oponents fields.
            System.out.printf("     %s\n",p2);
            for(byte i = 11; i >= 6; i--)
                System.out.printf("%6d",i);
            System.out.print("\n   ");
            
            //Nº Seeds
            for(byte i = 11; i >= 6; i--)
                System.out.printf("< %d > ",a[i]);
            
            //General field to store seeds
            System.out.println();
            System.out.print("[X]\t\t\t\t       [X]\n");
            System.out.printf(" %s\t\tMANCALA AWARI\t\t%s\n",a[13],a[12]);
            System.out.print("[X]\t\t\t\t       [X]");
            System.out.println();
            System.out.print("   ");
            
            //Nº Seeds Player
            for(byte i = 0; i <= 5; i++)
                System.out.printf("< %d > ",a[i]);
            System.out.println();
            
            //Idx Fields Player
            for(byte i = 0; i <= 5; i++)
                System.out.printf("%6d",i);
            System.out.print("\n   ");
            System.out.printf("\t\t\t\t %s\n",p1);
            System.out.println("-----------------------------------------");
        }
}
