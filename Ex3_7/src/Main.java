class TestPlayer {
    public static void main(String[] args) {
        Ball ball = new Ball(0, 0, 0);
        Player player1 = new Player(1, 5, 5, 0);
        Player player2 = new Player(2, 10, 10, 0);
        System.out.println("Initial Ball position: " + ball);
        System.out.println(player1);
        System.out.println(player2);
        System.out.println("\nIs player 1 near the ball? " + player1.near(ball));
        System.out.println("Is player 2 near the ball? " + player2.near(ball));
        player1.move(3, 3);
        player1.jump(2);
        System.out.println("\nPlayer 1 moved and jumped: " + player1);
        System.out.println("\nIs player 1 near the ball? " + player1.near(ball));
        player1.kick(ball);
        System.out.println("\nAfter player 1 kicks the ball: " + ball);
    }
}