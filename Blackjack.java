import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");

        // 3. Wait for the user to press enter.
        scan.nextLine();

        // 4. Get two random cards.
        int card1 = drawRandomCard();
        int card2 = drawRandomCard();
        System.out.println("\n You get a \n" + cardString(card1) + "\n and a \n" + cardString(card2));

        // 5. Print the sum of your hand value.
        int playerHandTotal = Math.min(10, card1) + Math.min(10, card2);
        System.out.println("\nYour total is: " + playerHandTotal);

        // 6. Get two random cards for the dealer.
        //    – Print: The dealer shows \n" + <first card> + "\nand has a card facing down \n" + <facedown card>
        //    – Print: \nThe dealer's total is hidden
        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();
        
        int dealerHandTotal = Math.min(10, dealerCard1) + Math.min(10, dealerCard2);

        System.out.println("\nThe dealer shows \n" + cardString(dealerCard1) + "\n and has a card facing down \n" + faceDown());
        System.out.println("\nThe Dealer's total is hidden.");

        // 7b. Check for blackjack in both player's and dealer's hands and ends the game if necessary
        blackjack(card1, card2, dealerCard1, dealerCard2);
       
        // 9. Keep asking the player to hit or stay (while loop).
        // a. Every time the player hits
        //    – draw a new card.
        //    – calculate their new total.
        //    – print: (new line) You get a (new line) <show new card>.
        //    - print: your new total is <total>

        // b. Once the player stays, break the loop. 

        while (true) {
            String playerChoice = hitOrStay();

            if (playerChoice.equalsIgnoreCase("stay")) {
                break;
            } 

            int newPlayerCard = drawRandomCard();
            playerHandTotal += Math.min(10, newPlayerCard);

            System.out.println("\n You get a: \n" + cardString(newPlayerCard));
            System.out.println("Your new total is " + playerHandTotal);
            
            if (playerHandTotal > 21) {
                System.out.println("\nBust! Player loses!\n");
                System.exit(0);
            }
        }

        // Dealer's turn and 'choice' to draw if player stays his/her hand => similar process as the above while loop:

        System.out.println("\nDealer's turn.");
        System.out.println("\nThe dealer's cards are \n" + cardString(dealerCard1) + "\nand a \n" + cardString(dealerCard2));

        while (dealerHandTotal < 17) {
            int newDealerCard = drawRandomCard();
            dealerHandTotal += Math.min(10, newDealerCard);

            System.out.println("\nDealer gets a \n" + cardString(newDealerCard));
            System.out.println("\nDealer's new total is " + dealerHandTotal);
        }

        if (dealerHandTotal > 21) {
            System.out.println("\nBust! Dealer loses! You won!\n");
            System.exit(0);
        }
        
        // Compare final score and print winner if both player and computer does not bust their hands after their last hits:
        System.out.println("\nOk, no more bets!\n");
        System.out.println("Final Player Total: " + playerHandTotal);
        System.out.println("Final Dealer Total: " + dealerHandTotal + "\n");

        if (playerHandTotal > dealerHandTotal) {
            System.out.println("Player wins! Congrats!\n");
        } else if (dealerHandTotal > playerHandTotal) { 
            System.out.println("Sorry, Dealer wins!\n");
        } else {
            System.out.println("It is a draw!\n");
        }
      
        scan.close();
    }

    /** 1. make a function that returns a random number between 1 and 13
     * Function name – drawRandomCard
     * @return (int)
     *
     * Inside the function:
     *   a. Gets a random number between 1 and 13.
     *   b. Returns a card.
     */

     public static int drawRandomCard() {
         return (int)(Math.random() * 13 + 1);
     }

    /** 2. Make a function that returns a String drawing of the card.
     * Function name – cardString
     * @param cardNumber (int)
     * @return (String)
     *
     * Inside the function:
     *  · Returns a String drawing of the card.
     */

     public static String cardString(int cardNumber) {
         return switch (cardNumber) {
             case 1 -> """
                        _____
                       |A _  |
                       | ( ) |
                       |(_'_)|
                       |  |  |
                       |____A|
                     """;

             case 2 -> """
                        _____
                       |2    |
                       |  o  |
                       |     |
                       |  o  |
                       |____2|
                     """;

             case 3 -> """
                        _____
                       |3    |
                       | o o |
                       |     |
                       |  o  |
                       |____3|
                     """;

             case 4 -> """
                        _____
                       |4    |
                       | o o |
                       |     |
                       | o o |
                       |____4|
                     """;

             case 5 -> """
                        _____\s
                       |5    |
                       | o o |
                       |  o  |
                       | o o |
                       |____5|
                     """;

             case 6 -> """
                        _____\s
                       |6    |
                       | o o |
                       | o o |
                       | o o |
                       |____6|
                     """;

             case 7 -> """
                        _____\s
                       |7    |
                       | o o |
                       |o o o|
                       | o o |
                       |____7|
                     """;

             case 8 -> """
                        _____\s
                       |8    |
                       |o o o|
                       | o o |
                       |o o o|
                       |____8|
                     """;

             case 9 -> """
                        _____\s
                       |9    |
                       |o o o|
                       |o o o|
                       |o o o|
                       |____9|
                     """;

             case 10 -> """
                        _____\s
                       |10  o|
                       |o o o|
                       |o o o|
                       |o o o|
                       |___10|
                     """;

             case 11 -> """
                        _____
                       |J  ww|
                       | o {)|
                       |o o% |
                       | | % |
                       |__%%J|
                     """;

             case 12 -> """
                        _____
                       |Q  ww|
                       | o {(|
                       |o o%%|
                       | |%%%|
                       |_%%%Q|
                     """;

             case 13 -> """
                        _____
                       |K  WW|
                       | o {)|
                       |o o%%|
                       | |%%%|
                       |_%%%K|
                     """;
                     
             default -> "This shouldn't get called.";
         };
     }

    public static String faceDown() {
        return
                """
                   _____
                  |     |
                  |  J  |
                  | JJJ |
                  |  J  |
                  |_____|
                """;
    }
    
    /** 8. Make a function that asks the user to hit or stay.
     * Function name – hitOrStay
     * @return (String)
     *
     * Inside the function:
     *   a. Asks the user to hit or stay.
     *   b. If the user doesn't enter "hit" or "stay", keep asking them to try again by printing:
     *      Please write 'hit' or 'stay'
     *   c. Returns the user's option 
     */

     public static String hitOrStay() {
        String response;
        System.out.println("\nDo you wish to hit or stay?");

        while(true) {
            response = scan.nextLine();

            if (response.equalsIgnoreCase("hit") || response.equalsIgnoreCase("stay")) {
                break;
            }

            System.out.println("\nPlease response 'hit' or 'stay'.");
        }
        return response;
    }

    /** 7a. Make a function that checks if either player's and dealer's hand hits blackjack immediately after the first round of dealing cards:
     * Function name - blackjack
     * 
     * @param playerCard1 (int)
     * @param playerCard2 (int)
     * @param dealerCard1 (int)
     * @param dealerCard2 (int)
     * Inside the function:
     *  a. Checks for the hand of player and dealer.
     *  b. If either has a blackjack, the game is won by that hand.
     *  c. If both player and dealer have blackjacks, it is a draw.
     *  d. If a - c is not fulfilled, the game continues.
     * 
     */

    public static void blackjack(int playerCard1, int playerCard2, int dealerCard1, int dealerCard2) {
        if (playerCard1 == 1 && playerCard2 == 1) {
            if (dealerCard1 != 1 || dealerCard2 != 1) {
                System.out.println("\nThe Dealer reveals the facedown card is\n" + cardString(dealerCard2));
                System.out.println("\nBlackjack! Player wins the game!\n");
                System.exit(0);
            }
        }

        if (dealerCard1 == 1 && dealerCard2 == 1) {
            if (playerCard1 != 1 || playerCard2 != 1) {
                System.out.println("\nThe Dealer reveals the facedown card is\n" + cardString(dealerCard2));
                System.out.println("\nSorry, you lose! The Dealer has a Blackjack!\n");
                System.exit(0);
            }
        }

        if (playerCard1 == 1 && playerCard2 == 1) {
            System.out.println("\nThe Dealer reveals the facedown card is\n" + cardString(dealerCard2));
            System.out.println("\nIt is a push! Both Player and Dealer got a Blackjack!\n");
            System.exit(0);
        }
    }
}


