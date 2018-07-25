import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class sokoban {
    public static void main(String[] args) {
        Random random = new Random();

        //        enemy run:
        int run_up = 1;
        int run_right = 1;
//        create map :
//        for (int i = 0; i <7; i += 1) {
//            for (int j = 0; j <7; j += 1) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//        add player:
        int player_x = random.nextInt(1)+1;
        int player_y = random.nextInt(5)+1;

        list  <Integer> player;
        player = new ArrayList<Integer>();
        ((ArrayList) player).add(player_x);
        ((ArrayList) player).add(player_y);
        System.out.println();
//        create enemy :
//        enemy move up :
        int enemy_up_x;
        int enemy_up_y;
        do {
            enemy_up_x = random.nextInt(5)+1;
            enemy_up_y = random.nextInt(5)+1;
        } while ( enemy_up_x == player_x || enemy_up_y == player_y);
// create enemy move right:
        int enemy_right_x;
        int enemy_right_y;
        do {
            enemy_right_x = random.nextInt(5)+1;
            enemy_right_y = random.nextInt(5)+1;
        } while ( enemy_right_x == player_x || enemy_right_y == player_y);

//        create gift :
        int gift_x;
        int gift_y;
        do {gift_x = random.nextInt(1)+ 5;
            gift_y = random.nextInt(5)+1;
        } while (gift_y == player_y);

        while (true){

            for (int i = 0; i <7; i += 1) {

                for (int j = 0; j <7; j += 1) {
                    //        check:
                    boolean player_is_here = false;
                    boolean enemy_up_is_here = false;
                    boolean enemy_right_is_here = false;
                    boolean gift_is_here = false;
                    boolean wall_is_here = false;
                    if (player_x == i && player_y == j) {
                        player_is_here = true;

                    }
                    if (enemy_up_x == i && enemy_up_y == j) {
                        enemy_up_is_here = true;

                    }
                    if (enemy_right_x == i && enemy_right_y == j) {
                        enemy_right_is_here = true;

                    }
                    if (gift_x == i && gift_y == j) {
                        gift_is_here = true;

                    }
                    if (i == 0 || i == 6 || j == 0 || j == 6){
                        wall_is_here = true;
                    }
                    if (player_is_here) {
                        System.out.print("+  ");
                    } else if (enemy_up_is_here){
                        System.out.print("!  ");
                    } else if (enemy_right_is_here){
                        System.out.print("?  ");
                    }else if (gift_is_here){
                        System.out.print("G  ");
                    }else if (wall_is_here){
                        System.out.print("*  ");
                    } else{
                        System.out.print("-  ");
                    }

                }
                System.out.println();





            }
            //            input move:
            System.out.println("Your move: ");
            Scanner scanner = new Scanner(System.in);
            String user_input = scanner.next();
            if (user_input.equals("a")){
                if (player_y == 0 ){
                    player_y = player_y;
                }else {
                    player_y += -1;
                }

            } else if (user_input.equals("d")){
                if (player_y == 6){
                    player_y = player_y;
                }else {
                    player_y += 1;
                }
            }else if (user_input.equals("w")){
                if (player_x == 0 ){
                    player_x = player_x;
                }else {
                    player_x += -1;
                }
            }else if (user_input.equals("s")){
                if (player_x == 6){
                    player_x = player_x;
                }else {
                    player_x += 1;
                }
            }

            if (enemy_right_x == 5){
                run_right = -1;
            }else if (enemy_right_x == 1){
                run_right = 1;
            }
            enemy_right_x += run_right;
            if (enemy_up_y ==  5){
                run_up = -1;
            }else if (enemy_up_y == 1){
                run_up = 1;
            }
            enemy_up_y += run_up;
            if (player_x == gift_x && player_y == gift_y){
                System.out.println("You win");
                break;
            }else if (player_x == enemy_right_x && player_y == enemy_right_y){
                System.out.println("You lose");
                break;
            }else if (player_x == enemy_up_x && player_y == enemy_up_y){
                System.out.println("You lose");
                break;
            }
            player.set(0,player_x);
            player.set(1,player_y);





        }



    }






    }

